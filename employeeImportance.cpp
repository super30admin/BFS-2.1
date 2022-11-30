// Time Complexity : O(n) where n is the subtree with the id as the root
// Space Complexity : O(N) where N is all the nodes of the tree or all the employees
// Did this code successfully run on Leetcode : Yes

//Approach 1: BFS

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

        int totalImportance = 0;

        //traverse the input and create a hashmap for O(1) access
        unordered_map<int, Employee*> map;
        for(auto each_employee: employees){
            map[each_employee->id] = each_employee;
        }

        queue<int> q;
        q.push(map[id]->id);

        //bfs

        while(!q.empty()){
            int id = q.front();
            q.pop();
            Employee* emp = map[id];
            totalImportance += emp->importance;
            for(int subs: emp->subordinates){
                q.push(subs);
            }
        }

        return totalImportance;
    }
};


//Approach 2: DFS

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
    unordered_map<int, Employee*> map;
    int totalImportance;
    int getImportance(vector<Employee*> employees, int id) {

        totalImportance = 0;

        //traverse the input and create a hashmap for O(1) access
        for(auto each_employee: employees){
            map[each_employee->id] = each_employee;
        }

        dfs(id);
        return totalImportance;
    }
private:
    void dfs(int id){
        Employee* emp = map[id];
        totalImportance += emp->importance;
        for(int subs: emp->subordinates){
            dfs(subs);
        }
    }
};
