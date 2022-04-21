package ru.netology

fun main() {
    println(agoToText(5))
    println(agoToText(61))
    println(agoToText(3601))
    println(agoToText(86401))
    println(agoToText(172801))
    println(agoToText(259201))
}

fun converseTime(time: Int, dataIn: String): String {
    val utilityTime: Int = when (dataIn) {
        "минуты" -> time / 60
        "часы" -> time / (60 * 60)
        else -> 0
    }
    val minutesOrHours =
        if (dataIn == "минуты") selectionUnitTimeMinutes("минуты", utilityTime) else selectionUnitTimeHour(
            "часы",
            utilityTime
        )

    return "$utilityTime $minutesOrHours"
}

fun selectionUnitTimeMinutes(time: String, tense: Int): String {
    return when {
        time == "минуты" && (tense % 10 == 1) && (tense != 11) -> "минуту"
        time == "минуты" && (tense % 10 in 2..4) -> "минуты"
        time == "минуты" -> "минут"
        else -> " "
    }
}

fun selectionUnitTimeHour(time: String, tense: Int): String {
    return when {
        time == "часы" && tense % 10 == 1 -> "час"
        time == "часы" && tense % 10 in 2..4 -> "часа"
        time == "часы" -> "часов"
        else -> " "
    }
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