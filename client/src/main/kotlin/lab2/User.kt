package lab2

import lab1.Input
import lab1.Output
import lab3.ServerStatus
import lab3.UserAnswerStatus
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserQuery {
    @GET("/Ping")
    fun getServerStatus(): Call<ServerStatus>

    @GET("/GetInputData")
    fun getInputData(): Call<Input>

    @POST("/WriteAnswer")
    fun writeAnswer(@Body request: Output): Call<UserAnswerStatus>
}

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}

object RetrofitServices {
    val baseUrl = "http://127.0.0.1:8080"

    val retrofitService: UserQuery?
        get() = RetrofitClient.getClient(baseUrl)?.create(UserQuery::class.java)
}

