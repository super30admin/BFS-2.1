// TC : O(n) 
// SC: O(n)

// Approach: Iterate through the grid and every time we find a rotten orange,
// add it to the queue. Also, count the no. of total fresh oranges in the 
// grid initially.
// We iterate through the queue. We remove the pair and check if this is a rotten
// orange. If it's a rotten orange, we check the neighbours and mark fress oranges
// as rotten and decrement freshOrange count. We also add the new rotten oranges to
// the queue, so we can iterate over them later. Every iteration in queue, we increment
// a timer count.
// Check if the freshOrange count is 0, if it's true, we were able to mark all the oranges
// as rotten and return the time.

// LC- 994. Rotting Oranges

import javafx.util.*;
import java.util.*;

public class RottingOranges {
  private static final int empty = 0, fresh = 1, rotten = 2;
  private static final int[][] directions = {
      { 0, -1 },
      { 0, 1 },
      { 1, 0 },
      { -1, 0 }
  };

  public int orangesRotting(int[][] grid) {
    if (grid == null) {
      return -1;
    }

    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

    int m = grid.length, n = grid[0].length;
    int remainingFresh = 0;
    int time = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == rotten) {
          queue.add(new Pair(i, j));
        } else if (grid[i][j] == fresh) {
          remainingFresh++;
        }
      }
    }

    if (remainingFresh == 0) {
      return 0;
    }

    while (!queue.isEmpty()) {
      Queue<Pair<Integer, Integer>> next = new LinkedList<>();

      while (!queue.isEmpty()) {
        Pair<Integer, Integer> p = queue.remove();

        for (int[] dir : directions) {
          int x = p.getKey() + dir[0];
          int y = p.getValue() + dir[1];

          if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == fresh) {
            grid[x][y] = rotten;
            remainingFresh--;

            next.add(new Pair(x, y));
          }
        }

      }
      queue = next;

      // if(!next.isEmpty()) {
      // time++;
      // }
      time++;
    }

    return remainingFresh > 0 ? -1 : time - 1;
  }
}
