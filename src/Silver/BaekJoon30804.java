package Silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekJoon30804 {

    static int N, maxLength;
    static int[] fruits;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        maxLength = 0;
        int index = 0;
        int initIndex = index;
        set = new HashSet<>();
        while(index < N){
            set.add(fruits[index]);
            if(set.size() <= 2) index++;
            else{
                maxLength = Math.max(maxLength, index - initIndex);
                initIndex = index;
                set.clear();
            }
        }
        maxLength = Math.max(maxLength, index - initIndex);
        System.out.println(maxLength);
    }
}
