
//Time Complexity O(V+E) 
// Space Complexity O(V+E)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
using namespace std;





// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};


class Solution {
public:
    map<int,Employee*> idToEmployee;
    int total = 0;
    int getImportance(vector<Employee*> employees, int id) {
        
        for(auto emp : employees)
        {
            idToEmployee[emp->id]=emp;
        }
        dfs(id);
        return total;
    }
    
    void dfs(int id)
    {
        Employee* empObj=idToEmployee[id];
        vector<int> subordinates=empObj->subordinates;
        total+=empObj->importance;
        for(int empId : subordinates)
        {
            dfs(empId);
        }
    }
    
    
};