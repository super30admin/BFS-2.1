// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.empty()){
            return -1;
        }
        int m=grid.size();
        int n = grid[0].size();
        int fresh =0, total = 0;
        queue<vector<int>> q;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.push({i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        vector<vector<int>> dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        while(!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                vector<int> curr = q.front();
                q.pop();
                for(vector<int> dir:dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1){
                        grid[r][c] = 2;
                        q.push({r,c});
                        fresh--;
                    }
                }
            }
            total++;
        }
        if(fresh>0){
            return -1;
        }
        return total-1;;
    }
};
