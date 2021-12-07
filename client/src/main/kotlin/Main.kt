import lab1.*
import lab2.RetrofitServices
import lab3.ServerStatus
import lab3.UserAnswerStatus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main(args: Array<String>) {
    getPing()
    getInputData()
    writeAnswer()
}

fun getPing() {
    val service = RetrofitServices.retrofitService
    service?.getServerStatus()?.enqueue(object : Callback<ServerStatus>{
        override fun onResponse(call: Call<ServerStatus>, response: Response<ServerStatus>) {
            val serverAnswer = response.body()
            print("${serverAnswer?.status}")
        }

        override fun onFailure(call: Call<ServerStatus>, t: Throwable) {
            print("Ошибка")
        }

    })
}

fun getInputData() {
    val service = RetrofitServices.retrofitService
    service?.getInputData()?.enqueue(object : Callback<Input>{
        override fun onResponse(call: Call<Input>, response: Response<Input>) {
            print("${response.body()}")
        }

        override fun onFailure(call: Call<Input>, t: Throwable) {
            print("Ошибка")
        }
    })
}

fun writeAnswer() {
    val service = RetrofitServices.retrofitService
    val answer = Output(
        sumResult = 30.300000000000004,
        mulResult = 4,
        sortedInputs = listOf(1.0, 1.01, 2.02, 4.0)
    )
    service?.writeAnswer(answer)?.enqueue(object : Callback<UserAnswerStatus>{
        override fun onResponse(call: Call<UserAnswerStatus>, response: Response<UserAnswerStatus>) {
            print("${response.body()}")
        }

        override fun onFailure(call: Call<UserAnswerStatus>, t: Throwable) {
            print("Ошибка")
        }
    })
}

