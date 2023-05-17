// TC: O(n*m);
// SC: O(n*m)
// Did it run on leetcode: yes

// There are connected components so, we use dfs or bfs. In this case, BFS is more optimal than dfs.
// we need to traverse through the matrix level by level. but we need to start with all the rotten oranges.
// and do bfs. we insert the rottenorange row and col in queue , because rotten orange value =2 and that doesnot change during the program runs.




class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.empty() || grid.size()==0) return 0;
        queue<pair<int,int>>q;
        int cnt = 0;
        int ans = 0;
        for(int i = 0;i<grid.size();i++)
        {
            for(int j = 0;j<grid[0].size();j++)
            {
                if(grid[i][j]==2){
                    q.push({i,j});
                }
                else if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        if(cnt==0) return 0;
        vector<pair<int,int>> dir = {{-1,0},{1,0},{0,-1},{0,1}}; // U D L R
        while(!q.empty())
        {
            int size = q.size();
            while(size--)
            {
                auto p = q.front();q.pop();
                int r = p.first;
                int c = p.second;
                for(auto ele: dir)
                {
                    int dr = ele.first;
                    int dc = ele.second;
                    if(isValid(r+dr,c+dc,grid)){
                        cnt--;
                        grid[r+dr][c+dc] = 2;
                        q.push({r+dr,c+dc});
                    }
                }
            }
            ans++;
        }
        if(cnt!=0) return -1;
        return ans-1;
    }
    bool isValid(int r,int c,vector<vector<int>>& grid)
    {
        int m = grid.size();
        int n = grid[0].size();
        if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1) return true;
        return false;
    }
};