package brute_force;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1759 {
    static int L, C;
    static String[] alphabet;
    static String[] selected;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());   //암호 길이
        C = Integer.parseInt(st.nextToken());   //문자 종류의 수
        alphabet = br.readLine().split(" ");
        Arrays.sort(alphabet);
        selected = new String[L];
        DFS(0, 0);
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth, int index) throws IOException{
        if(depth == L){
            if(!isChecked(selected)) return;
            StringBuilder sb = new StringBuilder();
            for (String c : selected) {
                sb.append(c);
            }
            sb.append("\n");
            bw.write(sb.toString());
        }else{
            for(int i = index; i < C; i++){
                selected[depth] = alphabet[i];
                DFS(depth+1, i+1);
            }
        }
    }

    private static boolean isChecked(String[] selected) {
        int mo = 0;
        int za = 0;
        for (String s : selected) {
            if(s.equals("a")||s.equals("e")||s.equals("i")||s.equals("o")||s.equals("u")) mo++;
            else za++;
        }
        return (mo >= 1 && za >= 2);
    }
}
