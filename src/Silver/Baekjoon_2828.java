package Silver;

import java.io.*;
import java.util.*;

public class Baekjoon_2828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 스크린 칸 수
        int M = Integer.parseInt(st.nextToken());   // 바구니가 차지하는 칸 수

        int J = Integer.parseInt(br.readLine());    // 사과가 떨어지는 개수

        int startPos = 1, endPos = M, count = 0;
        // 바구니 시작위치, 바구니 끝위치, 이동한 거리
        while(J-- > 0){
            int apple = Integer.parseInt(br.readLine());    // 떨어지는 사과의 위치
            if(apple < startPos){   // 사과의 위치가 바구니 첫위치보다 작다면
                count += startPos - apple;  // 바구니 위치와 사과 위치 차이만큼 거리 더해주고
                startPos = apple;   // 사과 위치가 바구니 첫 위치
                endPos = startPos + M - 1;
            }else if(apple > endPos){
                count += apple - endPos;
                endPos = apple;
                startPos = endPos - M + 1;
            }
        }
        System.out.println(count);
    }
}
