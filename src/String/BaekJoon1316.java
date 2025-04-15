package String;

import java.io.*;

public class BaekJoon1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        outer : while(n-- > 0){
            String word = br.readLine();
            boolean[] alphabet = new boolean[26];
            alphabet[word.charAt(0) - 'a'] = true;
            for(int i = 1; i < word.length(); i++){
                int alphaNum = word.charAt(i) - 'a';
                if((word.charAt(i) != word.charAt(i-1)) && alphabet[alphaNum])continue outer;
                alphabet[alphaNum] = true;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
