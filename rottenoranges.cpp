//Time complexity : O(m * n)
//Space complexity : O(m * n)

//Approach:
            // Keep count of fresh oranges
            // Keep locations of all rotten oranges
            // Start applying BFS from all locations of rotten oranges
            // Once all the rotten oranges are traversed through BFS, check the count of fresh oranges
            // If all fresh oranges are rotten, return the time 
            // If not all fresh oranges are rotten then return -1

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.size() == 0)
            return 0;
        
        int m = grid.size();
        int n = grid[0].size();
        int fresh_oranges = 0;
        queue<vector<int>> q;
        
        for(int i = 0; i < m ;i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.push({i , j});
                }
                else if(grid[i][j] == 1)
                {
                    fresh_oranges++;
                }
            }
        }
        
        if(fresh_oranges == 0)
            return 0;
        
        int time = 0;
        vector<vector<int>> dirs = { { 0 , 1 } , { 0 , -1} , { 1 ,0 } , { -1 , 0 } };
        
        while(!q.empty())
        {
            int size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                vector<int> cell = q.front();
                q.pop();
                
                for(int j = 0 ; j < dirs.size(); j++)
                {
                    int row = cell[0] + dirs[j][0];
                    int col = cell[1] + dirs[j][1];
                    
                    if((row >= 0 && row < m) && (col >= 0 && col < n) && grid[row][col] == 1)
                    {
                        grid[row][col] = 2;
                        fresh_oranges--;
                        q.push({row,col});
                    }
                }
            }
            
            time++;
        }
        if(fresh_oranges != 0)
            return -1;
        
        return time - 1;
    }
};