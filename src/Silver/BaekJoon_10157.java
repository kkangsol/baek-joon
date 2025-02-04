package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon_10157 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());   // 공연장 가로 길이
        int R = Integer.parseInt(st.nextToken());   // 공연장 세로 길이

        st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());   // 대기 번호

        if(k == 1){ // 대기번호가 1이면 좌석은 무조건 (1,1)
            System.out.println(1 + " " + 1);
        }else {
            int[][] hall = new int[R][C];   // 공연장
            int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};   // 하, 우, 상, 좌 방향 설정
            int x = 0, y = 0, dir_index = 0, count = 2; // 자리 좌표, 방향인덱스, 대기번호
            hall[0][0] = 1; // (1,1)자리에 먼저 1을 넣고 시작
            int[] answer = new int[2];  // 정답배열. 행열 바꾸고 1씩 더해야함.

            while (count <= R * C) {    // 자리가 꽉찰때까지 반복문 돌리기
                int nx = x + dir[dir_index][0]; //다음 x좌표
                int ny = y + dir[dir_index][1]; //다음 y좌표
                if (nx >= R || nx < 0 || ny >= C || ny < 0 || hall[nx][ny] != 0) {
                    //다음 좌표가 공연장을 넘어섰거나 이미 대기번호 지정이 된 좌석이라면 방향 바꿔주기
                    dir_index = (dir_index + 1) % 4;
                } else {
                    if (count == k) {   // 만약 지금 지정하는 대기번호가 찾는 대기번호라면 정답배열에 넣고 빠져나가기
                        answer[0] = ny + 1;
                        answer[1] = nx + 1;
                        break;
                    }
                    hall[nx][ny] = count++; // 좌표에 대기번호 지정해주고 다음 좌표로 진행
                    x = nx;
                    y = ny;
                }
            }
            if (answer[0] != 0) {
                System.out.println(answer[0] + " " + answer[1]);
            } else {
                System.out.println(0); // 정답배열 중 하나라도 0이라면 대기번호를 모두 지정하고도 찾는 대기번호가 없다는 뜻 > 0출력
            }
        }


    }
}
