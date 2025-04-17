package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BaekJoon9012 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            String word = br.readLine();
            sb.append(isVPS(word)).append("\n");
        }
        System.out.println(sb);
    }

    static String isVPS(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            if(c == '('){
                deque.push(c);
            }else{
                if(deque.isEmpty()){
                    return "NO";
                }
                deque.pop();
            }
        }
        return deque.isEmpty()? "YES" : "NO";
    }
}
