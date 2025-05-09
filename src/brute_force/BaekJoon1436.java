package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BaekJoon1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int countNum = 666;
        while(count != N){
            if(String.valueOf(countNum++).contains("666")){
                count++;
            }
        }
        System.out.println(--countNum);
    }
}
