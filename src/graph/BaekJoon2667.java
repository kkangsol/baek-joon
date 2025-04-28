package graph;

import java.io.*;
import java.util.*;

public class BaekJoon2667 {

    static char[][] map;
    static int n, aptNum;
    static List<Integer> apt = new ArrayList<>();
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        aptNum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == '1') {
                    BFS(i, j);
                    aptNum++;
                }
            }
        }
        Collections.sort(apt);
        System.out.println(aptNum);
        for (Integer i : apt) {
            System.out.println(i);
        }
    }

    private static void BFS(int x, int y) {
        int count = 1;
        map[x][y] = '0';
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while(!q.isEmpty()){
            int[] nextIndex = q.poll();
            int curX = nextIndex[0];
            int curY = nextIndex[1];
            for(int i = 0; i < 4; i++){
                int nx = curX+dirX[i];
                int ny = curY+dirY[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == '1'){
                    q.add(new int[]{nx,ny});
                    map[nx][ny] = '0';
                    count++;
                }
            }
        }
        apt.add(count);
    }
}
