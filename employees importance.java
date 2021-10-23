//Timecomplexity:-o(n^2);
//space complexity:-O(1);
//Did it run on leetcode:- Yes;
//Any problem faced while doing:- yes, got errors initially.
//your explanation with code:- as in employees list first list is parent and second list is subordinates iterating until list size when we get given 
//id if sublist size is null to break we will return total or we pass reccursivelively sublist id untill sublist size.




class Solution {
 int total=0;
    public int getImportance(List<Employee> employees, int id) {
        for(int i=0;i<employees.size();i++){
           if(employees.get(i).id==id){
               total=total+employees.get(i).importance;
               if(employees.get(i).subordinates.size()==0){
                   return total;
               }
               else{
                   for(int j=0;j<employees.get(i).subordinates.size();j++){
                       getImportance(employees,employees.get(i).subordinates.get(j));
                   }
               }
              break;
           }
            
        }

        
   return total;}
    
}

