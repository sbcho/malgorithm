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
    System.out.println(result-1);
    
  }

  private static long getPoint(long i, long j, int N, long base) {
    // TODO Auto-generated method stub
    N--;
    int quadrant = 0;
    long width = (int) Math.pow(2, N);
    if(i <= width){
      if(j <= width) quadrant = 1;
      if(j > width) quadrant = 2;
    } else {
      if(j <= width) quadrant = 3;
      if(j > width) quadrant = 4;
    }
    if(N==0) return base+quadrant;
    
    if(quadrant == 2 || quadrant == 4) j-=width;
    if(quadrant == 3 || quadrant == 4) i-=width;
    return getPoint(i, j, N, base+(quadrant-1)*width*width);
  }
}
