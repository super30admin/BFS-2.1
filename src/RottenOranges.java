//Time Complexity : O(M*N)
//Space Complexity : O(M*N) for queue
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

import java.util.LinkedList;
import java.util.Queue;

/**
 * Apply BFS. store all the rotten nodes in queue. Now iterate queue
 * and get its size in each iteration and increment count by 1 for every iteration.
 * In each iteration, pop the elements till the size and check their adjacent nodes
 * if they are fresh and make them rotten and push them to queue. After queue is empty,
 * check if the fresh ones are converted to rotten if so return the count elese return -1.
 */
class Solution {
	int[] x4 = { 0, 1, 0, -1 };
	int[] y4 = { 1, 0, -1, 0 };

	public int orangesRotting(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					queue.add(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					count++;
				}
			}
		}
		if (count == 0)
			return 0;
		int res = helper(grid, queue, count);
		return res;
	}

	public int helper(int[][] grid, Queue<int[]> queue, int count) {
		int time = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			time++;
			while (size-- > 0) {
				int[] pair = queue.poll();
				for (int t = 0; t < 4; t++) {
					int x = pair[0] + x4[t];
					int y = pair[1] + y4[t];
					if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
						grid[x][y] = 2;
						queue.add(new int[] { x, y });
						count--;
					}
				}
			}
		}
		System.out.println(time);
		return count == 0 ? time : -1;
	}
}