package lab1

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class Output(
    @SerialName("SumResult")
    val sumResult: Double,
    @SerialName("MulResult")
    val mulResult: Int,
    @SerialName("SortedInputs")
    val sortedInputs: List<Double>
)

fun Output.toJson() = Json.encodeToString(this)