import java.io.File
import java.lang.IllegalStateException

val input = File("input").readLines()

var score = 0

fun scoreToAdd(choice: String, rock: Int, paper: Int, scissors: Int): Int {
    return when (choice) {
        "X" -> rock + 1
        "Y" -> paper + 2
        "Z" -> scissors + 3
        else -> throw IllegalStateException("Received $choice")
    }
}

for (line in input) {
    val choices = line.split(' ')
    // 2 switches to add score
    when (choices.first()) {
        "A" -> {
            // Rock
            score += scoreToAdd(choices.last(), 3, 6, 0)
        }
        "B" -> {
            // Paper
            score += scoreToAdd(choices.last(), 0, 3, 6)
        }
        "C" -> {
            // Scissors
            score += scoreToAdd(choices.last(), 6, 0, 3)
        }
    }
    println(score)
}

println("$score")
