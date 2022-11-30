// Time Complexity : O(m*n) where n is the number of nodes
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes

//Traverse the tree using BFS with 2s in the grid as the root
//Add them to the queue and continue to perform a bredth first search
//The level-1 would be the time taken to rot all the oranges 

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.size() == 0) return 0;

        int m = grid.size();
        int n = grid[0].size();

        //queue to keep track of the coordinates 
        queue<pair<int,int>> q;

        //Totoal number of fresh oranges 
        int freshOranges = 0;

        //direction array
        vector<vector<int>> dirs ({{-1,0}, {1,0}, {0,-1}, {0,1}}); //U D L R

        //level to mantain the time 
        int level = 0;

        //traverse the grid to find the rotten oranges
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    q.push({i,j});
                }
                else if (grid[i][j] == 1){
                    freshOranges++;
                }
            }

        
        if (freshOranges == 0) return 0; 

        //bfs with level 
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                pair<int, int> coordinates = q.front();
                q.pop();
                for(auto each_dir : dirs){
                    int new_row = coordinates.first + each_dir[0];
                    int new_col = coordinates.second + each_dir[1];
                    //the node is within bounds and the value is 1 which means its a fresh orange
                    if(new_row >= 0 && new_col >= 0 && new_row < m && new_col < n && grid[new_row][new_col] == 1 ){
                        grid[new_row][new_col] = 2;
                        q.push({new_row, new_col});
                        freshOranges--;
                    }
                }
            }
            level++;
        }
        if(freshOranges > 0) return -1; //there are still fresh oranges remaining
        return level-1;
    }
};