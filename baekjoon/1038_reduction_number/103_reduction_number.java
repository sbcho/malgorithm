import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int reduction_cnt = 0;
		long MAX_NUM = 9000000*1000 + 876543210;

		for(long i = 1; i <= MAX_NUM; i++){
			if(N==0) {
				System.out.println(0);
				break;
			}
			System.out.println(i);
			if(getFindReduction(i)){
				reduction_cnt++;
				if(reduction_cnt==N){
					System.out.println(i);
					break;
				}
			}
			if(i == MAX_NUM) System.out.println(-1);
		}
	}
	private static boolean getFindReduction(long value) {
		boolean result = true;
		long remainder = value % 10;
		if(remainder == value) return result;
		
		while(value / 10 > 0){
			value /= 10;
			if(value % 10 <= remainder){
				result = false;
			}
			remainder = value % 10;
		}
		return result;
	}
}
