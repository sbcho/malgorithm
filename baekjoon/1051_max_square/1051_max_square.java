package baekjoon_1051_square;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		char[][] matrix = new char[x][y];
		int length = x < y? x : y ;
		
		for(int i = 0; i < x ; i++){
			matrix[i] = scan.next().toCharArray();
//			for(int j = 0; j < y ; j++){
//				matrix[i] = scan.next().toCharArray();
//			}
		}
		
		for(int k = length-1; k > 0; k--){ 
			for(int i = 0; i < x - k ; i++){
				for(int j = 0; j < y - k ; j++){
					if(matrix[i][j] == matrix[i+k][j] && 
						matrix[i][j] == matrix[i][j+k] &&
						matrix[i][j] == matrix[i+k][j+k]){
						System.out.println((k+1)*(k+1));
						return;
					}
				}
			}		
		}
	}
}
