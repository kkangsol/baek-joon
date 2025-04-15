package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] grades = new int[n];
            for(int i = 0; i < n; i++){
                grades[i] = Integer.parseInt(st.nextToken());
                sum += grades[i];
            }
            double average = sum/n;
            double count = 0;
            for (double grade : grades) {
                if(grade > average) count++;
            }
            System.out.printf("%.3f%%",count/n*100);
        }

    }
}
