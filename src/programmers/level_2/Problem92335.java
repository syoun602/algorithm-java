package programmers.level_2;

/*
Problem 92335 -2022 KAKAO BLIND RECRUITMENT k진수에서 소수 개수 구하기 (Level 2)
Link to Problem - https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class Problem92335 {
    public int solution(int n, int k) {
        int answer = 0;
        String[] splited = changeNumber(n, k).split("0");
        for (String str : splited) {
            if (str.equals("")) {
                continue;
            }
            if (isPrime(Long.parseLong(str))) {
                answer++;
            }
        }

        return answer;
    }

    private String changeNumber(int n, int k) {
        String result = "";
        while (n > 0) {
            result = (n % k) + result;
            n /= k;
        }

        return result;
    }

    private boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
