package programmers.level_1;

import java.util.HashMap;
import java.util.Map;

/*
Problem 118666 -2022 KAKAO TECH INTERNSHIP 성격 유형 검사하기 (Level 1)
Link to Problem - https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */

public class Problem118666 {

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

        Map<String, Integer> result = new HashMap<>();
        result.put("R", 0);
        result.put("T", 0);
        result.put("C", 0);
        result.put("F", 0);
        result.put("J", 0);
        result.put("M", 0);
        result.put("A", 0);
        result.put("N", 0);

        for (int i = 0; i < survey.length; i++) {
            String str = survey[i];
            int num = choices[i];
            String alphabet = "";

            if (num < 4) {
                alphabet = String.valueOf(str.charAt(0));
            } else if (num > 4) {
                alphabet = String.valueOf(str.charAt(1));
            } else {
                continue;
            }

            result.put(alphabet, result.get(alphabet) + score[choices[i]]);
        }

        answer += retrieveResult("R", "T", result);
        answer += retrieveResult("C", "F", result);
        answer += retrieveResult("J", "M", result);
        answer += retrieveResult("A", "N", result);

        return answer;
    }

    private String retrieveResult(String first, String second, Map<String, Integer> result) {
        if (result.get(first) >= result.get(second)) {
            return first;
        }

        return second;
    }
}
