package com.kotlindemo.model


data class UserBean(
    val code: Int,
    val data: Data,
    val msg: String
)

data class Data(
    val realname: String,
    val jobnumber: String,
    val intotime: String,
    val position: String,
    val picload: String,
    val department_name: String,
    val company_name: String,
    val birthday_remind: Int
)