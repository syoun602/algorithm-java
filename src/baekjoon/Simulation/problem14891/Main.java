package baekjoon.Simulation.problem14891;

// 14891 - 톱니바퀴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited = new boolean[4];
    static String[] wheel = new String[4];

    public static void turn(int n, int d) {

        if(visited[n])
            return;

        visited[n] = true;

        char temp;
        int len = wheel[n].length();
        int two = wheel[n].charAt(2);
        int six = wheel[n].charAt(6);

        if(d == 1) {
            temp = wheel[n].charAt(len - 1);
            wheel[n] = temp + wheel[n].substring(0, len - 1);
        }
        else if(d == -1) {
            temp = wheel[n].charAt(0);
            wheel[n] = wheel[n].substring(1, len) + temp;
        }

        if(n+1 < 4 && two != wheel[n+1].charAt(6)) {
            if(!visited[n+1])
                turn(n+1, -d);
        }

        if(n-1 >= 0 && six != wheel[n-1].charAt(2)) {
            if(!visited[n-1])
                turn(n-1, -d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        wheel[0] = bf.readLine();
        wheel[1] = bf.readLine();
        wheel[2] = bf.readLine();
        wheel[3] = bf.readLine();

        int n = Integer.parseInt(bf.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            visited = new boolean[4];

            turn(num - 1, direction);
        }

        int answer = 0;

        for(int i = 0; i < 4; i++)
            answer += Math.pow(2, i) * (wheel[0].charAt(0) - '0');

        System.out.println(answer);

    }
}
