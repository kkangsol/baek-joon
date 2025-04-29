package realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int studentNum = Integer.parseInt(br.readLine());   // 학생의 수
        boolean[] computers = new boolean[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        while(studentNum-- > 0){
            int curStudent = Integer.parseInt(st.nextToken());
            if(computers[curStudent]) answer++;
            else computers[curStudent] = true;
        }
        System.out.println(answer);
    }
}
