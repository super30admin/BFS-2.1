//https://leetcode.com/problems/rotting-oranges
/*
Time: O(N) where N = grid.length
Space: O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class RottingOranges {

    public int rottingOranges(int[][] grid) {
        int mins = 0;
        int[][] directions = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

        Set<String> fresh = new HashSet<String>();
        Set<String> rotten = new HashSet<String>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    fresh.add("" + i + j);

                else if (grid[i][j] == 2)
                    rotten.add("" + i + j);

            }
        }

        // we want to try and infect other fresh oranges, so loop through freshes*/
        while (fresh.size() > 0) {
            Set<String> infected = new HashSet<>();

            for (String s : rotten) {
                int rottenI = s.charAt(0) - '0';
                int rottenJ = s.charAt(1) - '0';

                for (int[] direction : directions) {
                    int nextI = rottenI + direction[0];
                    int nextJ = rottenJ + direction[1];
                    String adjacentIJ = "" + nextI + nextJ;

                    if (fresh.contains(adjacentIJ)) {
                        fresh.remove(adjacentIJ);
                        infected.add(adjacentIJ);
                    }
                }
            }
            if (infected.size() == 0)
                return -1;

            rotten = infected; // update the rotten set (from the infected set)
            mins++;
        }

        return mins;
    }
}
