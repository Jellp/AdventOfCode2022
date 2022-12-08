import java.io.File

val input = File("input").readLines()[0]

var queue = ArrayDeque<Char>()
queue.addAll(input.take(4).toCharArray().toList())
var processed = 4
println(queue.toString())

while (queue.distinct().size != 4) {
    queue.removeFirst()
    queue.add(input[processed])
    println(queue.toString())
    processed++
}

println(processed)
