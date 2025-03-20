package Silver;

import java.io.*;
import java.util.*;

public class BaekJoon2852 {

    static final int FULL_TIME = 2880;  // 총 경기 시간은 48분 >> 2800초

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int presentWinner = 0, startWinTime = 0, scoreDif = 0;
        //현재 이기고 있는 팀, 이기기 시작한 시간, 점수차
        int[] result = new int[2];
        // 답 넣을 배열(순서대로 1팀, 2팀)

        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int goalTeam = Integer.parseInt(st.nextToken()); // 골을 넣은 팀
            String[] ms = st.nextToken().split(":");
            int goalSec = (Integer.parseInt(ms[0])*60) + (Integer.parseInt(ms[1]));
            // 골 넣은 시간을 초로 계산해서 넣어줌

            if(presentWinner != goalTeam && scoreDif > 0){
                //만약 이기고있는 팀과 골 넣은 팀이 다르고, 점수차이가 있다면
                scoreDif--; // 점수차이를 하나 줄이고
                if(scoreDif == 0){  // 동점이 되었다면
                    result[presentWinner-1] += goalSec - startWinTime; // 현재까지 이기고 있던 팀에 이긴 시간 더함
                    presentWinner = 0;  // 현재 이기고 있는 팀은 없음
                }
            }else if(presentWinner == goalTeam){
                // 만약 이기고 있는 팀에서 또 골을 넣었다면 점수차이 더해주기
                scoreDif++;
            }else if(scoreDif == 0){
                // 동점 상황에서 골을 넣었다면
                presentWinner = goalTeam;   // 이기고 있는 팀을 골 넣은 팀으로 바꿔주거
                startWinTime = goalSec;     // 이기기 시작한 시간 설정
                scoreDif++; // 점수 차이 생성
            }
            if(N == 0 && presentWinner != 0){
                //만약 해당 골이 마지막 골이고 동점으로 끝나지 않았다면 경기가 끝날 때까지 해당 팀이 이긴 시간 >> 더해줌
                result[presentWinner-1] += FULL_TIME - startWinTime;
            }
        }

        String team1 = String.format("%02d",result[0]/60) + ":" + String.format("%02d",result[0]%60);
        String team2 = String.format("%02d",result[1]/60) + ":" + String.format("%02d",result[1]%60);
        bw.write(team1 + "\n" + team2);
        bw.flush();
        bw.close();
        br.close();

    }
}
