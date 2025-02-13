package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon1389 {
    static int N, minKevin, insider;
    static List<ArrayList<Integer>> network;
    static Queue<Integer> q;
    static int[] count;

    static int BFS(int me){
        int sum = 0;    // me의 최종 케빈 합
        q = new LinkedList<>();
        count = new int[N+1];   // 각 사람들과의 케빈 구하기
        int L = 1;  // 단계 수
        q.add(me);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int cur = q.poll();
                for(int next : network.get(cur)){
                    if(next != me && count[next] == 0){ // 나와의 관계는 제외 && 이미 세었던 관계 제외
                        count[next] = L;
                        q.add(next);
                    }
                }
            }
            L++;
        }
        for(int kevin : count){
            sum += kevin;   // 각 사람들과의 케빈을 모두 합해주기
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 유저의 수
        int M = Integer.parseInt(st.nextToken());   // 친구관계 수

        network = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            network.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            network.get(A).add(B);
            network.get(B).add(A);
        }

        minKevin = Integer.MAX_VALUE;   // 최소 베이컨 수(계속 갱신)
        insider = 0;    // 최소 베이컨 수를 가진 사람의 번호

        for(int i = 1; i <= N; i++){
            int curKevin = BFS(i);
            if(minKevin > curKevin){
                minKevin = curKevin;
                insider = i;
            }
        }

        System.out.println(insider);
        br.close();
    }
}
