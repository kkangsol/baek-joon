package graph;

import java.util.*;
import java.io.*;

public class BaekJoon1012 {
    static int M, N;
    static boolean[][] field;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            field = new boolean[M][N];
            int num = Integer.parseInt(st.nextToken());
            while(num-- > 0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = true;
            }
            int worm = 0;
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(field[i][j]){
                        DFS(i,j);
                        worm++;
                    }
                }
            }
            sb.append(worm).append("\n");
        }
        System.out.print(sb);
    }

    private static void DFS(int x, int y) {
        field[x][y] = false;
        for(int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < M && nextX >= 0 && nextY < N && nextY >= 0 && field[nextX][nextY]) DFS(nextX, nextY);
        }
    }
}
