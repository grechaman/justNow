package ru.netology

fun main() {

    fun converseTime(time: Int, dataIn: String): String {
        val utilityTime: Int = when (dataIn) {
            "минуты" -> time / 60
            "часы" -> time / (60 * 60)
            else -> 0
        }
        val minutesOrHours = when {
            dataIn == "минуты" && (utilityTime % 10 == 1) && (utilityTime != 11) -> "минуту"
            dataIn == "минуты" && (utilityTime % 10 in 2..4) -> "минуты"
            dataIn == "минуты" -> "минут"
            dataIn == "часы" && utilityTime % 10 == 1 -> "час"
            dataIn == "часы" && utilityTime % 10 in 2..4 -> "часа"
            dataIn == "часы" -> "часов"
            else -> null
        }
        return "$utilityTime $minutesOrHours"
    }

    fun agoToText(time: Int): String {
        val ago = when {
            time <= 60 -> "Только что"
            time <= 60 * 60 -> "${converseTime(time, "минуты")} назад"
            time <= 60 * 60 * 24 -> "${converseTime(time, "часы")} назад"
            time <= 60 * 60 * 24 * 2 -> "Сегодня"
            time <= 60 * 60 * 24 * 3 -> "Вчера"
            time > 60 * 60 * 24 * 3 -> "Давно"
            else -> "В сети"
        }
        return ago
    }
    println(agoToText(5))
    println(agoToText(61))
    println(agoToText(3601))
    println(agoToText(86401))
    println(agoToText(172801))
    println(agoToText(259201))
}