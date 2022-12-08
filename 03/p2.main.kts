import java.io.File

val input = File("input").readLines()

var prioSum = 0
var i = 0

while (i < input.size) {
    val common = input[i].filter { input[i+1].contains(it) && input[i+2].contains(it) }
    println("Common element(s?): $common")
    println("Priority: ${toPriority(common.first())}")
    prioSum += toPriority(common.first())
    i += 3
}

println("End result: $prioSum")

fun toPriority(item: Char): Int {
    return if (item.isLowerCase()) {
        item.code - 96
    } else {
        item.code - 38
    }
}
