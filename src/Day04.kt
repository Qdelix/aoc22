fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach { pair ->
            val first = pair.substringBefore(",")
            val second = pair.substringAfter(",")
            val firstPair = Pair(first.substringBefore("-").toInt(), first.substringAfter("-").toInt())
            val secondPair = Pair(second.substringBefore("-").toInt(), second.substringAfter("-").toInt())
            if (firstPair.fullyContain(secondPair) || secondPair.fullyContain(firstPair)) {
                sum += 1
            }
        }
        return sum
    }


    fun part2(input: List<String>): Int {
        var sum = 0
        input.forEach { pair ->
            val first = pair.substringBefore(",")
            val second = pair.substringAfter(",")
            val firstPair = Pair(first.substringBefore("-").toInt(), first.substringAfter("-").toInt())
            val secondPair = Pair(second.substringBefore("-").toInt(), second.substringAfter("-").toInt())
            if (firstPair.contain(secondPair) || secondPair.contain(firstPair)) {
                sum += 1
            }
        }
        return sum
    }

    val input = readInput("Day04")


    println(part1(input))
    println(part2(input))

}

fun Pair<Int, Int>.fullyContain(pair: Pair<Int, Int>): Boolean {
    return this.first <= pair.first && this.second >= pair.second
}

fun Pair<Int, Int>.contain(pair: Pair<Int, Int>): Boolean {
    return (this.first <= pair.first && this.second >= pair.first) ||
            (this.first >= pair.first && this.second <= pair.first)
}