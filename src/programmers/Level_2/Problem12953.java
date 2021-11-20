package programmers.Level_2;

public class Problem12953 {
    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i = 1; i < arr.length; i++)
            answer = lcm(answer, arr[i]);

        return answer;
    }

    public int gcd(int a, int b) {
        int temp;

        while(b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
