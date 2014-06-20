package arrays;

public class Container {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
         
        int l = 0, r = height.length - 1;
        int lh = height[l], rh = height[r];
        int b = r, max = 0;
        
        while (l < r) {
            if (lh <= rh) {
                max = Math.max(lh * b, max);
                lh = height[++l]; // !
            } else {
                max = Math.max(rh * b, max);
                rh = height[--r];
            }
            b--;
        }
        
        return max;
    }
}
