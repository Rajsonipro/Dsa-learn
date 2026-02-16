class productofarrayexceptself{
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate the product of all elements to the left of each index
        result[0] = 1; // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Calculate the product of all elements to the right of each index
        int rightProduct = 1; // No elements to the right of the last element
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct; // Multiply with the product from the right
            rightProduct *= nums[i]; // Update the right product for the next iteration
        }
        
        return result;
    }

    public static void main(String[] args) {
        productofarrayexceptself sol = new productofarrayexceptself();
        int[] nums = {1, 2, 3, 4}; // Example input
        int[] productArray = sol.productExceptSelf(nums);
        System.out.print("Product of array except self: ");
        for (int num : productArray) {
            System.out.print(num + " ");
        }
    }

    
}