package Bronze;

import java.io.*;

public class BaekJoon8958 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            String result = br.readLine();
            int sum = 0;
            int count = 1;
            for (char c : result.toCharArray()) {
                if(c == 'O') sum += count++;
                else count = 1;
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
