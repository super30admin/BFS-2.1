//  Rotting Oranges

// # Time Complexity : O(M*N)
// # Space Complexity : O(M*N)
// # Did this code successfully run on Leetcode : Yes
// # Any problem you faced while coding this : No
// # Your code here along with comments explaining your approach
// # Approach
// """
// Using DFS approach, finding the rotten oranges positioon i.e 2's in grid 
// and than list is maintained to store rotten oranges After traversal, i.e checking
// in four directions conversion is done from 1's to 2's and fresh orange count is 
// decreased and time is increased and returned. ( using level information from queue to count time)


class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
    int r = grid.size();
    int c = grid[0].size();
        
    pair<int, int> p1;
    queue<pair<int,int>> q1;
    int CountFreshOranges=0;  
    int total =0;
        
    for(int i=0; i< r ; i++){
        for(int j=0; j< c; j++){
            if( grid[i][j]==2){
                p1.first = i;
                p1.second= j;
                
                q1.push(p1);
            }
            
            if( grid[i][j]==1){
                CountFreshOranges +=1;
            }       
        }
    }
     
    if(CountFreshOranges ==0 ) {
        return 0;
    }  
        
    //BFS
    while(!q1.empty()){
        
        int size= q1.size();
        for( int i=0; i< size ; i++){
            
            p1 = q1.front();
            q1.pop();
            
            int x = p1.first;
            int y = p1.second;
            
            if(x >= 0 && x < r  && y-1 >=0 && y-1 <c && grid[x][y-1]==1 )
            {
                grid[x][y-1]= 2;
                p1.first= x;
                p1.second = y-1;
                q1.push(p1);
                CountFreshOranges--;
            }
            
            if(x >= 0 && x < r  && y+1 >=0 && y+1 <c && grid[x][y+1]==1 )
            {
                grid[x][y+1]= 2;
                p1.first= x;
                p1.second = y+1;
                q1.push(p1);
                CountFreshOranges--;
            }
            
            if(x+1 >= 0 && x+1 < r  && y >=0 && y <c && grid[x+1][y]==1 )
            {
                grid[x+1][y]= 2;
                p1.first= x+1;
                p1.second = y;
                q1.push(p1);
                CountFreshOranges--;
            }
            
            if(x-1 >= 0 && x-1 < r  && y>=0 && y<c && grid[x-1][y]==1 )
            {
                grid[x-1][y]= 2;
                p1.first= x-1;
                p1.second = y;
                q1.push(p1);
                CountFreshOranges--;
            }
            
        }
        total++;
        
    }
        
   if(CountFreshOranges > 0){
       return -1;
   }
        
   return (total-1);
        
    }
};