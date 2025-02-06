package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon13335 {

    static class Truck {
        int weight; //트럭 무게
        int time;   //트럭이 다리에 진입했을 때 카운트다운 되어질 변수
        public Truck(int wieght, int time){
            this.weight = wieght;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //트럭의 수
        int w = Integer.parseInt(st.nextToken());   //다리의 길이
        int L = Integer.parseInt(st.nextToken());   //최대 하중

        Truck[] trucks = new Truck[n];  // 트럭 배열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int curTruck = Integer.parseInt(st.nextToken());
            trucks[i] = new Truck(curTruck, w);
        }


        Queue<Truck> bridge = new LinkedList<>();   // 다리

        int count = 0, index = 0, weightSum = 0;    // 총 시간, 트럭의 인덱스, 다리 위의 무게


        while(true){
            count++;    //시간이 하나씩 up
            int len = bridge.size();    // 현재 다리 위의 트럭 갯수
            for(int i = 0; i < len; i++){
                //반복문 > 다리 위 트럭 한바퀴 돌며 time 줄이기
                Truck t = bridge.poll();
                t.time--;
                // time이 w와 같으면 이제 막 진입, 0이면 빠져나감
                if(t.time == 0) {   // time이 0이면 트럭 빠져나감
                    weightSum -= t.weight;  //총 무게에서 빼주기
                }else bridge.add(t);    //time==0 아니면 다시 Queue에 넣어주기 (여전히 다리에 있음)
            }
            if(index < n && bridge.size()+1 <= w && weightSum + trucks[index].weight <= L){
                // 다리에 진입 가능한지 여부 따져보기 (다리의 길이와 최대하중)
                bridge.add(trucks[index]);  //다리에 트럭 진입
                weightSum += trucks[index++].weight;    //총 무게에 더해주기
            }
            if(bridge.isEmpty()) break; //다리에 아무것도 없다 >> 끝
        }

        System.out.println(count);

    }
}
