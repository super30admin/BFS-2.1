//TC: O(m*n)
//SC: O(1)
//Use any of the approaches BFS or DFS. idea is to start with pushing all the rotten oranges in the queue and then tranversing over its neighbors making them rotten, we will capture time at each level as well as keep a variable named fresh to make a distinction between the cases where fresh is 0 meaning all fresh oranges are rotten, if its not 0 at the end of BFS that means we cound rot all the oranges and return -1. otherwise return time-1 beciase it increases after eaach level and we end up calculating one exrta time 
class Solution {
public:
int m,n ;
vector<vector<int>> dirs{{0,1},{1,0},{0,-1},{-1,0}};
    int orangesRotting(vector<vector<int>>& grid) {
        m=grid.size();
        n=grid[0].size();
        queue<pair<int,int>> q;
        int fresh=0;
        int minutes=0;
        for(int i=0;i<grid.size();++i)
        {
            for(int j=0;j<grid[0].size();++j)
            {
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2)
                    q.push({i,j});
            }
        }
        if(fresh==0)
            return 0;
        while(!q.empty())
        {
            int size=q.size();
            for(int i=0;i<size;++i)
            {
                auto curr=q.front(); q.pop();

                for(auto dir:dirs)
                {
                    int newR=curr.first+dir[0];
                    int newC=curr.second+dir[1];
                    if(valid(newR,newC) and grid[newR][newC]==1)
                    {
                        q.push({newR,newC});
                        grid[newR][newC]=2;
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        if(fresh!=0)
            return -1;
    return minutes-1;
    }
    bool valid(int r, int c)
    {
        return r>=0 and c>=0 and r<m and c<n;
    }
};