package Silver;

import java.io.*;
import java.util.*;

public class BaekJoon2644 {
    static int n, a, b, m;
    static ArrayList<ArrayList<Integer>> blood = new ArrayList<>();
    static boolean[] ch;
    static int BFS(int a){
        Queue<Integer> q = new LinkedList<>();
        ch[a] = true;
        q.add(a);
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++) {
                // 실수한 부분 : 큐의 사이즈만큼 반복문을 돌린 후 레벨값을 올렸어야 했다!
                int curPerson = q.poll();
                if (curPerson == b) return L;
                // 현재 탐색하는 사람이 b라면 현재 레벨(촌수) 리턴 / 0촌수까지 탐색하려면 이 부분에서 리턴해야 함
                for (int nextPerson : blood.get(curPerson)) {
                    if (!ch[nextPerson]) {
                        ch[nextPerson] = true;  // 탐색한 사람은 중복 체크해주기
                        q.add(nextPerson);
                    }
                }
            }
            L++;    //촌수 올려서 다시 탐색
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    // 전체 사람 수
        ch = new boolean[n+1];  // 중복 체크 배열
        for(int i = 0; i <= n; i++){
            blood.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());   // 촌수를 계산해야 하는 사람1
        b = Integer.parseInt(st.nextToken());   // 촌수를 계산해야 하는 사람2

        m = Integer.parseInt(br.readLine());    // 부모 자식 관계 m

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            blood.get(x).add(y);
            blood.get(y).add(x);
        }
        int answer = BFS(a);
        System.out.println(answer);
    }
}
