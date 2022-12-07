fun main() {
    fun part1(input: List<String>): Int {
        var string = ""
        input.forEach { line ->
            val firstCompartment = line.substring(0, line.length / 2)
            val secondCompartment = line.substring(line.length / 2, line.length)
            string += firstCompartment.first { letter ->
                secondCompartment.any { secondLetter -> letter == secondLetter }
            }
        }

        var sum = 0
        ('a'..'z').forEachIndexed { index, c ->
            sum += string.count { it == c } * (index + 1)
        }
        ('A'..'Z').forEachIndexed { index, c ->
            sum += string.count { it == c } * (index + 27)
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var string = ""
        input.windowed(3, 3).forEach { window ->
            val mappedWindow = window.map { it.toList().distinct() }
            string += mappedWindow.first().first { letter ->
                mappedWindow[1].any { l -> l == letter } && mappedWindow[2].any { l -> l == letter }
            }
        }

        var sum = 0
        ('a'..'z').forEachIndexed { index, c ->
            sum += string.count { it == c } * (index + 1)
        }
        ('A'..'Z').forEachIndexed { index, c ->
            sum += string.count { it == c } * (index + 27)
        }
        return sum
    }

    val input = readInput("Day03")


    println(part1(input))
    println(part2(input))

}