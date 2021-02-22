class Solution {
    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NO

    // Your code here along with comments explaining your approach
    public int orangesRotting(int[][] grid) {

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int count = 0, min = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    count++;
                else if (grid[i][j] == 2) {
                    q.add(new Pair<Integer, Integer>(i, j));
                }
            }

        if (count == 0)
            return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            min++;
            for (int k = 0; k < size; k++) {
                Pair<Integer, Integer> p = q.poll();

                for (int[] d : dir) {
                    int i = p.getKey() + d[0];
                    int j = p.getValue() + d[1];

                    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        count--;
                        q.add(new Pair<Integer, Integer>(i, j));
                    }
                }

                if (count == 0)
                    return min;
            }
        }

        if (count == 0)
            return min;

        return -1;

    }
}