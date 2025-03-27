package Silver;

import java.io.*;

public class BaekJoon8911 {

    static int[] xDir = {0,-1, 0, 1};   // x축 방향 (북,서,남,동)
    static int[] yDir = {1, 0, -1, 0};  // y축 방향
    static int maxX, maxY, minX, minY, answer, dir; // 최대최소 xy값, 답, 방향
    static char[] order;

    static class Turtle{
        int x;
        int y;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        Turtle turtle = new Turtle();
        while(tc-- > 0){
            turtle.x = turtle.y = answer = dir = maxX = maxY = minX = minY = 0;
            // (0,0)에서 시작 >> 0으로 초기화
            order = br.readLine().toCharArray();
            for (char tmp : order) {
                switch(tmp){
                    case 'F':
                        turtle.x += xDir[dir];
                        turtle.y += yDir[dir];
                        break;
                    case 'B':
                        turtle.x += xDir[(dir+2)%4];
                        turtle.y += yDir[(dir+2)%4];
                        break;
                    case 'L':
                        dir = (dir+1)%4;
                        break;
                    case 'R':
                        dir = (dir+3)%4;
                        break;
                }
                minX = Math.min(minX, turtle.x);
                minY = Math.min(minY, turtle.y);
                maxX = Math.max(maxX, turtle.x);
                maxY = Math.max(maxY, turtle.y);
            }
            answer = (maxX - minX) * (maxY - minY);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
