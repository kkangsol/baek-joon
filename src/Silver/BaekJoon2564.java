package Silver;

import java.util.*;
import java.io.*;

public class BaekJoon2564 {
    static class Store{
        int dir;    // 방향
        int dis;    // 거리
        public Store(int dir, int dis) {
            this.dir = dir;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());   // 가로
        int h = Integer.parseInt(st.nextToken());   // 세로

        int n = Integer.parseInt(br.readLine());    //상점 갯수

        Store[] stores = new Store[n];  // 상점들 저장할 배열

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            stores[i] = new Store(dir, dis);
        }
        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int dis = Integer.parseInt(st.nextToken());

        Store me = new Store(dir, dis);
        int curDir = me.dir;    // 나의 방향
        int curDis = me.dis;    // 나의 위치

        int[] watch = new int[n];   // 시계 방향 거리 넣는 배열
        int[] nonWatch = new int[n];    // 반시계 방향 거리 넣는 배열

        int i = 0, count = 0;   // 인덱스와 거리카운트

        //반시계방향
        while(i < n){
            if(curDir == stores[i].dir && curDis == stores[i].dis){
                nonWatch[i++] = count;
                count = 0;
                curDir = me.dir;
                curDis = me.dis;
                continue;
            }
            count++;
            switch(curDir){
                case 1:
                    curDis--;
                    if(curDis == 0){
                        curDir = 3;
                    }
                    break;
                case 3:
                    curDis++;
                    if(curDis == h){
                        curDir = 2;
                        curDis = 0;
                    }
                    break;
                case 2:
                    curDis++;
                    if(curDis == w){
                        curDir = 4;

                    }
                    break;
                case 4 :
                    curDis--;
                    if(curDis == 0){
                        curDir = 1;
                        curDis = w;
                    }
                    break;
            }
        }

        //시계방향
        i = 0;
        curDir = me.dir;
        curDis = me.dis;

        while(i < n){
            if(curDir == stores[i].dir && curDis == stores[i].dis){
                watch[i++] = count;
                count = 0;
                curDir = me.dir;
                curDis = me.dis;
                continue;
            }
            count++;
            switch(curDir){
                case 1:
                    curDis++;
                    if(curDis == w){
                        curDir = 4;
                        curDis = 0;
                    }
                    break;
                case 4 :
                    curDis++;
                    if(curDis == h){
                        curDir = 2;
                        curDis = w;
                    }
                    break;
                case 2:
                    curDis--;
                    if(curDis == 0){
                        curDir = 3;
                        curDis = h;
                    }
                    break;
                case 3:
                    curDis--;
                    if(curDis == 0){
                        curDir = 1;
                    }
                    break;
            }
        }
        int answer = 0;
        for(int k = 0; k < n; k++){
            int choice = Math.min(watch[k], nonWatch[k]);
            answer += choice;
        }
        System.out.println(answer);
    }
}
