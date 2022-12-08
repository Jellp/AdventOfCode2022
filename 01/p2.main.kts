import java.io.File

val input = File("input").readLines()

val elves = mutableListOf<MutableList<Int>>()
elves.add(mutableListOf<Int>())

for (line in input) {
    if (line.isNullOrBlank()) {
        elves.add(mutableListOf<Int>())
    } else {
        elves.last().add(line.toInt())
    }
}

val TotalCalories = elves.map { it.sum() }.sortedDescending()
val max = TotalCalories.take(3).sum()

println("The top 3 elves have $max calories")
