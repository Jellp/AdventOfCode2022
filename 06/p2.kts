import java.io.File

val input = File("input").readLines()[0]

var queue = ArrayDeque<Char>()
queue.addAll(input.take(14).toCharArray().toList())
var processed = 14
println(queue.toString())

while (queue.distinct().size != 14) {
    queue.removeFirst()
    queue.add(input[processed])
    println(queue.toString())
    processed++
}

println(processed)
