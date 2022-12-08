import java.io.File

val input = File("input").readLines()

val trees = mutableListOf<MutableList<Int>>()
var row = 0

// Parse
for (line in input) {
    trees.add(mutableListOf<Int>())
    for (char in line) {
        trees[row].add(char.digitToInt())
    }
    row++
}

// Process
var x = 0
var y = 0

val scores = mutableListOf<Int>()

while (y < trees.size) {
    x = 0
    while (x < trees[y].size) {

        if (x == 0 || y == 0 || x == trees[y].size - 1 || y == trees.size - 1)
        else {
            val height = trees[y][x]
            println("Checking $x, $y with height ${trees[y][x]}")

            val upTrees = trees.take(y).map { it[x] }.reversed()
            var upScore = getScore(height, upTrees)
            val downTrees = trees.drop(y+1).map {it[x]}
            var downScore = getScore(height, downTrees)

            val leftTrees = trees[y].take(x).reversed()
            var leftScore = getScore(height, leftTrees)
            val rightTrees = trees[y].drop(x+1)
            var rightScore = getScore(height, rightTrees)

            println("Up: $upScore @$upTrees;")
            println("Down: $downScore @$downTrees")
            println("Left: $leftScore @$leftTrees")
            println("Right: $rightScore @$rightTrees")

            val score = upScore * downScore * leftScore * rightScore
            scores.add(score)
        }
        x++
    }
    y++
}


println(scores.max())

fun getScore(height: Int, view: List<Int>): Int {
    var i = 0
    while (i < view.size) {
        if (view[i] >= height) return i + 1
        i++
    }
    return view.size
}
