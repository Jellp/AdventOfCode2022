import java.io.File

val input = File("input").readLines()

val parseArea = input.indexOfFirst { it.isBlank() }
val size = input[parseArea - 1].findLast { it.isDigit() }?.digitToInt()
var stacks = MutableList(size!!) { ArrayDeque<Char>() }

// Parse stacks
for (line in input.take(parseArea).reversed().drop(1)) {
    var i = 1
    var j = 0
    while (i < line.length) {
        val c = line[i]
        if (c.isUpperCase()) stacks[j].add(c)
        j++
        i += 4
    }
}

// Process input
for (line in input.drop(parseArea + 1)) {
    val values = line.filter { !it.isLowerCase() }.split(' ').filter { !it.isBlank() }
    val amountToMove = values[0].toInt()
    val from = values[1].toInt() - 1
    val to = values[2].toInt() - 1

    stacks[to].addAll(stacks[from].takeLast(amountToMove))
    var i = 0
    while (i < amountToMove) {
        stacks[from].removeLast()
        i++
    }
}

for (stack in stacks) {
    print(stack.last())
}
