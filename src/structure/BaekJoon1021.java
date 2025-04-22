package structure;

import java.util.*;
import java.io.*;


public class BaekJoon1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        int pickSize = Integer.parseInt(st.nextToken());
        int[] pickNum = new int[pickSize];
        for(int i = 1; i <= size; i++){
            list.add(i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < pickSize; i++){
            pickNum[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int number : pickNum) {
            int index = list.indexOf(number);
            if(index <= list.size()/2){
                while(number != list.getFirst()){
                    int tmp = list.removeFirst();
                    list.addLast(tmp);
                    count++;
                }
                list.removeFirst();
            }else{
                while(number != list.getFirst()){
                    int tmp = list.removeLast();
                    list.addFirst(tmp);
                    count++;
                }
                list.removeFirst();
            }
        }
        System.out.println(count);
    }
}
