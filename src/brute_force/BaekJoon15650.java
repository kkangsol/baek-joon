package brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon15650 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        DFS(0, 0);
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth, int start) throws IOException {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
        } else {
            for (int i = start; i < N; i++) {
                selected[depth] = arr[i];
                DFS(depth + 1, i + 1);
            }
        }
    }
}
