//Time Complexity- O(m*n)
//Space Complexity- O(m*n)

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        if(grid.size()==0){
            return 0;
        }
        int fresh=0;
        queue<pair<int,int>> q;
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[i].size();j++){
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
        
        int minutes=0;
        int hori[]={0,0,1,-1};
        int ver[]={1,-1,0,0};
        while(!q.empty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                auto curr=q.front();
                q.pop();
                for(int j=0;j<4;j++){
                    int ni=curr.first+hori[j];
                    int nj=curr.second+ver[j];
                    if(ni>=0 && nj>=0 && ni<grid.size() && nj<grid[0].size() && grid[ni][nj]==1){
                        fresh--;
                        q.push({ni,nj});
                        grid[ni][nj]=2;
                    }
                }
            }
            minutes++;
            if(fresh==0){
                return minutes;
            }
        }
        return -1;
    }
};