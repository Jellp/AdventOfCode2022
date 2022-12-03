import java.io.File

val input = File("input").readLines()

var prioSum = 0;

for (line in input) {
    val first = line.take(line.length / 2)
    val second = line.drop(line.length / 2)

    val common = first.filter { second.contains(it) }
    //println("Common element(s?): $common")
    //println("Priority: ${toPriority(common.first())}")
    prioSum += toPriority(common.first())
}

println("End result: $prioSum")

fun toPriority(item: Char): Int {
    return if (item.isLowerCase()) {
        item.code - 96
    } else {
        item.code - 38
    }
}
