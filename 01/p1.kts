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

val TotalCalories = elves.map { it.sum() }
val max = TotalCalories.max()
val elf = TotalCalories.indexOf(max)

println("Elf $elf has the most calories: $max")
