package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2606 {

    static List<List<Integer>> graph = new ArrayList<>();
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        int linkNum = Integer.parseInt(br.readLine());
        while(linkNum-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        System.out.println(BFS(1));
    }

    private static int BFS(int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            for (Integer i : graph.get(x)) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    answer++;
                }
            }
        }
        return answer;
    }
}
