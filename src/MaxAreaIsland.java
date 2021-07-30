public class MaxAreaIsland {

  public static void main(String[] args) {
    int [][] grid = new int [][] {
      { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }
      ,{
        0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
      {
        0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0
      },{
        0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0
      },
      {
        0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0
      },{
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0
      },
      {
        0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0
      },{
        0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0
      }
    };

    System.out.println(maxIsland(grid));

  }

  public static int maxIsland(int [][] grid){
    int max = 0;
    boolean [][] visited = new boolean[grid.length][grid[0].length];
    for(int i= 0 ; i < grid.length ; i++ ){
      for(int j=0 ; j < grid[0].length ; j++){

        if(grid[i][j] == 1 && visited[i][j] != true){
          max = Math.max(max, dfs(grid, i, j, visited));
        }

      }
    }
    return  max;

  }

  public static int dfs(int [][]grid, int i, int j, boolean [][] visited){

    if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 ||
        visited[i][j]){

      return 0;
    }

    visited[i][j] = true;
    return 1 + dfs(grid, i-1, j, visited) + dfs(grid, i+1, j, visited)
        + dfs(grid, i, j+1, visited) + dfs(grid, i, j-1, visited);


  }

}
