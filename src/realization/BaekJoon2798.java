package realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2798 {
    static int[] cards;
    static int N, M, maxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        maxSum = 0;
        DFS(0, 0, 0);


        /*for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int k = j+1; k < N; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= M) maxSum = Math.max(maxSum, sum);
                }
            }
        }
        System.out.println(maxSum);

         */
    }
    static void DFS(int start, int sum, int depth){
        if(depth == 3){
            maxSum = Math.max(sum, maxSum);
            return;
        }else{
            for(int i = start; i < N; i++){
                DFS(i + 1, sum + cards[i], depth + 1);
            }
        }
    }
}
