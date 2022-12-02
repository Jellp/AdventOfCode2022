import java.io.File
import java.lang.IllegalStateException

val input = File("input").readLines()

var score = 0

fun scoreToAdd(choice: String, lose: Int, draw: Int, win: Int): Int {
    return when (choice) {
        "X" -> lose
        "Y" -> draw + 3
        "Z" -> win + 6
        else -> throw IllegalStateException("Received $choice")
    }
}

for (line in input) {
    val choices = line.split(' ')
    // 2 switches to add score
    when (choices.first()) {
        "A" -> {
            // Rock
            score += scoreToAdd(choices.last(), 3, 1, 2)
        }
        "B" -> {
            // Paper
            score += scoreToAdd(choices.last(), 1, 2, 3)
        }
        "C" -> {
            // Scissors
            score += scoreToAdd(choices.last(), 2, 3, 1)
        }
    }
}

println("$score")
