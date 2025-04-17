package structure;

import java.io.*;
import java.util.*;

public class BaekJoon10773{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Deque<Integer> numbers = new ArrayDeque<>();
        while(K-- > 0){
            int number = Integer.parseInt(br.readLine());
            if(number == 0 && !numbers.isEmpty()){
                numbers.pop();
            }else if(number != 0){
                numbers.push(number);
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
