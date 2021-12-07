import lab1.*
import lab1.xml.toInputObject
import lab1.xml.toXmlObject
import org.json.XML

fun main(args: Array<String>) {
//    Лаба1
    print("Введите строку:")
    val line = readLine()
    var input: Input? = null
    line?.let {
        input = if (it.first() == '<') {
            val jsonObject = XML.toJSONObject(line)
            jsonObject.toString(2).toXmlObject().toInputObject()
        } else {
            line.toObject()
        }
    }
    val result = input?.calculate()
    val output = result?.toJson()
    println("Результат: $output")
}

//<Input><K>10</K><Sums><decimal>1.01</decimal><decimal>2.02</decimal></Sums><Muls><int>1</int><int>4</int></Muls></Input>
//{"K":10,"Sums":[1.01,2.02],"Muls":[1,4]}

