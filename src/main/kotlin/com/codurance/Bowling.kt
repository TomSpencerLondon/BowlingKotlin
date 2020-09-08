package com.codurance

private const val MISS = '-'
private const val SPARE = '/'

fun scoreFor(allRolls: String): Int =
        allRolls.foldIndexed(0) { idx, score, roll ->
            score + score(roll) - spareDiff(allRolls, roll, idx)
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
            SPARE -> 10
            else -> 0
        }

