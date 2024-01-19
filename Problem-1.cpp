// Time Complexity : O(M*N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: BFS using queue - stored the rotten oranges in the queue and kept
// track of fresh oranges. Check 4 directions from the current cell and if fresh
// rot the orange around that add to queue and decrement fresh count.

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<pair<int,int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int fresh = 0;
        queue<pair<int,int>> q;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    q.push({i,j});
                }
            }
        }
        int time = 0;
        if(fresh == 0) return 0;
        while(!q.empty()){
            int qSize = q.size();
            for(int i=0;i<qSize;i++){
                auto curr = q.front();
                q.pop();
                for(auto dir : dirs){
                    int nr = curr.first + dir.first;
                    int nc = curr.second + dir.second;
                    if(nr >= 0 && nr <m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.push({nr,nc});
                    }
                }
            }
            time++; 
        }
        if(fresh == 0) return time-1;
        return -1;
    }
};