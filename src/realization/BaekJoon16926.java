package realization;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon16926 {
    static int N, M, R;
    static int[][] map;
    static int[] dirM = {1, 0, -1, 0};
    static int[] dirN = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());//세로
        M = Integer.parseInt(st.nextToken());//가로
        R = Integer.parseInt(st.nextToken());//회전횟수
        map = new int[N][M];

        for(int i= 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int startN, startM, endN, endM;
        startN = startM = 0;
        endN = N;
        endM = M;


    }
}
