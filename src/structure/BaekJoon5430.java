package structure;

import java.util.*;
import java.io.*;

public class BaekJoon5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        outer: while(testCase-- > 0) {
            char[] fx = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String[] num;
            if(n == 0){
                br.readLine();
                num = new String[0];
            }else{
                num = br.readLine().replaceAll("[\\[\\]]","").split("[,]");
            }
            Deque<String> deque = new LinkedList<>();
            for (String s : num) {
                deque.addLast(s);
            }
            boolean isFront = true;
            for (char c : fx) {
                if(c == 'R') isFront = !isFront;
                else{
                    if(deque.isEmpty()){
                        sb.append("error").append("\n");
                        continue outer;
                    }
                    if(isFront) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if(!isFront){
                Iterator<String> reverse = deque.descendingIterator();
                sb.append("[");
                while(reverse.hasNext()){
                    sb.append(reverse.next());
                    if(reverse.hasNext())sb.append(",");
                }
                sb.append("]").append("\n");
            }else{
                sb.append("[").append(String.join(",", deque)).append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
