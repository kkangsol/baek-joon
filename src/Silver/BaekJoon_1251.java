package Silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_1251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        List<String> list = new ArrayList<>();

        for(int i = 1; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                StringBuilder sb1 = new StringBuilder(str.substring(0,i));  //0~i까지 구간
                StringBuilder sb2 = new StringBuilder(str.substring(i,j));  //i~j까지 구간
                StringBuilder sb3 = new StringBuilder(str.substring(j,len));//j~끝까지 구간

                String result = sb1.reverse().toString() + sb2.reverse() + sb3.reverse();
                // 문자로 하나만 변환해도 결합연산자로 인해 모두 String으로 변환

                list.add(result);
            }
        }
        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
