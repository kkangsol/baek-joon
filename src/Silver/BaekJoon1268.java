package Silver;

import java.io.*;
import java.util.*;

public class BaekJoon1268 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] group = new int[n][5];  // 과거 반 내역

        for(int i =0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                group[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxStudent = 0;
        int president = 1;
        // 겹치는 반이었던 사람이 한명도 없으면 답은 1번이 되어야하므로 1번으로 초기화


        for(int i = 0; i < n; i++){
            Set<Integer> set = new HashSet<>();;
            for(int j = 0; j < 5; j++) {
                int curStudent = group[i][j];
                for (int k = 0; k < n; k++) {
                    if (curStudent == group[k][j] && i != k) {
                        set.add(k);
                    }
                }
            }
            if(maxStudent < set.size()){
                maxStudent = set.size();
                president = i+1;
            }
        }


        System.out.println(president);    // 답은 학생 번호니까 +1 해서 출력

    }
}
