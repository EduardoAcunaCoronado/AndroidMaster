package com.example.androidmaster.sintaxis

fun main() {
    numericas();
    alfanumericas();
    showMyAge(29);
    showMyName("Maria");
    add(25, 76)
    val mySubtract = subtract(25, 76)
    println(mySubtract)
}

fun showMyName(name:String) {
    println("Me llamo $name.")
}

fun showMyAge(currentAge : Int) {
    println("Tengo $currentAge años")
}

fun add(firstNumber:Int, secondNumber:Int) {
    println(firstNumber + secondNumber)
}

fun subtract(firstNumber:Int, secondNumber:Int):Int {
    return firstNumber - secondNumber
}

fun subtractCool(firstNumber:Int, secondNumber:Int):Int = firstNumber - secondNumber


fun numericas(){
    println("Hol2a");

    val intExample:Int = 30;
    var intExample2:Int = 29;
    intExample2 = 29;
    val longExample:Long = 1;
    val floatExample:Float = 1.5f;
    val doubleExample:Double = 1.5;

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

}

fun alfanumericas () {
    val stringExample:String = "1";
    val booleanExample:Boolean = true;
    println(stringExample);
    var stringExample2 = "Hola"
    stringExample2 = "Hola, me llamo ${stringExample.toInt()}"
    println(stringExample2)
}