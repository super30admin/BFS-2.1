// # Employee Importance

// # Time Complexity : O(N)
// # Space Complexity : O(h), h is height of the tree
// # Did this code successfully run on Leetcode : Yes
// # Any problem you faced while coding this : No
// # Your code here along with comments explaining your approach
// # Approach
// """
// Using BFS approach, initializing a hashmap to store information. A queue
// is maintained in which id's are used. Elements are checked 1 by 1 for its 
// subordinates and we keep polling out the elements to find the result. 
// """
// Using DFS approach, initializing a hashmap to store information. Elements are checked 1 by 1 for its 
// subordinates and we push the subordinates to recursive stack and add importance.
// """





/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/
//BFS
class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        
        if( employees.size()==0){
            return 0;
        }
        
        unordered_map<int, Employee*> m1;
        
        for( int i=0; i< employees.size(); i++){
            if(m1.find(employees[i]->id) == m1.end()){
                m1[employees[i]->id] = employees[i];
            }
        }
        
        int total =0;
        queue<int> q1;
        q1.push( id);
        
        while(!q1.empty()){
            
            int ele= q1.front();
            q1.pop();
            
            Employee* emp_obj = m1[ele];
            total += emp_obj->importance;
            
            vector<int> emp_sub;
            emp_sub = emp_obj->subordinates;
            
            for(int i=0 ; i< emp_sub.size() ; i++){
                
                q1.push( emp_sub[i] );
            }
            
        }
        
        return total;
        
    }
};



/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

//DFS
class Solution {
public:
    
    unordered_map<int, Employee*> m1; //global
    int total =0; //global
    
    int getImportance(vector<Employee*> employees, int id) {
        
        if(employees.size()==0){
            return 0;
        }
        
        for( int i=0; i< employees.size(); i++){
            if(m1.find(employees[i]->id) == m1.end()){
                m1[employees[i]->id] = employees[i];
            }
        }
        
        dfs( id);
        return total;
    }
    
    void dfs(int id){
        
        Employee* emp_obj = m1[id];
        total += emp_obj-> importance;
        
        vector<int> emp_sub;
        emp_sub = emp_obj->subordinates;
            
        for(int i=0 ; i< emp_sub.size() ; i++){
                
               dfs( emp_sub[i] );
       }
    }
    
};