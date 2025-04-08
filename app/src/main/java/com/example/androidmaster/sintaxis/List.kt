package com.example.androidmaster.sintaxis

fun main() {
    inmutableList()
    mutableList()
}

fun inmutableList () {
    val readOnly: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    println(readOnly.size)
    println(readOnly.toString())
    println(readOnly)
    println(readOnly.last())
    println(readOnly.first())

    val example = readOnly.filter { it.contains('a')}
    println(example)

    readOnly.forEach { weekDay -> println(weekDay) }

    for(weekDay in readOnly) {
        println(weekDay)
    }
}

fun mutableList () {
    var weekDays : MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    weekDays.add(0, "AristiDay")
    println(weekDays);

    if(weekDays.isEmpty()) {

    }
    else {
        weekDays.forEach { println(it) }
    }

    if(weekDays.isNotEmpty()) {
        weekDays.forEach { println(it) }
    }

    weekDays.last()
}