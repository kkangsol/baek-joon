package Silver;

import java.io.*;
import java.util.*;

public class BaekJoon1713 {
    static class Students implements Comparable<Students>{
        int num;    //번호
        int recommend;  //추천수
        int time;   //시간경과
        Students(int num){
            this.num = num;
            recommend = 1;
            time = 1;
        }

        @Override
        public int compareTo(Students o) {
            if(this.recommend == o.recommend) return this.time - o.time;    //시간경과대로 오름차순
            else {
                return o.recommend - this.recommend;    //추천수대로 내림차순
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 사진 틀의 개수
        int studentsNum = Integer.parseInt(br.readLine());  // 전체 학생 추천 횟수

        List<Students> currentFrame = new ArrayList<>();   // 현재 사진틀
        List<Integer> frame = new ArrayList<>();    // 최종 사진틀(num만 저장)

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(studentsNum-- > 0){
            int next = Integer.parseInt(st.nextToken());
            for(Students student : currentFrame){
                student.time++; //다음 추천 받기 전 사진틀의 학생들 시간 +1
            }
            boolean check = false;  // next가 사진틀에 있는지 확인
            for(Students student : currentFrame){
                if(student.num == next) {   // 사진틀에 있으면
                    student.recommend++;    // 해당 학생 추천수 +1
                    check = true;
                }
            }
            if(!check){ // 사진틀에 없으면 >> next를 사진틀에 넣어야 함
                if(currentFrame.size() >= N) {
                    Collections.sort(currentFrame); // 추천순은 내림차순, 시간은 오름차순으로 정렬
                    currentFrame.remove(currentFrame.size() - 1);
                    // 추천이 가장 적으면서 오래된 학생 제거
                }
                currentFrame.add(new Students(next));   // next 학생 사진틀에 넣기
            }
        }
        for(Students student : currentFrame){   //  최종 학생 번호만 frame List에 저장
            frame.add(student.num);
        }
        Collections.sort(frame);    // 오름차순으로 정렬 후 출력
        for(int n : frame){
            bw.write(n + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
