import java.util.*;

public class Main{
	
	static long[][] memo1;
	static long[][] memo2;
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		memo1 = new long [n][2];
		memo2 = new long [n][3];
		memo1[0][0] = 1;
		memo1[0][1] = 1;
		memo1[1][0] = 2;
		memo1[1][1] = 2;
		memo2[0][0] = 1;
		memo2[0][1] = 1;
		memo2[0][2] = 1;
		memo2[1][0] = 3;
		memo2[1][1] = 2;
		memo2[1][2] = 3;
		
		for(int i = 2; i < n; i++){
			for(int j = 0; j < 2; j++){
				switch(j){
				case 0 : memo1[i][j] = memo1[i-1][0] + memo1[i-1][1];
						break;
				case 1 : memo1[i][j] = memo1[i-1][0] + memo1[i-2][0];
						break;
				}
				memo1[i][j] %= 1000000;
			}
			for(int j = 0; j < 3; j++){
				switch(j){
				case 0 : memo2[i][j] = memo2[i-1][0] + memo2[i-1][1] + memo2[i-1][2];
						break;
				case 1 : memo2[i][j] = memo1[i-1][0] + memo1[i-1][1];
						break;
				case 2 : memo2[i][j] = memo2[i-1][0] + memo2[i-1][1] + memo2[i-2][0] + memo2[i-2][1];
						break;
				}
				memo2[i][j] %= 1000000;
			}
		}
		
		long result = memo2[n-1][0] + memo2[n-1][1] + memo2[n-1][2];
		System.out.println(result % 1000000);
		
	}
}
