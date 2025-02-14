package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon13414 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());   // 수강 가능 인원 (1~10만)
        int l = Integer.parseInt(st.nextToken());   // 대기 목록 길이 (1~50만)

        Set<String> waiting = new LinkedHashSet<>();

        while(l-- > 0){
            String curStudent = br.readLine();
            if(waiting.contains(curStudent)) waiting.remove(curStudent);
            waiting.add(curStudent);
        }

        int count = 0;
        for(String success : waiting){
            count++;
            bw.write(success + "\n");
            if(count >= k) break;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
