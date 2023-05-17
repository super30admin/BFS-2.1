// TC: O(N);
// SC: O(N)
// Did it run on leetcode: yes


// we take a map (key as id and value as Employee*) to ease our searching. then we use dfs/bfs
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
    unordered_map<int,Employee*>map;
    int ans = 0;
    int getImportance(vector<Employee*> employees, int id) {
        for(int i = 0;i< employees.size();i++)
        {
            map.insert({employees[i]->id, employees[i]});
        }
        dfs(id);
        return ans;
    }
    void dfs(int id)
    {
        Employee* curr = map[id];
        
        ans+= curr->importance;
        vector<int>v = curr->subordinates;
        for(int i = 0;i< v.size();i++)
        {
            dfs(v[i]);
        }
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

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int,Employee*>map;
        for(int i = 0;i<employees.size();i++)
        {
            map.insert({employees[i]->id, employees[i]});
        }
        queue<int>q;
        q.push(id);
        int ans=0;
        while(!q.empty())
        {
            Employee* curr = map[q.front()];q.pop();
            ans+= curr->importance;
            vector<int>v = curr->subordinates;
            for(int i = 0;i< v.size();i++)
            {
                q.push(v[i]);
            }
        }
        return ans;
    }
};