package lab3

import com.google.gson.annotations.SerializedName
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.Serializable
import lab1.Input
import lab1.Output
import lab1.calculate

object Server {
    private var input: Input? = null
    private var answer: Output? = null
    private var server: NettyApplicationEngine? = null

    fun startServer() {
        server = embeddedServer(Netty, port = 8080) {
            install(ContentNegotiation) {
                json()
            }
            routing {
                get("/Ping") {
                    call.respond(ServerStatus(HttpStatusCode.OK.toString()))
                }
                post("/PostInputData") {
                    input = call.receive<Input>()
                    call.respond(ServerStatus("Задача добавлена"))
                }
                get("/GetAnswer") {
                    val rightAnswer = input?.calculate()
                    rightAnswer?.let {
                        call.respond(it)
                    }
                }
                post("Stop") {
                    if (answer != null && answer == input?.calculate()) {
                        call.respond(UserAnswerStatus(true))
                    } else {
                        call.respond(UserAnswerStatus(false))
                    }
                    stopServer()
                }
                get("/GetInputData") {
                    input?.let {
                        call.respond(it)
                    }
                }
                post("/WriteAnswer") {
                    answer = call.receive()
                    if (answer == input?.calculate()) {
                        call.respond(UserAnswerStatus(true))
                    } else {
                        call.respond(UserAnswerStatus(false))
                    }
                }
            }
        }
        server?.start(wait = true)
    }

    private fun stopServer() {
        server?.stop(0, 0)
    }
}

@Serializable
data class ServerStatus(
    @SerializedName("ServerStatus")
    val status: String
)