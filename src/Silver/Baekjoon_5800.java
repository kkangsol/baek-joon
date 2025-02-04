package Silver;

import java.io.*;
import java.util.*;

public class Baekjoon_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int  K = Integer.parseInt(br.readLine());   // 반의 수

        for(int classNum = 1; classNum <= K; classNum++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            int[] students = new int[studentNum];
            for(int i = 0; i < studentNum; i++){
                students[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(students);  // 내림차순으로 성적 정렬

            int minScore = students[0];   // 최대성적
            int maxScore = students[studentNum-1];   // 최소성적
            int scoreGap = 0;   // 최대성적차이

            for(int i = 1; i < studentNum; i++){
                int gap = students[i] - students[i-1];
                scoreGap = Math.max(gap, scoreGap);
            }
            bw.write("Class " + classNum);
            bw.newLine();
            bw.write("Max " + maxScore + ", Min " + minScore + ", Largest gap " + scoreGap);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
