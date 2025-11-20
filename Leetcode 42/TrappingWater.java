public class TrappingWater {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {

            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            }

            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        int[] arr = {4, 2, 0, 3, 2, 5};
        System.out.println("Total Trapped Water = " + obj.trap(arr));
    }
}
