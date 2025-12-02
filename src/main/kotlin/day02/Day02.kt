package day02

fun main() {
    val intervals = parse(input)
    val invalidIds = intervals.map { findInvalidIDs(it) }.flatten().sum()
    println("Invalid IDs: $invalidIds")
}

fun findInvalidIDs(range: LongRange): List<Long> {
    return range.filter { isInvalidId(it) }
}

fun isInvalidId(n: Long): Boolean {
    val s = n.toString()
    if (s.length % 2 != 0) {
        return false
    }
    val p1 = s.substring(0, s.length / 2)
    val p2 = s.substring(s.length / 2)
    return p1 == p2
}

fun parse(line: String): List<LongRange> {
    return line.split(",").map { interval ->
        val numbers = interval.split("-").map { it.toLong() }
        numbers[0]..numbers[1]
    }
}


val input = """
82853534-82916516,2551046-2603239,805115-902166,3643-7668,4444323719-4444553231,704059-804093,32055-104187,7767164-7799624,25-61,636-1297,419403897-419438690,66-143,152-241,965984-1044801,1-19,376884-573880,9440956-9477161,607805-671086,255-572,3526071225-3526194326,39361322-39455443,63281363-63350881,187662-239652,240754-342269,9371-26138,1720-2729,922545-957329,3477773-3688087,104549-119841
""".trimIndent()