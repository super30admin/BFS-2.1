// Approach 1 - BFS
// Time Complexity -  O(m*n) - Since we are going through all the elements in our input grid.
// Space Complexity - O(m*n) - space of the queue.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> dirs;
    int m, n;
public:
    int orangesRotting(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();
        dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        
        queue<vector<int>> q;
        int fresh = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    q.push({i, j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(fresh == 0)
            return 0;
        
        int time = 0;
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                vector<int> curr = q.front(); q.pop();
                for(vector<int> dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    // check bounds
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.push({nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh == 0)
            return time-1;
        else
            return -1;
    }
};

// Approach 2 - DFS
// Time Complexity -  O(m^2*n^2)
// Space Complexity - O(m^2*n^2)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> dirs; 
    //int m, n;
    private:
    void dfs(vector<vector<int>>& arr, int i, int j, int minutes){
        // base
        if(i < 0 || j < 0 || i == arr.size() || j == arr[0].size())
            return;
        if(arr[i][j] != 1 && arr[i][j] < minutes)
            return;
        //logic
        arr[i][j] = minutes;
        for(vector<int> dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(arr, nr, nc, minutes+1);
        }
    }
public:
    int orangesRotting(vector<vector<int>>& grid) {
        dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int minutes = 0;
        int m = grid.size();
        int n = grid[0].size();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    dfs(grid, i, j, 2);
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)
                    return -1;
                else if(grid[i][j] != 0)
                    minutes = max(minutes, grid[i][j] -2);
            }
        }
        return minutes;
    }
};