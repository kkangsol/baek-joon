package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon_10709 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());   //남북방향
        int W = Integer.parseInt(st.nextToken());   //동서방향

        int[] answer = new int[W];    // 정답 넣을 배열

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            int count = -1;
            char[] sky = st.nextToken().toCharArray();
            for(int j = 0; j < W; j++){
                if(sky[j] == '.'){  // 현재 자리에 구름이 없는 경우
                    if(count == -1){    // 구름이 앞으로도 안올경우
                        answer[j] = count;
                    }else{  //앞으로 구름이 올 경우
                        answer[j] = count++;
                    }
                }else{  // 현재 자리에 구름이 있는 경우
                    count = 0;
                    answer[j] = count++;
                }
                bw.write(answer[j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
