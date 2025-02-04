package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon_1783 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;

        if (N == 1) count = 1;
        else if(N == 2) count = Math.min(4, (M+1)/2);
        else if(N >= 3 && M < 7){
            count = Math.min(4, M);
        }else{
            count = M-2;
        }
        System.out.println(count);
    }
}
