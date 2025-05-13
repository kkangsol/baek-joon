package brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon15651 {
    static BufferedWriter bw;
    static int N, M;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        DFS(0);
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth) throws IOException{
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i : selected) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
        }else{
            for(int i = 1; i <= N; i++){
                selected[depth] = i;
                DFS(depth+1);
            }
        }
    }
}
