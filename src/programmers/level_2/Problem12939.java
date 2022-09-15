package programmers.level_2;

import java.util.StringTokenizer;

/*
Problem 12939 - 최댓값과 최솟값 (Level 2)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/12939
*/

public class Problem12939 {

    public String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        int min, max, n;

        min = max = Integer.parseInt(st.nextToken());

        while(st.hasMoreTokens()) {
            n = Integer.parseInt(st.nextToken());

            if(min > n)
                min = n;
            if(max < n)
                max = n;
        }

        sb.append(min).append(" ").append(max);

        return sb.toString();
    }
}
