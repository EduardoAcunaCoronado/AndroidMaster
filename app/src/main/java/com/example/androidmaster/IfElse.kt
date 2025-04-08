package com.example.androidmaster

fun main(){
    ifBasico()
    ifAnidado()
    ifBoolean()
    ifInt()
    ifMultiple()
    ifMultipleOR()
}

fun ifBasico() {
    val name = "PabloChuh";

    if(name.lowercase() == "aris") {
        println("Oye, la variable name es Aris");
    }
    else {
        println("Este no es Aris");
    }
}

fun ifAnidado() {
    val  animal = "Aris"
    if(animal == "dog"){
        println("Es un perro");
    }
    else if (animal == "cat") {
        println("Es un gato")
    }
    else if (animal == "bird") {
        println("Es un pajaro")
    }
    else {
        println("No es uno de los animales esperados")
    }
}

fun ifBoolean() {
    var soyFeliz = false

    if (!soyFeliz) {
        println("No soy feliz")
    }
}

fun ifInt() {
    var age = 29

    if (age >= 18) {
        println("Beber cerveza")
    }
    else {
        println("Beber jugo")
    }
}

fun ifMultiple() {
    var age = 18
    var parentPermission = false
    var imHappy = true

    if(age > 18 && parentPermission && imHappy){
        println("Si puedo beber")
    }
}

fun ifMultipleOR() {
    var pet = "cat"
    var isHappy = true

    if (pet == "dog" || (pet == "cat" && isHappy)) {
        println("Es un gato o un perro")
    }
}