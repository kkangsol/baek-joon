package graph;

import java.util.*;
import java.io.*;

public class BaekJoon1260 {
    static int N, M, V;
    static List<List<Integer>> list = new ArrayList<>();
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        M = Integer.parseInt(st.nextToken());   // 간선의 개수
        V = Integer.parseInt(st.nextToken());   // 탐색 시작 번호

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(list.get(i));
        }

        visited = new boolean[N+1];
        DFS(V);
        sb.append("\n");
        visited = new boolean[N+1];
        BFS(V);

        System.out.print(sb);
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            sb.append(tmp).append(" ");
            for (Integer i : list.get(tmp)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void DFS(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        for (Integer i : list.get(v)) {
            if(!visited[i])DFS(i);
        }
    }
}
