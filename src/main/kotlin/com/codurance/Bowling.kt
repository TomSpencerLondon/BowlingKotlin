package com.codurance

private const val MISS = '-'
private const val SPARE = '/'
private const val STRIKE = 'X'

fun scoreFor(allRolls: String): Int =
        allRolls.foldIndexed(0) { idx, score, roll ->
            score + score(roll) - spareDiff(allRolls, roll, idx) + bonus(allRolls, roll, idx)
        }

private fun bonus(allRolls: String, roll: Char, idx: Int): Int {
    val next = score(allRolls.next(idx))
    return when (roll) {
        SPARE -> {
            next
        }
        STRIKE -> {
            val nextButOne = score(allRolls.next(idx + 1))
            next + nextButOne - spareDiff(allRolls, allRolls.next(idx + 1), idx + 2)
        }
        else -> 0
    }
}

private fun String.next(idx: Int): Char {
    return if (idx < length - 1) this[idx + 1] else MISS
}

fun spareDiff(allRolls: String, roll: Char, idx: Int): Int {
    return if (roll == SPARE) score(allRolls.previous(idx)) else 0
}

private fun String.previous(idx: Int): Char {
    return if (idx > 0) this[idx - 1] else MISS
}

private fun score(roll: Char) =
        when (roll) {
            in '1'..'9' -> String(charArrayOf(roll)).toInt()
            SPARE, STRIKE -> 10
            else -> 0
        }

