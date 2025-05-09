package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon1182 {
    static int N, S, count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        DFS(0, 0);
        if(S == 0) System.out.println(count-1);
                else System.out.println(count);;
    }
    static void DFS(int sum, int curNum){
        if(curNum == N) {
            if(sum == S) count++;
            return;
        }
        DFS(sum+arr[curNum], curNum+1);
        DFS(sum, curNum + 1);
    }
}
