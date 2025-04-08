package com.example.androidmaster.sintaxis

fun main () {
    val weekDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    println(weekDays[0])
    println(weekDays.size)
    weekDays[0] = "Holita"
    println(weekDays[0])

    if (weekDays.size >= 8) {
        println(weekDays[7])
    }
    else {
        println("No hay mas valores en el array")
    }

    for (position in weekDays.indices) {
        println("He pasado por aqui $position")
        println(weekDays[position])
    }

    for ((position, value) in weekDays.withIndex()) {
        println("La posicion $position contiene $value")
    }

    for (day in weekDays) {
        println("Ahora es $day")
    }

}