package programmers.Level_3;

/*
Problem 43238 - 입국심사 (Level 3)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/43238
*/

import java.util.*;

public class Problem43238 {
    public long solution(int n, int[] times) {
        long answer = 0, left = 0, right = Long.MAX_VALUE;

        Arrays.sort(times);

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for(int i = 0; i < times.length; i++) {
                sum += mid / times[i];

                if(n <= sum)
                    break;
            }

            if(n > sum)
                left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
