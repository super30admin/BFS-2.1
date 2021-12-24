// Time Complexity = O(M * N)
// Space Complexity = O(M * N)

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.size() == 0){
            return 0;
        }
        int fresh = 0;
        queue<vector<int>> q;
        vector<vector<int>> dircts = {{0,1},{0,-1},{1,0},{-1,0}};
        int rows = grid.size();
        int cols = grid[0].size();

        for(int i = 0; i< rows;i++){
            for(int j = 0; j < cols;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    q.push({i,j});
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        int time = 0;
        while(!q.empty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                vector<int> temp = q.front();
                q.pop();

                for(vector<int> dir : dircts){
                    int nr = temp[0] + dir[0];
                    int nc = temp[1] + dir[1];

                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.push({nr,nc});
                        fresh--;
                    }
                }
            }

            time++;
        }
        if(fresh != 0){
            return -1;
        }
        return time-1;
    }
};












