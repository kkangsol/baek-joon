package Silver;

import java.io.*;
import java.sql.SQLOutput;

public class BeakJoon2607 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String origin = br.readLine();
        int[] originCount = new int[26];
        for (char c : origin.toCharArray()) {
            originCount[c-'A']++;
        }

        int similarCount = 0;

        for(int tc = 1; tc < n; tc++){
            String word = br.readLine();
            int[] wordCount = new int[26];
            for (char c : word.toCharArray()) {
                wordCount[c-'A']++;
            }
            if(isSimilar(originCount, wordCount)) similarCount++;
        }
        System.out.println(similarCount);
        br.close();
    }

    private static boolean isSimilar(int[] originCount, int[] wordCount) {
        int added = 0;
        int removed = 0;
        for(int i = 0; i < 26; i++){
            int diff = originCount[i] - wordCount[i];
            if(Math.abs(diff) > 1) return false;
            else if(diff == 1) added++;
            else if(diff == -1) removed++;
        }

        return (added <= 1 && removed <= 1);
    }
}
