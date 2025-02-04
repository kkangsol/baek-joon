package Silver;

import java.io.*;
import java.util.*;

public class BaekJoon_2535 {
    static class student implements Comparable<student>{
        int nation;
        int num;
        int grade;
        public student(int nation, int num, int grade){
            this.nation = nation;
            this.num = num;
            this.grade = grade;
        }

        @Override
        public int compareTo(student o) {
            return o.grade-this.grade;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 참가 학생 수 (3~100)
        student[] students = new student[N];    // 학생들 담을 배열
        student[] winner = new student[3];  //수상한 학생들 담을 배열

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            students[i] = new student(nation, num, grade);
        }
        Arrays.sort(students);
        winner[0] = students[0];
        winner[1] = students[1];
        //1등과 2등까지는 같은 국가여도 상관 없으니 점수만 따져서 넣기

        if(winner[0].nation == winner[1].nation) {  //1등과 2등의 국가가 같다면 3등의 국가는 달라야함
            for (int i = 2; i < N; i++) {
                if (students[i].nation == winner[0].nation) continue;   //3등의 국가도 같다면 패스
                else {
                    winner[2] = students[i];
                    break;
                }
            }
        }else{
            winner[2] = students[2];    //1등과 2등의 국가가 다르다면 3등의 국가는 상관 없음
        }

        for(int i = 0; i < 3; i++){
            bw.write(winner[i].nation + " " + winner[i].num);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
