package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon_17952 {
    public static class task{   // 과제 담을 클래스
        int score;
        int time;
        public task(int score, int time){
            this.score = score;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 이번학기에서 주어지는 시간
        Stack<task> tasks = new Stack<>();
        int total_score = 0;

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            if(check == 0){ //과제 정보에 0이 들어왔으면 이번 과제는 없는 것
                if(!tasks.isEmpty()) {  // 해야할 과제가 있다면 하고 없으면 넘어가기
                    task t = tasks.pop();
                    t.time--;
                    tasks.push(t);
                }
            }else{
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                tasks.push(new task(score, time-1));    // 새로운 과제가 들어오면 시간 하나 줄여서 스택에 넣어주기
            }
            if(!tasks.isEmpty() && tasks.peek().time == 0){ // 가장 최근 과제의 시간을 다 썼다면
                total_score += tasks.pop().score;   // 정답에 해당 과제 점수 더해주고 꺼내기
            }
        }
        System.out.println(total_score);
    }
}
