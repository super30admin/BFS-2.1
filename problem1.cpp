
// Time Complexity : O(m*n )
// Space Complexity : O( m*n )
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//  BFS

class Node {

    public:
        int timeframe;
        int i;
        int j;
       Node( int timeframe, int i, int j ){
           this->timeframe = timeframe;
           this->i=i;
           this->j=j;
       }
};

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        vector<pair<int,int>>diarr = { {0,-1}, {1,0}, {-1,0}, {0, 1} };
        list<Node*>l1;
        for( int i=0; i<rows; i++){
            for( int j=0; j<cols; j++){
                if( grid[i][j] == 2){
                    Node* n = new Node( 0, i, j);
                    l1.push_back( n );
                }
            }
        }
        
        Node * curr = nullptr;
        while( l1.size() ){
            curr = l1.front();
            l1.pop_front();
            for( int k =0; k<diarr.size(); k++){
                int newi = curr->i + diarr[k].first;
                int newj = curr->j + diarr[k].second;
                int newt = curr->timeframe + 1;
                if( ( newi < 0 ) || ( newi >= rows ) || ( newj < 0 ) || ( newj >= cols ) ||
                    grid[newi][newj] == 0 || grid[newi][newj] == 2 ){
                    continue;
                }
                grid[newi][newj] = 2;
                Node * newnode = new Node( newt, newi, newj);
                l1.push_back( newnode );
            }
        }
        
        for( int i=0; i<rows; i++){
            for( int j=0; j<cols; j++){
                if( grid[i][j] == 1){
                    return -1;
                }
            }
        }  
        if ( curr != nullptr ){
            return curr->timeframe;
        }
        return 0;
    }
};
