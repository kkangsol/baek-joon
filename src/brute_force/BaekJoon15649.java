package brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon15649 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        for(int i = 1; i <= N; i++){
            arr[i-1] = i;
        }
        DFS(0, "");
        bw.flush();
        bw.close();
        br.close();
    }
    static void DFS(int depth, String str)throws IOException{
        if(depth == M) bw.write(str + "\n");
        else{
            for(int i = 0; i < N; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    DFS(depth+1, str + arr[i] + " ");
                    visited[i] = false;
                }
            }
        }

    }
}
