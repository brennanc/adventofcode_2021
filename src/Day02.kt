fun main() {
    fun part1(input: List<String>): Int {
        var h = 0
        var d = 0
        val ops = input.map { it.split(' ') }
                       .map { it -> listOf(it[0].get(0), it[1].toInt())  }
        for (op in ops) {
            val v : Int = op[1] as Int
            when (op[0]) {
                'f' -> h += v
                'd' -> d += v
                'u' -> d -= v
            }
        }
        return d * h
    }

    fun part2(input: List<String>): Int {
        var a = 0
        var h = 0
        var d = 0
        val ops = input.map { it.split(' ') }
            .map { it -> listOf(it[0].get(0), it[1].toInt())  }
        for (op in ops) {
            val v : Int = op[1] as Int
            when (op[0]) {
                'f' -> { h += v; d += a * v }
                'd' -> a += v
                'u' -> a -= v
            }
        }
        return d * h
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}