fun main() {
    fun part1(input: List<String>): Int {
        var score = 0
        input.forEach { line ->
            val lineWithoutWhiteSpaces = line.filter { !it.isWhitespace() }
            val opponent = lineWithoutWhiteSpaces[0].toString()
            val you = lineWithoutWhiteSpaces[1].toString()
            val opponentMove = Thing.getThing(opponent)
            val yourMove = Thing.getThing(you)

            score += Thing.getRoundResultScore(opponentMove, yourMove)
            score += Thing.getThing(you).points
        }
        return score
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))

}

enum class Thing(val points: Int) {
    SCISSORS(3),
    ROCK(1),
    PAPER(2);

    companion object {
        fun getThing(letter: String): Thing {
            return when (letter) {
                "A", "X" -> ROCK
                "B", "Y" -> PAPER
                "C", "Z" -> SCISSORS
                else -> SCISSORS
            }

        }

        fun getRoundResultScore(opponentMove: Thing, yourMove: Thing): Int {
            val lose = (opponentMove == ROCK && yourMove == SCISSORS) ||
                    (opponentMove == SCISSORS && yourMove == PAPER) ||
                    (opponentMove == PAPER && yourMove == ROCK)
            val draw = opponentMove == yourMove
            val win = (opponentMove == SCISSORS && yourMove == ROCK) ||
                    (opponentMove == PAPER && yourMove == SCISSORS) ||
                    (opponentMove == ROCK && yourMove == PAPER)

            return when {
                draw -> 3
                lose -> 0
                win -> 6
                else -> 0
            }
        }
    }
}
