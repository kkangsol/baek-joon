package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1987 {
    static char[][] board;
    static boolean[] alpha = new boolean[26];
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};
    static int R, C, maxMove;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());   //세로
        C = Integer.parseInt(st.nextToken());   //가로
        board = new char[R][C];
        for(int i = 0; i < R; i++){
            board[i] = br.readLine().toCharArray();
        }
        maxMove = 0;
        int first = board[0][0]-'A';
        alpha[first] = true;
        DFS(0, 0, 1);
        System.out.println(maxMove);

    }

    static void DFS(int r, int c, int move){
        int cantMove = 0;
        for(int i = 0; i < 4; i++){
            int nextR = r + dirR[i];
            int nextC = c + dirC[i];
            if(isPossible(nextR, nextC)){
                int cur = board[nextR][nextC]-'A';
                alpha[cur] = true;
                DFS(nextR, nextC, move + 1);
                alpha[cur] = false;
            }else{
                cantMove++;
            }
        }
        if(cantMove == 4) maxMove = Math.max(maxMove, move);
    }

    static boolean isPossible(int nextR, int nextC) {
        return (nextR >= 0 && nextC >= 0 && nextR < R && nextC < C && !alpha[board[nextR][nextC] - 'A']);
    }
}
