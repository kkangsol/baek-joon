package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BaekJoon_1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();   // 숫자 String으로 받기
        int count = 0;  // 변환 횟수
        while(N.length() != 1){
            int sum = 0;
            count++;
            for(char c : N.toCharArray()){
                int num = (int)c - '0';
                sum += num;
            }
            N = String.valueOf(sum);
        }
        System.out.println(count);
        if(N.equals("3") || N.equals("6") || N.equals("9")) System.out.println("YES");
        else System.out.println("NO");
    }
}
