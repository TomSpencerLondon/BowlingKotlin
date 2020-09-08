package com.codurance

fun scoreFor(allRolls: String): Int {
 var score = 0
 for (roll in allRolls) {
  score += score(roll)
 }

 return score
}

private fun score(roll: Char) = String(charArrayOf(roll)).toInt()

