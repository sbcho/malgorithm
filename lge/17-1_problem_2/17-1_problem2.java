import java.io.*;
import java.util.*;


class HamiltonianCycle
{
    private int     V, pathCount;
    private int[]   path;
    private int[][] graph;
 
    /** Function to find cycle 
     * @return **/
    public boolean findHamiltonianCycle(int[][] g)
    {
        V = g.length;
        path = new int[V];
        Arrays.fill(path, -1);
        graph = g;
        try
        {
            path[0] = 0;
            pathCount = 1;
            solve(0);
            return false;
        }
        catch (Exception e)
        {
            return true;
        }
    }
 
    /** function to find paths recursively **/
    public void solve(int vertex) throws Exception
    {
        /** solution **/
        if (graph[vertex][0] == 1 && pathCount == V)
            throw new Exception("Solution found");
        /** all vertices selected but last vertex not linked to 0 **/
        if (pathCount == V)
            return;
        for (int v = 0; v < V; v++)
        {
            /** if connected **/
            if (graph[vertex][v] == 1)
            {
                /** add to path **/
                path[pathCount++] = v;
                /** remove connection **/
                graph[vertex][v] = 0;
                graph[v][vertex] = 0;
                /** if vertex not already selected solve recursively **/
                if (!isPresent(v))
                    solve(v);
                /** restore connection **/
                graph[vertex][v] = 1;
                graph[v][vertex] = 1;
                /** remove path **/
                path[--pathCount] = -1;
            }
        }
    }
 
    /** function to check if path is already selected **/
    public boolean isPresent(int v)
    {
        for (int i = 0; i < pathCount - 1; i++)
            if (path[i] == v)
                return true;
        return false;
    }
 
    /** display solution **/
    public void display()
    {
        System.out.print("\nPath : ");
        for (int i = 0; i <= V; i++)
            System.out.print(path[i % V] + " ");
        System.out.println();
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
        	boolean visited[] = new boolean[n]; 
        	relation = new ArrayList[n];
        	for(int i = 0; i<n ; i++){
        		point[i] = Integer.parseInt(br.readLine());
        		relation[i] = new ArrayList<Integer>();
        		visited[i] = false;
        	}
        	HamiltonianCycle hc = new HamiltonianCycle();
        	int[][] graph = new int[n][n];

        	System.out.println("cases:" + cases + ", n:" + n);
        	
        	long r;
        	boolean hamilton = true;
        	boolean result = false;

        	for(r = 0; r < 10000; r++){
        	//r=173;
        		hamilton = true;
        		result = true;
//        		for(int i = 0; i < n; i++){
//        			relation[i].clear();
//        			for(int j = i; j < n; j++){
//        				relation[j].clear();
//        			}
//        		}
        		for(int i = 0; i < n; i++){
        			for(int j = i+1; j < n; j++){
//        				if(relation[i].contains(j)){
//        					continue;
//        				}
        				if(point[i] >= point[j]){
        					if(point[i] - r <= point[j] + r && point[i] - r >= point[j] - r){
//        						relation[i].add(j);
//        						relation[j].add(i);
        						graph[i][j] = 1;
        						graph[j][i] = 1;
        						
        					} 
        				} else {
        					if(point[i] + r >= point[j] - r && point[i] + r <= point[j] + r){
//        						relation[i].add(j);
//        						relation[j].add(i);
        						graph[i][j] = 1;
        						graph[j][i] = 1;
        					}
        				}
        			}
        		}
//        		for(int i = 0; i < n; i++){
//        			for(int j = i; j < n; j++){
//        				if(relation[i].size() + relation[j].size() < n/2){
//        					hamilton = false;
//        					break;
//        				}
//        			}
//        		}
//        		if(!hamilton){
//        			System.out.println("no hamilton : "+r);
//        			//continue;
//        		} else {
//        			System.out.println("hamilton : "+r);
//        			
//        		}
        		System.out.println(r);
        		if(hc.findHamiltonianCycle(graph)){
        			//result = false;
        			break;
        		}
//        		for(int i = 0; i < n; i++){
//        			if(relation[i].size()<2){
//        				result = false;
//        				break;
//        			}
//        		}
//        		if(result){
//        			break;
//        		}
//        		if(checkTour(r, n, point, relation, visited)){
//        			System.out.println("tour");
//        			break; 
//        		}
        		
        	}
        	if(n==1) r=0;
        	System.out.println(r);
            bw.write(String.valueOf(r));
            bw.newLine();
        }
        bw.close();
    }

	private static boolean checkTour(long r, int n, int[] point, ArrayList<Integer>[] relation, boolean[] visited) {
		// TODO Auto-generated method stub
		boolean bTour = false;
		int current = 0;



		for(int i=0; i < relation[current].size(); i++){
			//System.out.println("checkTour - current:" + current + ", relation[current].get(i):" + relation[current].get(i));
			if(tour(current, relation[current].get(i), relation, visited)){
				return true;
			};
		}
		
		return bTour;
	}

	private static boolean tour(Integer previous, Integer current, ArrayList<Integer>[] relation, boolean[] visited) {
		// TODO Auto-generated method stub

		visited[current] = true;
		boolean bAllVisited = true;		
		for(int i = 1; i < visited.length; i++){
			if(visited[i] == false){
				bAllVisited = false;
				break;
			}
		}
		if(bAllVisited && !relation[current].isEmpty() && relation[current].get(0) == 0){
			return true;
		}
		
		int indexOfCurrent = relation[previous].indexOf(current);
		int indexOfPrevious = relation[current].indexOf(previous);
		relation[previous].remove(current);
		relation[current].remove(previous);
		
		for(int i = 0; i < relation[current].size(); i++){
			if(visited[relation[current].get(i)] == true){
				continue;
			}
			//System.out.println("check - current:" + current + ", relation[current].get(i):" + relation[current].get(i));
			if(tour(current, relation[current].get(i), relation, visited)){
				return true;
			}
		}
		relation[previous].add(indexOfCurrent, current);
		relation[current].add(indexOfPrevious, previous);		
		visited[current] = false;
		
		return false;
	}

}
