fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val result = mutableListOf<List<Int>>()
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()
    val n = nums.size
    var i = 0
    while(i < n) {
        var left = i + 1
        var right =  n - 1
        while(left < right) {
            if (nums[i] + nums[left] + nums[right] == 0) {
                val triplet = listOf(nums[i], nums[left], nums[right])
                triplet.sortedBy { it }
                val leftFlag = left
                val rightFlag = right

                while (left < right && nums[left] == nums[leftFlag]) {
                    left++
                }
                while (left < right && nums[right] == nums[rightFlag]) {
                    right--
                }
            } else if (nums[i] + nums[left] + nums[right] < 0) {
                left += 1
            } else {
                right -= 1
            }
        }

        while(i <= n - 2 && nums[i] == nums[i + 2])
            i++
    }
    return result
}