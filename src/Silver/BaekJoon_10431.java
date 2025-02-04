package Silver;

import java.io.*;
import java.util.*;

public class BaekJoon_10431 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int P = Integer.parseInt(br.readLine());
        while(P-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());   // 테스트케이스 번호
            int count = 0; //정답
            List<Integer> stdnts = new ArrayList<>();   // 학생 줄

            for (int i = 0; i < 20; i++){
                stdnts.add(Integer.parseInt(st.nextToken()));   // 학생 하나씩 받기
                for(int j = i-1; j >= 0; j--){
                    if(stdnts.get(i) < stdnts.get(j)) count++;  // 현재 학생보다 큰 학생 있으면 답+1
                    else break; // break로 시간 단축
                }
                Collections.sort(stdnts);   // 줄 정리
            }

            /*for (int i = 0; i < 20; i++){
                stdnts.add(Integer.parseInt(st.nextToken()));   // 학생 하나씩 받기
                for(int j = i-1; j >= 0; j--){
                    if(stdnts.get(i) < stdnts.get(j)) count++;  // 현재 학생보다 큰 학생 있으면 답+1
                }
            }*/

            bw.write(T + " " + count);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
