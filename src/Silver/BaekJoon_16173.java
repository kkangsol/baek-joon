package Silver;

import java.io.*;
import java.util.*;


public class BaekJoon_16173 {
    static int N;   //게임 구역 크기
    static int[][] map;     //게임 맵
    static boolean[][] check;   //방문여부 체크(중복제거 > 시간단축)
    static String answer = "Hing";  //답 (초기 셋팅은 실패로)

    public static void jump(int x, int y){
        check[x][y] = true; //방문 체크

        if(map[x][y] == -1) {   //만약 현재 자리가 결승점이라면 성공
            answer = "HaruHaru";
            return;
        }
        if(x + map[x][y] < N && !check[x+map[x][y]][y]){    //만약 현재 자리에서 아래로 이동가능하다면, 방문하지 않은 곳이라면
            jump(x+map[x][y], y);    //밟은 칸의 숫자만큼 아래로 이동
        }
        if(y + map[x][y] < N && !check[x][y+map[x][y]]){   //만약 현재 자리에서 오른쪽으로 이동가능하다면, 방문하지 않은 곳이라면
            jump(x, y+map[x][y]);   //밟은 칸의 숫자만큼 오른쪽으로 이동
        }


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        jump(0,0);  //왼쪽 맨 위에서부터 시작한다고 했으니 map[0][0]에서 출발

        System.out.println(answer);
        br.close();
    }
}
