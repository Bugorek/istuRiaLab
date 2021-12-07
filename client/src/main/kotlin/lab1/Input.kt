package lab1

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class Input (
    @SerializedName("K")
    val k: Int,
    @SerializedName("Sums")
    val sums: List<Double>,
    @SerializedName("Muls")
    val muls: List<Int>
)

fun String.toObject() = Json.decodeFromString<Input>(this)

fun Input.calculate(): Output {
    val sumResult = sums.sum() * k
    val mulResult = muls.reduce { acc, i -> acc * i }
    val sortedInputs: MutableList<Double> = mutableListOf()
    sortedInputs.addAll(muls.map { it.toDouble() })
    sortedInputs.addAll(sums)
    sortedInputs.sort()
    return Output(
        sumResult = sumResult,
        mulResult = mulResult,
        sortedInputs = sortedInputs
    )
}