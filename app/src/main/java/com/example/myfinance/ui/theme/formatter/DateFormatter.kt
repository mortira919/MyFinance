package com.example.myfinance.ui.theme.formatter

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

object DateFormatter {
    private val formatter = DateTimeFormatter.ofPattern("d MMMM", Locale("ru"))

    fun format(date: LocalDate): String {
        return date.format(formatter)
    }
}