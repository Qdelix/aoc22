fun main() {

    fun part1(input: List<String>): Int {
        var position = 0
        val windowSize = 4
        val windows = input[0].windowed(windowSize)
        windows.forEachIndexed { index, s ->
            if (position == 0 && s.toCharArray().distinct().size == windowSize) {
                position = index + windowSize
            }
        }
        return position
    }

    fun part2(input: List<String>): Int {
        var position = 0
        val windowSize = 14
        val windows = input[0].windowed(windowSize)
        windows.forEachIndexed { index, s ->
            if (position == 0 && s.toCharArray().distinct().size == windowSize) {
                position = index + windowSize
            }
        }
        return position
    }

    val input = readInput("Day06")

    println(part1(input))
    println(part2(input))
}