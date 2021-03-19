//TC: O(n)
//SC: O(n) asymptotic where n is number of elements

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
        
        //save all employee information (employee id to employee structure) in hashmap.
        
        //perform sanity checks for input
        if(employees.size()==0)
            return 0;
        
        unordered_map<int, Employee*> empMap;
        queue<int> q;
        int totalImp = 0;

        
        //save employee id, employee information in a hashmap
        for(int i=0; i<employees.size(); i++){
            //accessing element through pointer
            empMap[employees[i]->id] = employees[i];
        }
        
        //now, perform q based BFS of a particular node. Pass the employee ID to the queue and get the employee information from there.
        
        //SUBORDINATES do not have children!
        q.push(id);
        while(!q.empty()){
            int currId = q.front();
            q.pop();
            Employee *currEmp = empMap[currId];
            totalImp += currEmp->importance;
            
            vector<int> subords = currEmp->subordinates;
            for(int i=0; i<subords.size(); i++)
                q.push(subords[i]);
        }
        
        return totalImp;
        
    }
};