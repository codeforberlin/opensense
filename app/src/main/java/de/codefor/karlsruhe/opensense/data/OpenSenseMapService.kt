package de.codefor.karlsruhe.opensense.data

import de.codefor.karlsruhe.opensense.data.boxes.BoxesApi
import de.codefor.karlsruhe.opensense.data.boxes.model.SenseBox
import de.codefor.karlsruhe.opensense.data.boxes.model.SensorHistory
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.logging.Logger


object OpenSenseMapService {

    val LOG = Logger.getLogger(this::class.java.toString())

    private val boxesApi: BoxesApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.opensensemap.org/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        boxesApi = retrofit.create(BoxesApi::class.java)
    }

    fun getBox(boxId: String): Single<SenseBox> {
        return boxesApi.getBox(boxId)
    }

    fun getAllBoxes(): Single<List<SenseBox>> {
        return boxesApi.getAllBoxes()
    }

    fun getSensorHistory(boxId: String, sensorId: String): Single<List<SensorHistory>> {
        LOG.info("returning sensor history, boxId: " + boxId + ", sensorId: " + sensorId)
        return boxesApi.getSensorHistory(boxId, sensorId)
    }
}