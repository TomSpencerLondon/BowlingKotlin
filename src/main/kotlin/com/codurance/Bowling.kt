package com.codurance

fun scoreFor(allRolls: String): Int {
 return allRolls.fold(0) { score, roll ->
  score + score(roll)
 }

// var score = 0
// for (roll in allRolls) {
//  score += score(roll)
// }
//
// return score
}

private fun score(roll: Char) =
        when(roll) {
         in '1'.. '9' -> String(charArrayOf(roll)).toInt()
         else -> 0
        }

