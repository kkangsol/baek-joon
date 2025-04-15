package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphabet = new int[26];
        int max = 0;
        char maxAlpha = '?';
        for (char c : word.toUpperCase().toCharArray()) {
            alphabet[c-'A']++;
        }
        for(int i = 0; i < 26; i++){
            if(max < alphabet[i]){
                max = alphabet[i];
                maxAlpha = (char)(i+'A');
            }else if(max == alphabet[i]){
                maxAlpha = '?';
            }
        }
        System.out.println(maxAlpha);
    }
}
