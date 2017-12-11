package iii_conventions

import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneOffset

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return (this.toEpochSeconds() - other.toEpochSeconds()).toInt()
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other);
}

fun MyDate.toEpochSeconds(): Long {
    return LocalDate.of(year, month+1, dayOfMonth).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.UTC);
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun MyDate.inc(): MyDate{
    val d: LocalDate =  LocalDate.of(this.year, month+1, this.dayOfMonth);
    val oneDayOn = d.plusDays(1)
    return MyDate(oneDayOn.year, oneDayOn.monthValue-1, oneDayOn.dayOfMonth)
}

class DateRange(val start: MyDate, val endInclusive: MyDate): Iterator<MyDate> {
    var current: MyDate=start;
    override fun hasNext(): Boolean {
        return current<=endInclusive;
    }

    override fun next(): MyDate {
        return current++;
    }
}

operator fun DateRange.contains(date: MyDate) : Boolean {
    return date <= this.endInclusive && date >= start;
}
