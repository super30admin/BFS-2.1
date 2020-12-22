//Time O(mn)
//Space O(mn)
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> q;
        int mins = 0, freshOrange = 0;
        vector<vector<int>> dir{{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int i = 0;i<grid.size();i++){
            for(int j=0;j<grid[i].size();j++){
                if(grid[i][j] == 2)
                    q.push(make_pair(i,j));
                if (grid[i][j] == 1)
                    freshOrange++; // count fresh oranges
            }
        }
        
        while(!q.empty() && freshOrange>0){
            mins++;
            int size = q.size();
            for(int i=0;i<size;i++){
                pair<int,int> p = q.front();q.pop();
                for(int j=0;j<dir.size();j++){
                    int k = p.first + dir[j][0];
                    int l = p.second + dir[j][1];
                    
                    if(k>=grid.size() || k<0 || l>=grid[0].size() || l<0 || grid[k][l]!=1) continue;
                    
                    grid[k][l] = 2;
                    q.push(make_pair(k,l));
                    freshOrange--;
                }
            }
        }
        
        if(freshOrange==0) return mins;
        return -1;
    }
};