package programmers.Level_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Problem 92334 - 2022 KAKAO BLIND RECRUITMENT 신고 결과 받기 (Level 1)
Link to Problem - https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */

public class Problem92334 {

    public int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], 0);
            map2.put(id_list[i], 0);
        }

        for (int i = 0; i < reports.length; i++) {
            set.add(reports[i]);
        }

        for (String report : set) {
            String[] str = report.split(" ");
            map.merge(str[1], 1, Integer::sum);
        }

        for (String report : set) {
            String[] str = report.split(" ");
            if (map.get(str[1]) >= k) {
                map2.merge(str[0], 1, Integer::sum);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = map2.get(id_list[i]);
        }

        return answer;
    }
}
