import java.io.*;
import java.util.*;


class HamiltonianCycle
{
    private int     V, pathCount;
    private int[]   path;
    private int[][] graph;
 
    public boolean findHamiltonianCycle(int[][] g)
    {
        V = g.length;
        path = new int[V];
        Arrays.fill(path, -1);
        graph = g;
        try{
            path[0] = 0;
            pathCount = 1;
            next(0);
            return false;
        }
        catch (Exception e) {
            return true;
        }
    }
 
    public void next(int vertex) throws Exception
    {
        if (graph[vertex][0] == 1 && pathCount == V)
            throw new Exception("Solution found");
        if (pathCount == V)
            return;
        for (int v = 0; v < V; v++)
        {
            if (graph[vertex][v] == 1)
            {
                path[pathCount++] = v;
                graph[vertex][v] = 0;
                graph[v][vertex] = 0;
                if (!isPresent(v))
                    next(v);
                graph[vertex][v] = 1;
                graph[v][vertex] = 1;
                path[--pathCount] = -1;
            }
        }
    }
    public boolean isPresent(int v)
    {
        for (int i = 0; i < pathCount - 1; i++)
            if (path[i] == v)
                return true;
        return false;
    }
}
public class Main {
    static int point[];
    static ArrayList<Integer> relation[];
    
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        in = new FileInputStream("src/problem_1_Set0.in");
        out = new FileOutputStream("src/problem_1_Set0.out");
        InputStreamReader isr = new InputStreamReader(in);
        OutputStreamWriter osr = new OutputStreamWriter(out);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osr);
        
        int cases = Integer.parseInt(br.readLine());
        
        
        while(cases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            point = new int[n];
            for(int i = 0; i<n ; i++){
                point[i] = Integer.parseInt(br.readLine());
            }
            HamiltonianCycle hc = new HamiltonianCycle();
            int[][] graph = new int[n][n];
            
            long r;
            for(r = 0; r < 100; r++){
                for(int i = 0; i < n; i++){
                    for(int j = i+1; j < n; j++){
                        if(point[i] >= point[j]){
                            if(point[i] - r <= point[j] + r && point[i] - r >= point[j] - r){
                                graph[i][j] = 1;
                                graph[j][i] = 1;
                            } 
                        } else {
                            if(point[i] + r >= point[j] - r && point[i] + r <= point[j] + r){
                                graph[i][j] = 1;
                                graph[j][i] = 1;
                            }
                        }
                    }
                }
                if(hc.findHamiltonianCycle(graph)){
                    break;
                }
            }
            if(n==1) r=0;
            System.out.println("min:" + r);
            bw.write(String.valueOf(r));
            bw.newLine();
        }
        bw.close();
    }
}
