package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon1546 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] grades = new double[N];
        double M = 0;
        for(int i = 0; i < N; i++){
            grades[i] = Double.parseDouble(st.nextToken());
            M = Math.max(grades[i], M);
        }
        double sum = 0;
        for(int i = 0; i < N; i++){
            grades[i] = grades[i]/M*100;
            sum += grades[i];
        }

        System.out.println(sum/N);
    }
}
