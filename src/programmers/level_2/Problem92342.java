package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Problem 92342 -2022 KAKAO BLIND RECRUITMENT 양궁대회 (Level 2)
Link to Problem - https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */
public class Problem92342 {

    private static final List<Result> results = new ArrayList<>();
    private static int difference = 0;

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        dfs(ryan, n, info, 0);

        List<Result> maxScoreResults = results.stream()
                .filter(it -> it.getScore() == difference)
                .collect(Collectors.toList());

        int[] answer = {};
        int maxDiff = -1;
        for (Result result : maxScoreResults) {
            int[] res = result.getInfo().stream()
                    .mapToInt(i -> i)
                    .toArray();
            int count = 0;
            for (int i = 10; i >= 0; i--) {
                if (res[i] != 0) {
                    count++;
                }
            }
            if (count > maxDiff) {
                maxDiff = count;
                answer = res;
            }
        }

        if (difference == 0) {
            return new int[]{-1};
        }
        return answer;
    }

    public void dfs(int[] ryan, int leftover, int[] info, int depth) {
        if (leftover < 0) {
            return;
        }
        if (depth == 10) {
            ryan[depth] = leftover;
            addIfWinner(info, ryan);
            ryan[depth] = 0;
            return;
        }

        int arrows = info[depth];

        if (leftover - (arrows + 1) < 0) {
            dfs(ryan, leftover, info, depth + 1);
        } else {
            dfs(ryan, leftover, info, depth + 1);
            ryan[depth] = arrows + 1;
            dfs(ryan, leftover - (arrows + 1), info, depth + 1);
            ryan[depth] = 0;
        }
    }

    public void addIfWinner(int[] apeach, int[] ryan) {
        int apeachScore = 0;
        int ryanScore = 0;
        for (int i = 0; i < apeach.length; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) {
                continue;
            }
            if (apeach[i] >= ryan[i]) {
                apeachScore += (10 - i);
            } else if (apeach[i] < ryan[i]) {
                ryanScore += (10 - i);
            }
        }

        int localDifference = ryanScore - apeachScore;

        if (localDifference > 0) {
            if (difference < localDifference) {
                difference = localDifference;
            }
            results.add(new Result(localDifference, ryan));
        }
    }
}

class Result {
    private final int score;
    private final List<Integer> info;

    public Result(int score, int[] info) {
        this.score = score;
        this.info = Arrays.stream(info)
                .boxed()
                .collect(Collectors.toList());
    }

    public int getScore() {
        return score;
    }

    public List<Integer> getInfo() {
        return info;
    }
}
