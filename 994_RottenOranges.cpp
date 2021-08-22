// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.empty() || grid.size() == 0)
            return 0;
        int m = grid.size();
        int n = grid[0].size();
        queue<vector<int>> q;
        int fresh = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    vector<int> x = {i,j};
                    q.push(x);
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        int level = 0;
        vector<vector<int>> dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                vector<int> curr = q.front();
                q.pop();
                for(vector<int> dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        vector<int> x = {r,c};
                        q.push(x);
                        fresh--;
                    }
                }
            }
            level++;
        }
        if(fresh == 0)
            return level-1;
        return -1;
    }
};
