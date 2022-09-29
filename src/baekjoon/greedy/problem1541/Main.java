package baekjoon.greedy.problem1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 1541 - 일어버린 괄호
public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String line = bufferedReader.readLine();
        final List<String> tokens = new ArrayList<>();

        String str = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '+' || line.charAt(i) == '-') {
                tokens.add(str);
                tokens.add(String.valueOf(line.charAt(i)));
                str = "";
                continue;
            }
            str += line.charAt(i);
        }
        tokens.add(str);

        int answer = 0;
        boolean flag = true;
        for (final String token : tokens) {
            if (token.equals("+")) {
                continue;
            }
            if (token.equals("-")) {
                flag = false;
                continue;
            }
            final int num = Integer.parseInt(token);

            if (flag) {
                answer += num;
            } else {
                answer -= num;
            }
        }

        System.out.println(answer);
    }
}
