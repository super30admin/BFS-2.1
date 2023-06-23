/*

// Time Complexity : O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Intially store the indexes of the rotten oranges. Count the numner of rotten oranges
If all rotten then time is 0.
Push indexes of rotten into the queue
Iterate through the queue for the given level and iterate untill queue doesnt get empty
if not rotten found add those into the queue and turn them rotten to avoid repeatability also reduce non rotten items by 1
For each time queue not empty increase the level by 1
if non rotten remains send -1
if all rotten then send the level-1


*/



#include<iostream>
#include<vector>
#include<queue>

using namespace std;

typedef struct gg{
    int x;
    int y;
    gg(int x,int y):x(x),y(y){}
}gg;


class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size(); 
        int n = grid.at(0).size();
        queue<gg> q;
        int sum{},nrt{},cnt{};
        //sum for counting the number of rotten and empty , so if all rotten then 0 time
        //nrt for non-rotten, store non-rotten, should turn to zero after algorithm if all gets rotten
        //cnt to count the number of while loop executed i.e times the size of queue is found non empty
        for(int i{};i<m;++i){
            for(int j{};j<n;++j){
                int val = grid.at(i).at(j);
                if(val == 2) q.push(gg(i,j)); // storing the rotten for initiail conditions dfs
                if(val == 2 || val == 0) sum++; // sum if all are rotten
                if(val == 1) nrt++; // for non rotten
            }
        }
        //cout<<"not rotten"<<nrt<<endl;
        if(sum == m*n) return 0; // if all rotten then 0 time
        vector<gg> dirs{
            gg(0,1),
            gg(0,-1),
            gg(-1,0),
            gg(1,0)
        }; // direction matrix
        // running for dfs until queue is not empty
        while(!q.empty()){
            int sz = q.size();
            //cout<<"size"<<sz<<endl;
            // going through all the rotten nodes in queue.
            for(int i{};i<sz;++i){
                gg node = q.front();
                // to check all directions, convert non - rotten to rotten and push into queue
                for(gg &dir:dirs){
                    int a = node.x + dir.x;
                    int b = node.y + dir.y;
                    //cout<<"dir in matrix"<<a<<" "<<b<<endl;
                    //check if direction exist
                    if(a>=0 && a<m && b>=0 && b<n){
                        if(grid.at(a).at(b) == 1){ //non-rotten do what above mentioned in for loop
                            grid.at(a).at(b) = 2;
                            q.push(gg(a,b));
                            nrt--; // reducing non-rotten 
                        }
                    }
                }
                q.pop();
            }
            cnt++;//counting number of times queue size exists or number of levels
        }
        //cout<<"not rotten left"<<nrt<<endl;
        if(nrt != 0) return -1; // if non-rotten left
        return --cnt;// time taken is level of bfs-1
    }
};