//Time Complexity- O(n)  (Number of Employees)
//Space Complexity- O(n) (Stack Space)

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        
        unordered_map<int,Employee*> mp;
        for(auto e:employees){
            mp[e->id]=e;
        }
        
        int ans=0;
        dfs(id,mp,ans);
        return ans;
    }
    
    void dfs(int id,unordered_map<int,Employee*> mp,int &ans){
        
        ans+=mp[id]->importance;
        for(auto e:mp[id]->subordinates){
            dfs(e,mp,ans);
        }
    }
};