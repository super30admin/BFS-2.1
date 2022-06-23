
// Time Complexity : O(n) where n is number of employees
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



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
        
        unordered_map<int,Employee*> mymap;
        // create hashmap of unique id and Employee class
        for( int i=0; i< employees.size(); i++){
            mymap[employees[i]->id] = employees[i];
        }
        
        list<Employee*>l1;
        l1.push_back( mymap[id] );
        int total = 0;
        while( l1.size()){
            Employee* em = l1.front();
            total += em->importance;
            l1.pop_front();
            for( int i=0; i< em->subordinates.size(); i++){
                if( mymap.find( em->subordinates[i] ) != mymap.end() ){
                    l1.push_back( mymap[ em->subordinates[i] ] );
                }
            }
        }
        return total;
    }
};
