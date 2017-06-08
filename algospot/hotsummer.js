import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        
        while(cases-- > 0){
        	int sum = scanner.nextInt();
        	for(int i=0; i<9; i++){
        		sum -= scanner.nextInt();
        	}
        	if(sum >= 0){
        		System.out.println("YES");
        	} else {
        		System.out.println("NO");
        	}
        }
    }
}