class Pairs {
    int profit;
    int capital;

    Pairs(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Pairs[] projects = new Pairs[profits.length];

        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Pairs(profits[i], capital[i]);
        }

        // Sort according to capital (ascending)
        Arrays.sort(projects, (a, b) -> a.capital - b.capital);

        // Max heap based on profit
        PriorityQueue<Pairs> pq =
            new PriorityQueue<>((a, b) -> b.profit - a.profit);

        int idx = 0;

        while (k > 0) {

            // Add all projects that we can currently afford
            while (idx < projects.length && projects[idx].capital <= w) {
                pq.add(projects[idx]);
                idx++;
            }

            // No project can be afforded
            if (pq.isEmpty()) {
                return w;
            }

            // Take the project with maximum profit
            Pairs best = pq.poll();
            w = w + best.profit;

            k--;
        }

        return w;
    }
}