package baekjoon.brute_force.problem16508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int[] targetWord = new int[26];
    static int[] givenWord = new int[26];
    static int N = 0;

    public static void main(String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String T = bufferedReader.readLine();
        N = Integer.parseInt(bufferedReader.readLine());
        final Book[] books = new Book[N];

        for (char t : T.toCharArray()) {
            targetWord[t - 'A']++;
        }

        for (int i = 0; i < N; i++) {
            final StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            final String price = st.nextToken();
            final String book = st.nextToken();
            books[i] = new Book(book, Integer.parseInt(price));
        }

        dfs(0, 0, books);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(final int index, final int price, final Book[] books) {
        if (index == N) {
            if (canCreateWord() && price < answer) {
                answer = price;
            }
            return;
        }

        final int nameLength = books[index].name.length();
        for (int i = 0; i < nameLength; i++) {
            final char alphabet = books[index].name.charAt(i);
            givenWord[alphabet - 'A']++;
        }
        dfs(index + 1, price + books[index].price, books);

        for (int i = 0; i < nameLength; i++) {
            final char alphabet = books[index].name.charAt(i);
            givenWord[alphabet - 'A']--;
        }
        dfs(index + 1, price, books);

    }

    private static boolean canCreateWord() {
        for (int i = 0; i < 26; i++) {
            if (targetWord[i] > givenWord[i]) {
                return false;
            }
        }
        return true;
    }

    public static class Book {
        String name;
        int price;

        public Book(final String name, final int price) {
            this.name = name;
            this.price = price;
        }
    }
}
