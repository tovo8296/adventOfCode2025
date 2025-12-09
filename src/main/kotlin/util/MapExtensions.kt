package util

import kotlin.math.max
import kotlin.math.min


fun <T> List<List<T>>.findCoord(predicate: (T) -> Boolean): Coord? {
    this.forEachIndexed { y, line ->
        val x = line.indexOfFirst(predicate)
        if (x != -1) {
            return Coord(x, y)
        }
    }
    return null
}

fun <T> List<List<T>>.get(coord: Coord): T? = this.getOrNull(coord.y)?.getOrNull(coord.x)

fun <T> List<MutableList<T>>.set(coord: Coord, value: T) = this.getOrNull(coord.y)?.set(coord.x, value)

val <T> List<List<T>>.height: Int
    get() = this.size

val <T> List<List<T>>.width: Int
    get() = if (this.size > 0) this[0].size else 0

fun IntRange.intersects(other: IntRange): Boolean =
    this.contains(other.first) || this.contains(other.last) || other.contains(this.first) || other.contains(this.last)

fun Pair<Coord, Coord>.toXRange(): IntRange =
    min(first.x, second.x)..max(first.x, second.x)

fun Pair<Coord, Coord>.toYRange(): IntRange =
    min(first.y, second.y)..max(first.y, second.y)