package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BaekJoon2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 1; i < N; i++){
            int cur = i;
            int sum = i;
            while(cur != 0){
                sum += (cur % 10);
                cur /= 10;
            }
            if(sum == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
