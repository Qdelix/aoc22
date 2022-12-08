fun main() {
    fun initMap() = mutableMapOf<Int, MutableList<String>>(
        1 to mutableListOf(),
        2 to mutableListOf(),
        3 to mutableListOf(),
        4 to mutableListOf(),
        5 to mutableListOf(),
        6 to mutableListOf(),
        7 to mutableListOf(),
        8 to mutableListOf(),
        9 to mutableListOf()
    )

    fun part1(input: List<String>): String {
        val map = initMap()
        val crates = input.take(8)
        crates.forEach { line ->
            line.drop(1).windowed(1, 4).forEachIndexed { index, s ->
                if (s != " ") {
                    map[index + 1]?.add(0, s)
                }
            }
        }
        input.drop(10).forEach { line ->
            val move = line.drop(5).takeWhile { c -> c.toString() != " " }.toInt()
            val from = line.substringAfter("from ").take(1).toInt()
            val to = line.substringAfter("to ").take(1).toInt()

            for (i in 0 until move) {
                map[from]?.last()?.let {
                    map[to]?.add(it)
                    map[from]?.removeLast()
                }
            }
        }
        var result = ""
        map.forEach { l -> result += l.value.last() }
        return result
    }

    fun part2(input: List<String>): String {
        val map = initMap()
        val crates = input.take(8)
        crates.forEach { line ->
            line.drop(1).windowed(1, 4).forEachIndexed { index, s ->
                if (s != " ") {
                    map[index + 1]?.add(0, s)
                }
            }
        }
        input.drop(10).forEach { line ->
            val move = line.drop(5).takeWhile { c -> c.toString() != " " }.toInt()
            val from = line.substringAfter("from ").take(1).toInt()
            val to = line.substringAfter("to ").take(1).toInt()

            map[from]?.takeLast(move)?.let {
                map[to]?.addAll(it)
            }
            for (i in 0 until move) {
                map[from]?.removeLast()
            }
        }
        var result = ""
        map.forEach { l -> result += l.value.last() }
        return result
    }

    val input = readInput("Day05")

    println(part1(input))
    println(part2(input))
}