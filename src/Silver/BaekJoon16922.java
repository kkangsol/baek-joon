package Silver;

import java.io.*;

public class BaekJoon16922 {

    static int N, count, sum, result;
    // 입력값, 몇개의 숫자를 사용했는지 카운트, 더한 값, 결과값
    static int[] rome = {1, 5, 10, 50};
    // 로마 숫자 배열
    static boolean[] check = new boolean[1001];
    // sum값 중복 여부 체크하는 boolean 배열

    static void DFS(int n){
        if(count == N && !check[sum]){
            result++;
            check[sum] = true;
        }
        if(count < N){
            sum += rome[n];
            count++;
            for(int i = n; i < 4; i++){
                DFS(i);
            }
            sum -= rome[n];
            count--;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = sum = result = 0;
        for(int i = 0; i < 4; i++) {
            DFS(i);
        }
        System.out.print(result);
    }
}
