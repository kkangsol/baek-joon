package sort;

import java.util.*;
import java.io.*;

public class BaekJoon1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while(n-- > 0){
            String tmpWord = br.readLine();
            set.add(tmpWord);
        }
        List<String> words = new ArrayList<>(set);
        Collections.sort(words,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                }
                return o1.compareTo(o2);
            }
        });

        for (String word : words) {
            bw.write(word + "\n");
        }
        bw.flush();
        bw.close();
    }
}
