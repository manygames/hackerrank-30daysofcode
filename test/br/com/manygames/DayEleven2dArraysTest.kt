package br.com.manygames

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    givenArrayExpectMaxSum()
}

fun givenArrayExpectMaxSum(){
    var arr = Array(6, { Array(6, { 0 }) })
    arr[0] = arrayOf(1, 1, 1, 0, 0, 0)
    arr[1] = arrayOf(0, 1, 0, 0, 0, 0)
    arr[2] = arrayOf(1, 1, 1, 0, 0, 0)
    arr[3] = arrayOf(0, 0, 2, 4, 4, 0)
    arr[4] = arrayOf(0, 0, 0, 2, 0, 0)
    arr[5] = arrayOf(0, 0, 1, 2, 4, 0)

    val sum = Eleven().maxHourglassSum(arr)
    assertEquals(19, sum)
}