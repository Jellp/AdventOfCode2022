import java.io.File

val input = File("input").readLines()

var result = 0

for (line in input) {
    val sections = line.split(',')
    val f = sections[0].split('-').map { it.toInt() }
    val s = sections[1].split('-').map { it.toInt() }
    val firstSection = f[0]..f[1]
    val secondSection = s[0]..s[1]


    if (firstSection.all { secondSection.contains(it) } || secondSection.all { firstSection.contains(it) }) {
        result++
        println("One of ${sections[0]} and ${sections[1]} contain one another")
    }
}

println(result)
