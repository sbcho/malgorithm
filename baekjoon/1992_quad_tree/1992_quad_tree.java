import java.util.*;

public class Main
{
  private static char[][] image;
  
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    
    int length = scan.nextInt();
    image = new char[length+1][length+1];
    char[] temp;
    for(int i = 1; i <= length; i++){
      temp = scan.next().toCharArray();
      for(int j = 1; j <= length; j++){
        image[i][j] = temp[j-1];        
      }
    }
    
    System.out.println(quad_tree(1, length, 1, length));
  }

  private static String quad_tree(int x_start, int x_end, int y_start, int y_end) {
    if(x_end - x_start == 1 && y_end - y_start == 1){
      if( image[y_start][x_start] == image[y_start][x_end] && 
        image[y_start][x_start] == image[y_end][x_start] && 
        image[y_start][x_start] == image[y_end][x_end]){
        if(image[y_start][x_start] == '1') return "1";
        else return "0";
      } else {
        return "(" + image[y_start][x_start] + image[y_start][x_end] + image[y_end][x_start] + image[y_end][x_end] +")";
      }
    }
    int gap = (x_end - x_start + 1)/2;
    String quadrant1 = quad_tree(x_start, x_end - gap, y_start, y_end-gap);
    String quadrant2 = quad_tree(x_start + gap, x_end, y_start, y_end-gap);
    String quadrant3 = quad_tree(x_start, x_end - gap, y_start + gap, y_end);
    String quadrant4 = quad_tree(x_start + gap, x_end, y_start + gap, y_end);
    
    if(quadrant1.contentEquals(quadrant2) && quadrant1.contentEquals(quadrant3) && quadrant1.contentEquals(quadrant4)){
      if(quadrant1 == "1") return "1";
      else if(quadrant1 == "0") return "0";
    } 
    return "(" + quadrant1 + quadrant2 + quadrant3 + quadrant4 +")";
  }
}