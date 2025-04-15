package sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon10814 {

    static class Member implements Comparable<Member>{
        int age;
        String name;
        int id;
        public Member(int age, String name, int id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }

        @Override
        public int compareTo(Member o) {
            if(this.age != o.age) {
                return this.age - o.age;
            }
            return this.id - o.id;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Member[] members = new Member[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(age, name, i);
        }
        Arrays.sort(members);
        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
