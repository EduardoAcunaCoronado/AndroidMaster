package com.example.androidmaster

fun main() {
    println("Hola");

    val intExample:Int = 30;
    val longExample:Long = 1;
    val floatExample:Float = 1.5f;
    val doubleExample:Double = 1.5;

    val charExample:Char = 'a';
    val stringExample:String = "1";

    val booleanExample:Boolean = true;

    var intExample2:Int = 29;
    intExample2 = 29;

    println("Sumar: ")
    println(intExample + intExample2)

    println("Restar: ")
    println(intExample - intExample2)

    println("Multiplicar: ")
    println(intExample * intExample2)

    println("Dividir: ")
    println(intExample / intExample2)

    println("Modulo: ")
    println(intExample % intExample2)

    println(stringExample);
    var stringExample2 = "Hola"
    stringExample2 = "Hola, me llamo ${stringExample.toInt()}"
    println(stringExample2)
}