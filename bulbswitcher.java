class Solution {
    public int bulbSwitch(int n) {
        // The number of bulbs that remain on after n rounds is the floor of sqrt(n)
        // Because only perfect squares have an odd number of divisors
        // and bulbs are toggled once for each divisor
        return (int)Math.floor(Math.sqrt(n));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        System.out.println("n = 0: " + sol.bulbSwitch(0));  // 0
        System.out.println("n = 1: " + sol.bulbSwitch(1));  // 1
        System.out.println("n = 2: " + sol.bulbSwitch(2));  // 1
        System.out.println("n = 3: " + sol.bulbSwitch(3));  // 1
        System.out.println("n = 4: " + sol.bulbSwitch(4));  // 2
        System.out.println("n = 5: " + sol.bulbSwitch(5));  // 2
        System.out.println("n = 6: " + sol.bulbSwitch(6));  // 2
        System.out.println("n = 7: " + sol.bulbSwitch(7));  // 2
        System.out.println("n = 8: " + sol.bulbSwitch(8));  // 2
        System.out.println("n = 9: " + sol.bulbSwitch(9));  // 3
        System.out.println("n = 10: " + sol.bulbSwitch(10)); // 3
    }
}
