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
        var firstSum = 0
        var secondSum = 0
        var thirdSum = 0
        var actualSum = 0

        input.forEach { inputLine ->
            if (inputLine.isNotEmpty()) {
                actualSum += inputLine.toInt()
            } else {
                if (actualSum > firstSum) {
                    thirdSum = secondSum
                    secondSum = firstSum
                    firstSum = actualSum
                } else if (actualSum > secondSum) {
                    thirdSum = secondSum
                    secondSum = actualSum
                } else if (actualSum > thirdSum) {
                    thirdSum = actualSum
                }
                actualSum = 0
            }
        }
        return firstSum + secondSum + thirdSum
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
