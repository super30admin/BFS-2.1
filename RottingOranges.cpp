//Time Complexity O(m*n)
// Space Complexity O(m*n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
using namespace std;

class Solution {
public:
    int orangesRotting(vector<vector<int> >& grid) {
        int totalTime=0;
        int noFresh=0;
        queue<vector<int> > q;
        int rows=grid.size();
        int cols=grid[0].size();
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==2)
                {
                    vector<int> rowAndCol;
                    rowAndCol.push_back(i);
                    rowAndCol.push_back(j);
                    q.push(rowAndCol);
                }
                else if(grid[i][j]==1)
                {
                    noFresh++;
                }
            }
        }
        if(noFresh==0) return 0;
        int dird[4][2]={{-1,0},{0,-1},{0,1},{1,0}};
        
        while(!q.empty())
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                vector<int> vec=q.front();
                q.pop();
                for(int dir=0;dir<4;dir++)
                {
                    int nr=vec[0]+dird[dir][0];
                    int nc=vec[1]+dird[dir][1];
                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        vector<int> rowAndCol;
                        rowAndCol.push_back(nr);
                        rowAndCol.push_back(nc);
                        q.push(rowAndCol);
                        noFresh--;
                    }
                }
            }
            totalTime++;
        }
        if (noFresh==0)
        {
            return totalTime-1;
        }
        return -1;
    }
};