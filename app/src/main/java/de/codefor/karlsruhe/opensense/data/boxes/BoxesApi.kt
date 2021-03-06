package de.codefor.karlsruhe.opensense.data.boxes

import de.codefor.karlsruhe.opensense.data.boxes.model.SenseBox
import de.codefor.karlsruhe.opensense.data.boxes.model.SensorHistory
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BoxesApi {
    @GET("boxes/{boxId}")
    fun getBox(@Path("boxId") boxId: String) : Single<SenseBox>

    @GET("boxes")
    fun getAllBoxes(@Query("minimal") minimal: Boolean = true): Single<List<SenseBox>>

    @GET("boxes/{boxId}/data/{sensorId}")
    fun getSensorHistory(@Path("boxId") boxId: String, @Path("sensorId") sensorId: String): Single<List<SensorHistory>>
}