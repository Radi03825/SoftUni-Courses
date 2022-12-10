package solutions;

import java.util.PriorityQueue;

public class CookiesProblem {
    public Integer solve(int requiredSweetness, int[] cookiesSweetness) {
        PriorityQueue<Integer> cookies = new PriorityQueue<>();

        for (int sweetness : cookiesSweetness) {
            cookies.offer(sweetness);
        }

        Integer currentMinSweetness = cookies.peek();
        int steps = 0;

        while (currentMinSweetness < requiredSweetness && cookies.size() > 1) {
            int leastSweetCookie = cookies.poll();
            int secondLeastSweetCookie = cookies.poll();

            int combinedSweetness = leastSweetCookie + 2 * secondLeastSweetCookie;

            cookies.add(combinedSweetness);

            currentMinSweetness = cookies.peek();
            steps++;
        }


        return currentMinSweetness > requiredSweetness ? steps : -1;
    }
}
