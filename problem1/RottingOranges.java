//Time Complexity : O(n), n -> Total number of elements in the grid
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	/*
	 * Level order traversal using BFS. At each level, insert the rotten oranges on
	 * to the queue, until all oranges are rotten or no more oranges can be rotten.
	 */
	public int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;

		Queue<Pair> queue = new LinkedList<Pair>();
		int freshOrangeCnt = 0;
		int min = 0;
		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					freshOrangeCnt++;
				}
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j));
				}
			}
		}

		if (freshOrangeCnt == 0) {
			return 0;
		}

		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Pair p = queue.poll();
				int curRow = p.row;
				int curCol = p.col;
				for (int[] dir : dirs) {
					int r = curRow + dir[0];
					int c = curCol + dir[1];

					if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
						grid[r][c] = 2;
						freshOrangeCnt--;
						queue.add(new Pair(r, c));
					}
				}
			}
			if (!queue.isEmpty()) {
				min++;
			}
		}
		return freshOrangeCnt == 0 ? min : -1;
	}

	public static void main(String[] args) {
		RottingOranges obj = new RottingOranges();
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println("Number of minutes until all oranges rot: " + obj.orangesRotting(grid));
	}

}
