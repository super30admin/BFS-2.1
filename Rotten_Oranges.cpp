class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        queue<pair<int , int>> q;
        int count_fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.push(make_pair(i,j));
                }
                else if(grid[i][j]==1){
                    count_fresh++;
                }
            }
        }
        if(count_fresh==0)return 0;
        int dir[4][2] ={{0,1}, {1,0}, {-1,0}, {0,-1}};
        int time =0;
        while(!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                pair<int, int>curr = q.front();
                q.pop();
                for(int d=0;d<4;d++){
                    int nr = d[dir][0]+ curr.first;
                    int nc = d[dir][1] + curr.second;
                //Boundary check
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                    q.push(make_pair(nr, nc));
                    grid[nr][nc]=2;
                    count_fresh--;
                }
                }
            }
            time++;
        } 
        if(count_fresh==0)return time-1;
        return -1;
        
    }
};
