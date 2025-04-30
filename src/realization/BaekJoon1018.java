package realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] wFirst = makePattern('W', N, M);
        char[][] bFirst = makePattern('B', N, M);
        char[][] chess = new char[N][M];
        int wDif = Integer.MAX_VALUE;
        int bDif = Integer.MAX_VALUE;;
        for(int i = 0; i < N; i++){
            chess[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N-7; i++){
            for(int j = 0; j < M-7; j++){
                int curWdif = 0;
                int curBdif = 0;
                for(int x = i; x < i+8; x++){
                    for(int y = j; y < j+8; y++){
                        if(chess[x][y] != wFirst[x-i][y-j])curWdif++;
                        if(chess[x][y] != bFirst[x-i][y-j])curBdif++;
                    }
                }
                wDif = Math.min(wDif, curWdif);
                bDif = Math.min(bDif, curBdif);
            }
        }
        System.out.println(Math.min(wDif, bDif));
    }
    static char[][] makePattern(char startC, int N, int M){
        char[][] pattern = new char[8][8];
        char nextC = (startC == 'W') ? 'B' : 'W';
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((i+j)%2 == 0) pattern[i][j] = startC;
                else pattern[i][j] = nextC;
            }
        }
        return pattern;
    }
    /*
    private static void MakeBfirst(int N, int M, char[][] bFirst) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(i%2 == 0){
                    if(j%2 == 0)bFirst[i][j] = 'B';
                    else bFirst[i][j] = 'W';
                }else{
                    if(j%2 == 0) bFirst[i][j] = 'W';
                    else bFirst[i][j] = 'B';
                }
            }
        }
    }

    private static void MakeWfirst(int N, int M, char[][] wFirst) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(i%2 == 0){
                    if(j%2 == 0)wFirst[i][j] = 'W';
                    else wFirst[i][j] = 'B';
                }else{
                    if(j%2 == 0) wFirst[i][j] = 'B';
                    else wFirst[i][j] = 'W';
                }
            }
        }
    }*/
}
