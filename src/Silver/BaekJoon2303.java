package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon2303 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 사람의 수
        int maxCard = 0;    // 카드 합의 최대 저장
        int winner = N;     // 승자의 번호 저장 (같으면 가장 큰 번호 >> 모드 같을 경우 대비해 N으로 초기화)

        for(int i = 0; i < N; i++){
            int[] cards = new int[5];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++){
                int card = Integer.parseInt(st.nextToken());
                cards[j] = card;
            }

            int max = 0;    // 해당 사람의 최대값 저장

            for(int a = 0; a < 5; a++){
                int one = cards[a];
                for(int b = a+1; b < 5; b++){
                    int two = cards[b];
                    for(int c = b+1; c < 5; c++){
                        int three = cards[c];
                        int num = (one+two+three)%10;
                        max = Math.max(max, num);
                    }
                }
            }

            if(maxCard <= max){     // 같으면 가장 큰 번호이니 =붙이는거 주의
                maxCard = max;
                winner = i+1;
            }
        }

        System.out.println(winner);
    }
}
