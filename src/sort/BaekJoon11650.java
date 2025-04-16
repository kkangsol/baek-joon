package sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11650 {
    static class Coordinate implements Comparable<Coordinate>{
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if(this.x != o.x) return this.x-o.x;
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Coordinate[] coordinates = new Coordinate[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates[i] = new Coordinate(x, y);
        }
        Arrays.sort(coordinates);
        StringBuilder sb = new StringBuilder();
        for (Coordinate coordinate : coordinates) {
            sb.append(coordinate.x).append(" ").append(coordinate.y).append("\n");
        }
        System.out.print(sb);
    }
}
