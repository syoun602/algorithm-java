package programmers.Level_2;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem 118667 -2022 KAKAO TECH INTERNSHIP 두 큐 합 같게 만들기 (Level 2)
Link to Problem - https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */

public class Problem118667 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long firstQueueSize = 0;
        long secondQueueSize = 0;

        for (int q : queue1) {
            q1.add(q);
            firstQueueSize += q;
        }

        for (int q : queue2) {
            q2.add(q);
            secondQueueSize += q;
        }

        while (firstQueueSize != secondQueueSize) {
            if (answer > queue1.length + queue2.length + 1) {
                return -1;
            }

            if (firstQueueSize > secondQueueSize) {
                if (q1.isEmpty()) {
                    return -1;
                }
                int num = q1.poll();
                q2.add(num);
                firstQueueSize -= num;
                secondQueueSize += num;
            } else {
                if (q2.isEmpty()) {
                    return -1;
                }
                int num = q2.poll();
                q1.add(num);
                secondQueueSize -= num;
                firstQueueSize += num;
            }

            answer++;
        }

        return answer;
    }
}
