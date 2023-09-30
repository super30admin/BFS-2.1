//TC: O(m*n)
//Sc: O(1)
class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        int total=0;
        unordered_map<int, Employee*> map;

        for(auto emp: employees)
        {
            map[emp->id]=emp;          
        }
        queue<int> q;
        q.push(id);
        while(!q.empty())
        {
            int ids=q.front(); q.pop();
            Employee* emp=map[ids];
            total+=emp->importance;
            if(emp->subordinates.empty())
                continue;
            else
            {
                    for(auto sub:emp->subordinates)
                    {
                        q.push(sub);
                    }
            }
           
        }
        return total;
    }
};