package com.codurance

fun scoreFor(allRolls: String): Int {
 var score = 0
 for (roll in allRolls) {
  score += score(roll)
 }

 return score
}

private fun score(roll: Char) =
        when(roll) {
         in '1'.. '9' -> String(charArrayOf(roll)).toInt()
         else -> 0
        }

