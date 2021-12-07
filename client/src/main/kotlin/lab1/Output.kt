package lab1

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class Output(
    @SerializedName("SumResult")
    val sumResult: Double,
    @SerializedName("MulResult")
    val mulResult: Int,
    @SerializedName("SortedInputs")
    val sortedInputs: List<Double>
)

fun Output.toJson() = Json.encodeToString(this)