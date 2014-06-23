package arrays;

public class RotateArray {
	
	public static void reverse(int[] num, int i, int j) {
		int t = 0;
		while (i < j) {
			t = num[i];
			num[i] = num[j];
			num[j] = t;
			i++;
			j--;
		}
	}
	
	
	public static void rotate(int[] num, int k) {
		reverse(num, 0, num.length-1);
		reverse(num, 0, k-1);
		reverse(num, k, num.length-1);
	}
	
	
	
	public static void main(String[] args) {
		int N = 10;
		int[] num = new int[N];
		for (int i = 0; i < N; i++) { 
			num[i] = i;
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		rotate(num, 7);
		for (int i = 0; i < N; i++) 
			System.out.print(num[i] + " ");
		
	}
}
