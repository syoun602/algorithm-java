package programmers.Level_3;

import java.util.PriorityQueue;
import java.util.Collections;

/*
Problem 12927 - 야근 지수 (Level 3)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/12927
*/

public class Problem12927 {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++)
            pq.add(works[i]);

        for (int i = 0; i < n; i++) {
            int max = pq.poll();

            if(max <= 0)
                break;

            pq.add(max - 1);
        }

        while(!pq.isEmpty())
            answer += Math.pow(pq.poll(), 2);

        return answer;
    }
}