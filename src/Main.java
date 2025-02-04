import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] ch;
    public static void DFS(int L){
        if(L == n+1) {
            String tmp = "";
            for(int i = 1; i < 4; i++){
                if(ch[i] == 1) tmp += (i + " ");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }else{
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }
    public static void main(String[] args){
        n = 3;
        ch = new int[n+1];
        DFS(1);
    }
}