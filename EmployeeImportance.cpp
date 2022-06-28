// Approach 1 - BFS
// Time Complexity -  O(n)
// Space Complexity -  O(n)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    unordered_map<int, Employee*> map;
public:
    int getImportance(vector<Employee*> employees, int id) {
        int answer = 0;
        for(Employee* e : employees)
            map[e->id] = e;
        
        queue<int> q;
        q.push(id);
        
        while(!q.empty()){
            int eId = q.front(); q.pop();
            Employee* e = map[eId];
            answer += e->importance;
            for(int subId : e->subordinates)
                q.push(subId);
        }
        return answer;
    }
};

// Approach 1 - DFS
// Time Complexity -  O(n)
// Space Complexity -  O(n)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    unordered_map<int, Employee*> map;
    int importance = 0;
    private:
    void dfs(int id){
        // base is not needed since my for loop won't let me go out of bounds
        
        // logic
        Employee* e = map[id];
        importance += e->importance;
        for(int sID : e->subordinates)
            dfs(sID);
    }
public:
    int getImportance(vector<Employee*> employees, int id) {
        
        for(Employee* e : employees)
            map[e->id] = e;
        dfs(id);
        return importance;
    }
};