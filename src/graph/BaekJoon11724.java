package graph;

import java.io.*;
import java.util.*;

public class BaekJoon11724 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N,M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        M = Integer.parseInt(st.nextToken());   // 간선의 개수
        visited = new boolean[N + 1];
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        System.out.print(answer);
    }

    private static void DFS(int i) {
        visited[i] = true;
        for (int cnt : graph.get(i)) {
            if(!visited[cnt])DFS(cnt);
        }
    }
}
