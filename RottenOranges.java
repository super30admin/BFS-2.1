public class RottenOranges {
    // TC is O(m*n)
    // SC is O(m*n)
    public int orangesRotting(int[][] grid) {

        Queue<List<Integer>> q = new LinkedList<>();
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(i, j));
                    q.add(list);
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<Integer> curr = q.poll();
                for (int[] d : dir) {
                    int nr = curr.get(0) + d[0];
                    int nc = curr.get(1) + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            fresh--;
                            q.add(Arrays.asList(nr, nc));
                        }
                    }
                }
            }
            time++;
        }
        if (fresh == 0)
            return time - 1;
        return -1;
    }
}
