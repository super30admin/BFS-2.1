//****EMPLOYEE IMPORTANCE- BFS APPROACH****
//Time complexity:o(n);
//Space complexity:o(n);
//Leetcode runnable:Y;
//Any doubts:N
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map=new HashMap<>();
        int result=0;
        
        for(Employee e : employees)
        {
            map.put(e.id, e);
        }
        
        //Declare queue
        Queue<Integer> q=new LinkedList<>();
        q.add(id);
        
        while(!q.isEmpty())
        {
            int x=q.poll();
            Employee e=map.get(x);
            result +=e.importance;
            for (int subId: e.subordinates)
            {
                q.add(subId);
            }
        }
     return result;   
    }
}

//*****EMPLOYEE IMPORTANCE - DFS APPROACH****
//Time complexity: o(n);
//Space complexity:o(n);
//Leetcode runnable: Y;
//Any doubts:N;


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map=new HashMap<>();
    int result=0;
    
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e : employees)
        {
            map.put(e.id, e);
        }
        dfs(id);
        return result;   
    }
    
    private void dfs(int eid)
    {
        //get all the information about that particular id
        Employee e=map.get(eid);
        result+=e.importance;
        //Going to its subordinates
        for(int i: e.subordinates)
        {
            dfs(i);
        }
    }
}
//*****ROTTING ORANGES****
//Time complexity:0(n);
//Space compelxity:0(n);
class Solution {
    int [][] dirs;
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        
        //null case
        if(grid.length==0 || grid==null) return 0;
        m=grid.length;
        n=grid[0].length;
                    //L     //R  //U    //D
        dirs=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        
        //Initializing the queue
        Queue<int[]> q=new LinkedList<>();
        
        //Step-1-Iterate through the array- 
        //Add rotten oranges to the queue
        //Get the count for the fresh oranges
        int fresh=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                //If the orange is Rotten then add it inside the queue
                if(grid[i][j]==2)
                {
                    q.add(new int[] {i,j});   
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
                    
            }
        }
        if(fresh==0) return 0;
        int time=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            
            //Processing the level
            for(int i=0;i<size;i++)
            {
                int[] curr= q.poll();
                //Iterate on directions and find neighbours
                for(int[] dir:dirs)
                {
                    int nr=curr[0]+dir[0];
                    int nc=curr[1]+dir[1];
                    
                    //Check bounds
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1)
                    {
                        //Make it rotten
                        grid[nr][nc]=2;
                        //Decrease fresh count
                        fresh--;
                        //Add it to queue
                        q.add(new int[] {nr,nc});   
                    }
                }
            }
            time++;
        }
        if(fresh!=0) return -1;
        return time-1;

            
    }
}
