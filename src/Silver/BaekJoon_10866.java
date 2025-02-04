package Silver;

import java.io.*;
import java.util.*;

public class BaekJoon_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //명령의 수
        Deque<Integer> deque = new LinkedList<>();

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push_front")){
                int x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);
            }else if(order.equals("push_back")){
                int x = Integer.parseInt(st.nextToken());
                deque.addLast(x);
            }else if(order.equals("pop_front")){
                if(deque.isEmpty()){
                    bw.write("-1");
                }else{
                    int x = deque.removeFirst();
                    bw.write(x + "");
                }
                bw.newLine();
            }else if(order.equals("pop_back")){
                if(deque.isEmpty()){
                    bw.write("-1");
                }else{
                    int x = deque.removeLast();
                    bw.write(x + "");
                }
                bw.newLine();
            }else if(order.equals("size")){
                bw.write(deque.size() + "");
                bw.newLine();
            }else if(order.equals("empty")){
                if(deque.isEmpty()) {
                    bw.write("1");
                }
                else {
                    bw.write("0");
                }
                bw.newLine();
            }else if(order.equals("front")){
                if(deque.isEmpty()){
                    bw.write("-1");
                }else {
                    int x = deque.getFirst();
                    bw.write(x + "");
                }
                bw.newLine();
            }else if(order.equals("back")){
                if(deque.isEmpty()){
                    bw.write("-1");
                }else {
                    int x = deque.getLast();
                    bw.write(x + "");
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
