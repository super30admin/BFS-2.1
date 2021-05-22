// Time Complexity :O(N) where n is the size of the grid
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
public:
    //if(grid.size() == 0) return 0;
    int orangesRotting(vector<vector<int>>& grid) {
        int result = -1;
        int fresh = 0;
        queue<pair<int,int>> q;
        for(int i = 0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                if(grid[i][j] == 2)
                    q.push(make_pair(i,j));
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(!fresh) return 0;
        //cout<<fresh<<endl;
        vector<vector<int>> dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        pair<int,int> curr;
        int r = 0,c = 0;
        int size;
        while(!q.empty()){
            size = q.size();
            for(int i = 0;i<size;i++){
                curr = q.front();
                q.pop();
                for(auto dir : dirs){
                    r = dir[0] + curr.first;
                    c = dir[1] + curr.second;
                    if(r >=0 && r < grid.size() && c >=0 
                    && c< grid[0].size() && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        q.push(make_pair(r,c));
                    }    
                }
            }
            result++;
        }
        if(fresh > 0) return -1;
        return result;
    }
};