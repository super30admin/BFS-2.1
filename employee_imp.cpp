TC:O(N)
SC:O(N)


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
private:
    int total_imp = 0;
public:
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int,Employee*>umap;
        for(auto emp:employees){
            umap[emp->id] = emp;
        }
        queue<int>q;
        // to start bfs we need one starting point
        q.push(id);
        while(!q.empty()){
            int emp_id = q.front();q.pop();
            vector<int>sub = umap[emp_id]->subordinates;
            total_imp +=umap[emp_id]->importance;
            for(int s:sub){
                q.push(s);
            }   
        }
        return total_imp;
        
        
    }
};


