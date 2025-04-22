package structure;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class BaekJoon10845{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int back = 0;
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                queue.offer(x);
                back = x;
            }else if(order.equals("pop")){
                if(queue.isEmpty())sb.append(-1);
                else sb.append(queue.poll());
                sb.append("\n");
            }else if(order.equals("size")){
                sb.append(queue.size()).append("\n");
            }else if(order.equals("empty")){
                if(queue.isEmpty())sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }else if(order.equals("front")){
                if(queue.isEmpty())sb.append(-1);
                else sb.append(queue.peek());
                sb.append("\n");
            }else if(order.equals("back")){
                if(queue.isEmpty())sb.append(-1);
                else sb.append(back);
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
