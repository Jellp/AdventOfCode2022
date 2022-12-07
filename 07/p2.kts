import java.io.File

val input = File("input").readLines()

interface FileSystem {
    val name: String
    fun size(): Int
}

class Directory(override val name: String, val parent: Directory? = null) : FileSystem {
    val children = mutableListOf<FileSystem>()

    override fun size(): Int {
        return children.sumOf { it.size() }
    }
}

val root = Directory("/")
var cursor = root

class File(override val name: String, val parent: Directory, val size: Int) : FileSystem {
    override fun size(): Int {
        return size
    }
}

// Parsing
for (line in input) {
    val splitLine = line.split(' ')
    if (line.first() == '$') {
        // Command
        if (splitLine[1] == "cd") {
            if (splitLine[2] == "/") { cursor = root; continue }
            if (splitLine[2] == "..") { cursor = cursor.parent!!; continue }
            val newCursor = cursor.children.first { it.name == splitLine[2] }
            if (newCursor is Directory) cursor = newCursor
        }
        // ls doesnt matter to us
    }
    else if (line.first().isLetter()) {
        // ls result: Directory
        cursor.children.add(Directory(splitLine[1], cursor))
    }
    else {
        // ls result: File
        cursor.children.add(File(splitLine[1], cursor, splitLine[0].toInt()))
    }
}

val sizesList = mutableListOf<Int>()

fun addSizes(cursor: FileSystem) {
    if (cursor is Directory) {
        sizesList.add(cursor.size())
        cursor.children.map { addSizes(it) }
    }
}

addSizes(root)

println("free space: ${70000000 - root.size()}")
println("to free up: ${30000000 - (70000000 - root.size()) }")

println(sizesList.filter { it >= 30000000 - (70000000 - root.size())  }.min())
