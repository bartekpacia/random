fun main(args: Array<String>) {
    printNums(2, 1, 3, 7)
}

fun printNums(vararg nums: Int) {
    for (i in nums.indices) {
        println("number at index $i is ${nums[i]}")
    }
    Flubber.a()
}


object Flubber {
    @Deprecated("")
    fun a() {
    }
}
