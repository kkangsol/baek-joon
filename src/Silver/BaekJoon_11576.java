package Silver;

import java.io.*;
import java.util.*;

public class BaekJoon_11576 {
    static int A, B, m, ten;
    // 미래진법, 정이의 진법, 자릿수, 10진법
    static Stack<Integer> present;
    // 현재 진법으로 변환한 수를 넣을 스택 (큰 자릿수부터 출력하기 때문에 스택으로 넣기)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());   //미래 진법
        B = Integer.parseInt(st.nextToken());   //정이 진법

        m = Integer.parseInt(br.readLine());    //미래 진법 자릿수

        int[] future = new int[m];  //미래진법의 자릿수마다의 수를 담을 배열

        ten = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            future[i] = Integer.parseInt(st.nextToken());
        }

        goToTen(future);
        present = new Stack<>();
        goToPresent(ten);

        while(!present.isEmpty()){
            bw.write(present.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
    public static void goToTen(int[] future){   //10진법으로 변환
        int num = 1;
        for(int i = m-1; i >= 0; i--){  // 1의자릿수부터 곱하고 더해가며 10진법으로 변환
            ten += num*future[i];
            num *= A;
        }
    }
    public static void goToPresent(int ten){    //10진법에서 정이 진법으로 변환
        while(ten > 0) {
            int remain = ten % B;
            present.push(remain);
            ten /= B;
        }
    }
}
