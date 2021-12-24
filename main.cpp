/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/
//Time Complexity --> O(N)
//Space Complexity --> O(N)
class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        if(employees.size() == 0){
            return 0;
        }
        int total = 0;
        queue<int> q;
        map<int, Employee*> m;
        for(int i= 0; i< employees.size();i++){
            m[employees[i]->id] = employees[i];
        }
        q.push(id);
        while(!q.empty()){
            int temp = q.front();
            q.pop();
            Employee * emp = m[temp];
            total += emp->importance;
            for(int i = 0; i < emp->subordinates.size(); i++){
                q.push(emp->subordinates[i]);
            }
        }
        return total;
    }
};










