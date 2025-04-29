package realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //1~12월까지의 일수
        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int totalDays = 0;

        for(int i = 0; i < month-1; i++){
            totalDays += monthDays[i];
        }
        totalDays += day;

        System.out.println(weekDays[totalDays%7]);

    }
}
