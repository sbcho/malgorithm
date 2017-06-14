import java.util.*;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    long r = scan.nextInt();
    long c = scan.nextInt();
    long base = 0;
    
    long result = getPoint(r+1, c+1, N, base);
    System.out.println(result);
    
  }

  private static long getPoint(long i, long j, int N, long base) {
    // TODO Auto-generated method stub
    N--;
    int quadrant = 0;
    long width = (int) Math.pow(2, N);
    if(i <= width){
      if(j <= width) quadrant = 0;
      if(j > width) quadrant = 1;
    } else {
      if(j <= width) quadrant = 2;
      if(j > width) quadrant = 3;
    }
    
    if(i <= 2 && j <= 2) return base+quadrant;
    return getPoint(i-width, j-width, N, base+quadrant*width*width);
  }

}
