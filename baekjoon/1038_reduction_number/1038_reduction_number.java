import java.util.*;

public class Main {

	private static long[] reduction_num;
	private static int reduction_cnt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		reduction_cnt = 0;
		reduction_num = new long[1023];
		
		for(int i = 0; i < 10; i++){
			setReduction(0, i, 0);
		}
		Arrays.sort(reduction_num);
		
		int N = scan.nextInt();
		if(N < reduction_cnt){
			System.out.print(reduction_num[N]);
		} else {
			System.out.print(-1);
		}
	}
	private static void setReduction(long pre, int current, int n) {
		// TODO Auto-generated method stub
		long sum = pre + (long)(current * Math.pow(10, n));
		reduction_num[reduction_cnt++] = sum;
		for(int k = current + 1; k < 10; k++){
			setReduction(sum, k, n+1);
		}
	}
}
