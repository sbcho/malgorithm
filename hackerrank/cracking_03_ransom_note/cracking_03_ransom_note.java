import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int cnt;
        String magazine[] = new String[m];
        HashMap<String, Integer> magazineHash = new HashMap<String, Integer>();
        
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
            if(magazineHash.containsKey(magazine[magazine_i])){
                cnt = magazineHash.get(magazine[magazine_i]);
                magazineHash.put(magazine[magazine_i], cnt+1);
            } else {
                magazineHash.put(magazine[magazine_i], 1);
            }
        }
        String ransom[] = new String[n];
        boolean result = true;
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
            if(magazineHash.containsKey(ransom[ransom_i]) == false || magazineHash.get(ransom[ransom_i]) <= 0){
                result = false;
            } else {
                magazineHash.put(ransom[ransom_i], magazineHash.get(ransom[ransom_i])-1);
            }
        }
        if(result) System.out.print("Yes");
        else System.out.print("No");
    }
}
