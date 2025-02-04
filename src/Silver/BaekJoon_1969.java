package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon_1969 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //DNA의 수
        int M = Integer.parseInt(st.nextToken());   //문자열의 길이

        int hammingDistance = 0;   //   HammingDistance의 합
        StringBuilder minDNA = new StringBuilder(); //  HammingDistance의 합이 가장 작은 DNA

        char[][] DNA = new char[N][M];

        for(int i = 0; i < N; i++){
            DNA[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < M; i++){
            Map<Character, Integer> ACGT = new HashMap<>(); // ACGT 종류와 갯수 카운트할 map
            for(int j = 0; j < N; j++){
                ACGT.put(DNA[j][i],ACGT.getOrDefault(DNA[j][i],0)+1);   //ACGT 종류와 갯수 카운트
            }
            List<Character> list = new ArrayList<>(ACGT.keySet());
            Collections.sort(list); //list 이용하여 사전순으로 정렬

            char minHamming = 'A';  //  가장 많이 나온 ACGT 종류 저장
            int maxChar = 0;    //  최댓값 저장

            for(char c : list){
                int now = ACGT.get(c);
                if(now > maxChar){
                    maxChar = now;
                    minHamming = c;
                }
            }
            hammingDistance += (N-maxChar); // DNA의 갯수에서 최댓값을 빼면 Hamming Distance
            minDNA.append(minHamming);
        }
        System.out.println(minDNA);
        System.out.println(hammingDistance);

    }
}
