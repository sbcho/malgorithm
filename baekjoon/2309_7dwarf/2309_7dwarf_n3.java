import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int[] dwarf = new int[9];
    for(int k = 0; k < dwarf.length; k++){
        dwarf[k] = scan.nextInt();
    }
    int sum,x=0,y=0;
    
    Arrays.sort(dwarf);
    for(int i = 0; i < dwarf.length; i++){
      for(int j = i+1; j < dwarf.length; j++){
        sum = 0;
        for(int k = 0; k < dwarf.length; k++){
          if(k != i && k != j){
            sum += dwarf[k];
          }
        }
        if(sum == 100){
          x = i;
          y = j;
        }
      } 	 
    }
    for(int k = 0; k < dwarf.length; k++){
      if(k != x && k != y){
        System.out.println(dwarf[k]);
      }
    }
  }
}