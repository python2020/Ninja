package arrays;

import java.util.ArrayList;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int sum = 0, carry = 1; // 1
        ArrayList<Integer> t = new ArrayList<Integer>();
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = carry + digits[i];
            t.add(sum % 10);
            carry = (sum >= 10 ? 1 : 0);
        }
        
        if (carry == 1) t.add(1);
        
        int size = t.size();
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) 
            res[i] = t.get(size-1-i);
            
        return res;
    }
}
