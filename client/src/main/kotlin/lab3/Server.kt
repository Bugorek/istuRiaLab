package lab3

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ServerStatus(
    @SerializedName("ServerStatus")
    val status: String
)