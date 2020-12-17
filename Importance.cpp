// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


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
public:
    int getImportance(vector<Employee*> employees, int id) {
        if(employees.empty()){
            return 0;
        }
        map<int, Employee*> _map;
        for(Employee* employee: employees){
            _map.insert(pair<int, Employee*>(employee->id, employee));
        }
        int total = 0;
        queue<int> q;
        q.push(id);
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            Employee* obj = _map[curr];
            total = total + obj->importance;
            for(int sub : obj->subordinates){
                q.push(sub);
            }
        }
        return total;
    }
};
