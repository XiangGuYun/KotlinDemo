package com.kotlindemo

class Bean {
    data class Shop(var name:String,var openTime:String,var closeTime:String,
        var food:Food)
    data class Food(var name:String, var price:Double)
}