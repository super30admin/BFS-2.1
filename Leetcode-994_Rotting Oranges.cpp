// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, initially on deciding search space.

class Solution 
{
public:
    int orangesRotting(vector<vector<int>>& grid) 
    {
        vector<vector<int>> directions = {{1,0}, {0,1}, {0,-1},{-1,0}};
                
        queue <pair<int,int>> rotten_orange_queue;
        int fresh_orange_count=0;
        
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[0].size();j++)
            {
                if(grid[i][j]==2)
                    rotten_orange_queue.push(make_pair(i,j));
                
                else if(grid[i][j]==1)
                    fresh_orange_count++;
            }
        }
        
        if(fresh_orange_count==0)
            return 0;
        
        int count=0;
        
        while(!rotten_orange_queue.empty())
        {
            int size = rotten_orange_queue.size();
            
            for(int i=0;i<size;i++)
            {
                pair<int, int> current_ele = rotten_orange_queue.front();
                rotten_orange_queue.pop();
                
                for(auto dir : directions)
                {
                    int row = current_ele.first + dir[0];
                    int col = current_ele.second + dir[1];
                    
                    if(row>=0 && row<=grid.size()-1 && col>=0 && col<=grid[0].size()-1 && grid[row][col]==1)
                    {
                        grid[row][col]=2;
                        rotten_orange_queue.push({row,col});
                        fresh_orange_count--;
                    }
                    
                } 
                
            }
            count++;
        }
        
        if(fresh_orange_count==0)
            return count-1;
        
        return -1;
    }
};