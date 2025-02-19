package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon17266 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 굴다리 길이
        int M = Integer.parseInt(br.readLine());    // 가로등 개수

        boolean[] underpass = new boolean[N+1]; //굴다리 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int index = Integer.parseInt(st.nextToken());
            underpass[index] = true;    // 가로등 위치마다 true로 표시
        }

        int count = 0, start = 0, end = 0;

        for(int i = 0; i < N+1; i++){   // 0부터 첫 가로등까지 거리
            if(underpass[i]) {
                start = i;
                break;
            }
            count++;
        }

        int temp = 0;
        for(int i = N; i >= 0; i--){    // 끝부터 마지막 가로등까지 거리
            if(underpass[i]) {
                end = i;
                break;
            }
            temp++;
        }

        count = Math.max(count, temp);

        temp = 0;

        for(int i = start+1; i <= end; i++){    // 처음과 끝 제외한 가로등들의 최대거리
            if(underpass[i]){
                count = Math.max(count, (temp+2)/2);
                temp = 0;
            }else{
                temp++;
            }
        }

        System.out.println(count);
    }
}
