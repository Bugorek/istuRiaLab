package lab1.xml

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class InputXML (
    @SerialName("Input") val input : Input
)

@Serializable
data class Input (
    @SerialName("K") val k : Int,
    @SerialName("Muls") val muls : Muls,
    @SerialName("Sums") val sums : Sums
)

@Serializable
data class Muls (
    @SerialName("int") val int : List<Int>
)

@Serializable
data class Sums (
    @SerialName("decimal") val decimal : List<Double>
)

fun String.toXmlObject() = Json.decodeFromString<InputXML>(this)

fun InputXML.toInputObject() = lab1.Input(
    k = input.k,
    sums = input.sums.decimal,
    muls = input.muls.int
)
