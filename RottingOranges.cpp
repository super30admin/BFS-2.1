// Time Complexity: O(m*n)
// Space Compleixty: O(m+n)

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        deque<vector<int>> q; 
        int freshOranges = 0; 

        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == 2) {
                    q.push_back({i,j});
                }
            }
        }

        int elapsedTime = rottingOranges(q, grid);

        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == 1) freshOranges++; 
            }
        }


        return freshOranges == 0 ? elapsedTime : -1;         
    }

    int rottingOranges(deque<vector<int>>& q, vector<vector<int>>& grid) {
        int time = 0; 

        int dir[4][2] = { {-1,0}, {1,0}, {0,-1}, {0,1} };

        while(!q.empty()) {
            int n = q.size(); 
            bool flag = false;

            for(int i = 0; i < n; i++) {
                int row = q.front()[0];
                int col = q.front()[1];
                q.pop_front(); 

                for(int di = 0; di < 4; di++) {
                    int new_row = row + dir[di][0];
                    int new_col = col + dir[di][1];

                    if(new_row >= 0 && new_col >= 0 && new_row < grid.size() && new_col < grid[0].size()) {
                        if(grid[new_row][new_col] == 1) {
                            grid[new_row][new_col] = 2; 
                            q.push_back({new_row, new_col});
                            flag = true; 
                        }
                    }
                }     
            }

            if(flag == true) time++;  

        }

        return time; 
    }
};