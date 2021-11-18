package programmers.Level_3;

import java.util.*;

/*
Problem 42628 - 이중우선순위큐 (Level 3)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/42628
*/

public class Problem42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] command = operations[i].split(" ");

            if (command[0].equals("I")) {
                int num = Integer.parseInt(command[1]);
                minQ.offer(num);
                maxQ.offer(num);
            } else if (!minQ.isEmpty()) {
                if (command[1].equals("1"))
                    minQ.remove(maxQ.poll());
                else if (command[1].equals("-1"))
                    maxQ.remove(minQ.poll());
            }
        }

        if (!minQ.isEmpty()) {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }

        return answer;
    }
}
