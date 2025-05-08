package brute_force;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14888 {

    static int[] numbers;
    static int N, maxResult, minResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        maxResult = Integer.MIN_VALUE;
        minResult = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int multiply = Integer.parseInt(st.nextToken());
        int divide = Integer.parseInt(st.nextToken());

        DFS(0, numbers[0], plus, minus, multiply, divide);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    private static void DFS(int depth, int result,int plus, int minus, int multiply, int divide) {
        if(depth == N-1){
            maxResult = Math.max(result, maxResult);
            minResult = Math.min(result, minResult);
        }else{
            int next = numbers[depth + 1];
            if(plus > 0){
                DFS(depth + 1, result + next, plus - 1, minus, multiply, divide);
            }
            if(minus > 0){
                DFS(depth + 1, result - next, plus, minus-1, multiply, divide);
            }
            if(multiply > 0){
                DFS(depth + 1, result * next, plus, minus, multiply-1, divide);
            }
            if(divide > 0){
                DFS(depth + 1, result / next, plus, minus, multiply, divide-1);
            }
        }
    }
}
