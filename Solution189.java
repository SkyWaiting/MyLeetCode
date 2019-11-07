import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (39.19%)
 * Likes:    402
 * Dislikes: 0
 * Total Accepted:    76K
 * Total Submissions: 194K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */
public class Solution189 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 3, 4, 6, 6, 9};
        System.out.println(Arrays.toString(nums));
        rotate1(nums,4);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 一、暴力求解
     * 旋转 k 次，每次将数组旋转 1 个元素
     * 
     * 时间复杂度：O(n * k)。每个元素都被移动1步（O(n)）,k次（O(k)）
     * 空间复杂度：O(1)，没有额外的空间被使用 
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 二、使用额外的数组
     * 用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标
     * 为i的我们把它放到(i+k)%数组长度的位置。然后把新的数组拷贝到原数组里。
     * 
     * 时间复杂度：O(n)。将数字放到新数组需要一遍遍历，将新数组元素拷贝回原数组也需要一遍遍历。
     * 空间复杂度：O(n)。另一个数组需要原数组长度空间 
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 三、使用环状替换
     * 
     * 
     * 时间复杂度：O(n)。
     * 空间复杂度：O(1)。使用了常数个额外空间。 
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        
    }

    /**
     * 四、使用反转
     * 当我们反转数组k次，k%n个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * 在这个方法中，我们首先将所有元素反转。然后反转前k个元素，再反转后面n-k个元素。
     * 
     * 时间复杂度：O(n)。n个元素总共被反转了3次。
     * 空间复杂度：O(1)。没有使用额外的空间。 
     * @param nums
     * @param k
     */
    public static void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}