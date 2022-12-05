fun main() {
    fun part1(input: List<String>): Int {
        var highestSum = 0
        var actualSum = 0

        input.forEach { inputLine ->
            if (inputLine.isNotEmpty()) {
                actualSum += inputLine.toInt()
            } else {
                if (actualSum > highestSum) {
                    highestSum = actualSum
                }
                actualSum = 0
            }
        }
        return highestSum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
