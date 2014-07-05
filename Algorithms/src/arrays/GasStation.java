package arrays;


public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0, len = gas.length, index = 0, margin;  
        for(int i = 0; i < len; i++){  
            margin = gas[i]-cost[i];
            sum += margin; 
            total += margin;  
            if(sum < 0) {index = i+1; sum = 0;}  
        }  
        return total >= 0 ? index : -1;  
    }
}
