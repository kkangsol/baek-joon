package Silver;

import java.io.*;
import java.util.*;

public class BaekJoon5212 {
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};  // 네 방향
    static int R, C;
    static char[][] map, newMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());   // map의 가로
        C = Integer.parseInt(st.nextToken());   // map의 세로
        map= new char[R][C];
        newMap = new char[R][C];    // 50년 후 지도

        int minR = 11;
        int maxR = 0;
        int minC = 11;
        int maxC = 0;

        for(int i = 0; i < R; i++){
            String tmp = br.readLine();
            map[i] = tmp.toCharArray();
            newMap[i] = tmp.toCharArray();
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'X') {  // 현재 땅이라면
                    int checkCount = 0;
                    for (int x = 0; x < 4; x++) {   // 4방향으로 바다인지 검사
                        int nextR = i + dirR[x];
                        int nextC = j + dirC[x];
                        if (isSea(nextR, nextC)) checkCount++;
                    }
                    if (checkCount >= 3) {
                        newMap[i][j] = '.';
                    }else{
                        minC = Math.min(minC, j);
                        maxC = Math.max(maxC, j);
                        minR = Math.min(minR, i);
                        maxR = Math.max(maxR, i);
                    }
                }
            }
        }


        for(int i = minR; i <= maxR; i++){
            for(int j = minC; j <= maxC; j++){
                bw.write(newMap[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isSea(int nextR, int nextC) {
        return nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || map[nextR][nextC] == '.';
    }
}
