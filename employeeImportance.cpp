// Time Complexity :O(N) where n in the number of employees
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
    int imp=0;
    unordered_map<int,Employee*> hMap;
public:
    int getImportance(vector<Employee*> employees, int id) {
        for(auto e : employees){
            hMap[e->id] = e; 
        }
        dfs(id);
        return imp;
    }
    void dfs(int id){
        Employee *e = hMap[id];
        imp = imp + e->importance;
        for(auto subID : e->subordinates){
            dfs(subID);
        }
    }
};