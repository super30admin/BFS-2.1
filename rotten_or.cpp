//TC: O(nm) where n is number of rows, m is number of columns
//SC: O(nm) where n is number of rows, m is number of columns

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        if(grid.size()==0 && grid[0].size()==0) return 0;
        
        int fresh = 0;
        queue<pair<int, int>> q;
        int timeElapsed = 0;
        
        //iterate through grid to get fresh count and push rotten coordinates
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    q.push({i, j});
                }
            }
        }
        
        vector<pair<int, int>> dirs;
        dirs.push_back({0, 1});
        dirs.push_back({0, -1});
        dirs.push_back({1, 0});
        dirs.push_back({-1, 0});
        
        while(!q.empty()){
            
            //calculate time at each level.
            //get size of queue, and push all neighbours of queue elements to queue and then increment time.
            
            int qsize = q.size();
            
            for(int j = 0; j<qsize; j++){
                pair<int, int> curr = q.front();
                q.pop();
                int curFirst = curr.first;
                int curSec = curr.second;

                for(int i=0; i<4; i++){
                    int newFirst = curFirst + dirs[i].first;
                    int newSec = curSec + dirs[i].second;

                    if(newFirst >=0 && newFirst < grid.size() && newSec >= 0 && newSec < grid[0].size() && grid[newFirst][newSec] == 1){
                        q.push({newFirst, newSec});
                        grid[newFirst][newSec] = 2;
                        fresh--;
                    }
                }

            }
            
            timeElapsed++;           
            
        }
        
        if(fresh != 0)
            return -1;
        
        //returning time-1 since we check the last level as well(which will not give us any more rotting)
        if(timeElapsed == 0){
            //returning 0 in this case since this is a possibility
            return 0;
        }
        return timeElapsed-1;
        
        
        
        
        
    }
};