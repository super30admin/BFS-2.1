// TC: O(N*M)
// SC: O(N*M)
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.size()==0||grid[0].size()==0)return 0;
        int fresh = 0;
        queue<pair<int,int>>q;
        for(int i = 0; i < grid.size();i++){
            for(int j = 0; j < grid[0].size();j++){
                if(grid[i][j] == 2){
                    q.push(make_pair(i,j));//for the starting point
                }
                else if(grid[i][j]==1)fresh++;
            }
        }
        int time = 0;
        vector<vector<int>>dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.empty()){
            int size = q.size();
            time++;
            for(int i = 0; i < size;i++){
                pair<int,int>temp = q.front();q.pop();
                for(vector<int> dir:dirs){
                    int r = dir[0] + temp.first;
                    int c = dir[1] + temp.second;
                    if(r >=0 && r < grid.size() && c >=0 && c < grid[0].size() && grid[r][c] == 1){
                        grid[r][c] = 0;
                        fresh--;
                        q.push(make_pair(r,c));
                    }
                }
            }
        }
        if(fresh!=0)return -1;
        return time > 0 ? time-1:time;
    }
};