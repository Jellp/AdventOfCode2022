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

var visibleTrees = 0

while (y < trees.size) {
    x = 0
    while (x < trees[y].size) {
        if (x == 0 || y == 0 || x == trees[y].size - 1 || y == trees.size - 1) visibleTrees++
        else {
            if (trees[y].take(x).max() < trees[y][x] || trees[y].drop(x + 1).max() < trees[y][x]) {
                visibleTrees++
            }
            else if (trees.take(y).maxOf { it[x] } < trees[y][x] || trees.drop(y+1).maxOf { it[x] } < trees[y][x]) {
                visibleTrees++
            }
        }
        x++
    }
    y++
}


println(visibleTrees)
