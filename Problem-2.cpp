// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: BFS using queue, stored the emp object in map for easy access.
// took id and got the subord details from map and calculated importance.

#include <bits/stdc++.h>
using namespace std;


// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int,Employee*> mp;
        for(int i=0;i<employees.size();i++){
            mp[employees[i]->id] = employees[i];
        }
        queue<int> q;
        q.push(id);
        int result = 0;
        while(!q.empty()){
            int eid = q.front();
            q.pop();
            Employee* e = mp[eid];
            result += e->importance;
            for(int subid : e->subordinates){
                q.push(subid);
            }
        }
        return result;
    }
};