package Silver;

import java.io.*;
import java.util.*;

public class BeakJoon_1388 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 바닥 세로 크기
        int M = Integer.parseInt(st.nextToken());   // 바닥 가로 크기
        char[][] floor = new char[N][M];    // 바닥 저장할 배열

        for(int i = 0; i < N; i++){
            floor[i] = br.readLine().toCharArray();
        }

        int sum = 0;    //정답 값

        for(int i = 0; i < N; i++){
            // 직전 바닥값 초기화 ('-'값도 '|'값도 아닌 값으로 해야 첫번째 해당 행의 첫번째 바닥부터 조건 적용
            char currentFloor = ' ';
            for(int j = 0; j < M; j++) {
                // 직전 바닥이 '|'라면 == 새로 시작되는 가로방향 바닥이라면(첫번째 바닥도 포함되는 조건임)
                if (floor[i][j] == '-' && currentFloor != '-') {
                    sum++;
                }
                currentFloor = floor[i][j]; //직전 바닥값 저장
            }
        }

        for(int i = 0; i < M; i++){
            char currentFloor = ' ';
            for(int j = 0; j < N; j++) {
                if (floor[j][i] == '|' && currentFloor != '|') {
                    sum++;
                }
                currentFloor = floor[j][i];
            }
        }
        System.out.println(sum);
    }
}
