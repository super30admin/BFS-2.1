//Time - O(n)
//Space - O(n)
class Solution {
public:
    int find(unordered_map<int, Employee*> m, int id){
        int s = m[id]->importance;
        for(int i=0;i<m[id]->subordinates.size();i++){
            s += find(m,m[id]->subordinates[i]);
        }
        return s;
    }
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int, Employee*> m;
        for(auto emp:employees){
            m[emp->id] = emp;
        }
        
        return find(m,id);
        
    }
};