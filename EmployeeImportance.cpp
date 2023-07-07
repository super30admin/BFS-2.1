//Time Compleixty: O(n)
//Space Complexity: size of the stack

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
    map<int, Employee*> mp; 
    int getImportance(vector<Employee*> employees, int id) {

        for(int i = 0; i < employees.size(); i++) {
            mp[employees[i]->id] = employees[i]; 
        }
        return bfs(mp[id]); 
    }

    int bfs(Employee* employee) {
        deque<Employee*> q; 
        q.push_back(employee); 

        int importance = 0; 
        while(!q.empty()) {
            Employee* emp = q.front();
            q.pop_front(); 
            importance = importance + emp->importance; 
            for(int i = 0; i < emp->subordinates.size(); i++) {
                q.push_back(mp[emp->subordinates[i]]); 
            } 
        }

        return importance; 
    }
};