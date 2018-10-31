package br.com.manygames


fun main(args: Array<String>) {
    /*val arr = Array<Array<Int>>(6) {
    Array<Int>(6) {

    }
}*/


    var arr = Array(6, { Array(6, { 0 }) })
    arr[0] = arrayOf(1, 1, 1, 0, 0, 0)
    arr[1] = arrayOf(0, 1, 0, 0, 0, 0)
    arr[2] = arrayOf(1, 1, 1, 0, 0, 0)
    arr[3] = arrayOf(0, 0, 2, 4, 4, 0)
    arr[4] = arrayOf(0, 0, 0, 2, 0, 0)
    arr[5] = arrayOf(0, 0, 1, 2, 4, 0)
/*    arr[0] = arrayOf(-1, -1, 0, -9, -2, -2)
    arr[1] = arrayOf(-2, -1, -6, -8, -2, -5)
    arr[2] = arrayOf(-1, -1, -1, -2, -3, -4)
    arr[3] = arrayOf(-1, -9, -2, -4, -4, -5)
    arr[4] = arrayOf(-7, -3, -3, -2, -9, -9)
    arr[5] = arrayOf(-1, -3, -1, -2, -4, -5)*/


//    arr.forEach {
//        it.forEach {
//            print(it)
//        }
//        println("\n")
//    }
    /*for (i in 0 until 6) {
    arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
}*/

    print(Eleven().maxHourglassSum(arr))
}

class Eleven {

    companion object {
        val hourglassesArray = Array(4) {
            Array(4) {
                val top = Array<Int>(3, { 0 })
                val mid = 0
                val bottom = Array<Int>(3, { 0 })
                Hourglass(top, mid, bottom, it)
            }
        }
    }

    fun maxHourglassSum(arr: Array<Array<Int>>): Int {
        for (i in 0..3) {
            val rowsToAnalize = Array(3, { Array(6, { 0 }) })
            var rowShift = i
            for (i in 0..2) {
                rowsToAnalize[i] = arr[i + rowShift]
            }
            val hourglassesToFill = Array(1, { hourglassesArray[i] })
            fillRowOfHourglasses(rowsToAnalize, hourglassesToFill)
            hourglassesArray[i] = hourglassesToFill[0]
        }

        val maxSum = findMaxSum()
        return maxSum
    }

    private fun findMaxSum(): Int {
        var maxSum = Int.MIN_VALUE
        hourglassesArray.forEach {
            it.forEach {
                val mySum = it.mySum()
                if (mySum > maxSum) {
                    maxSum = mySum
                }
            }
        }
        return maxSum
    }

    private fun fillRowOfHourglasses(threeRowsArray: Array<Array<Int>>, fourHourglassesArray: Array<Array<Hourglass>>) {
        fourHourglassesArray[0].forEach { hourglass ->
            fillHourglass(hourglass, threeRowsArray)
        }
    }
}

private fun fillHourglass(hourglass: Hourglass, threeRowsArray: Array<Array<Int>>) {
    for (i in 0..2) {
        hourglass.top[i] = threeRowsArray[0][i + hourglass.index]
    }

    hourglass.mid = threeRowsArray[1][hourglass.index + 1]

    for (i in 0..2) {
        hourglass.bottom[i] = threeRowsArray[2][i + hourglass.index]
    }
}

class Hourglass(val top: Array<Int>, var mid: Int, val bottom: Array<Int>, val index: Int) {
    fun mySum(): Int {
        return top.sum() + mid + bottom.sum()
    }
}