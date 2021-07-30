public class BellmanFordAlgo {


  public static void main(String[] args) {

    char matrix[][] = { { 'O', 'O', 'O', 'O', 'G' },
        { 'G', 'W', 'W', 'O', 'O' } };
    int [][] output = doBellmanFordAlgo(matrix);

    for(int i = 0; i < output.length; i++)
    {
      for(int j = 0; j < output[0].length; j++)
      {
        System.out.print(output[i][j] + " ");
      }
      System.out.println();
    }



  }

  public static void initializeSingleSource(char[][] graph, GNode s, int[][] distance){
    for(int i=0 ; i<graph.length; i++){
      for(int j=0; j < graph[0].length ; j++){
        distance[i][j] = -1;
      }
    }
    distance[s.i][s.j] = 0;
    s.dist = 0;

  }

  public static void relax(GNode u, GNode v, int[][] distance){

    if(v.dist != -1 && v.dist > u.dist + 1){
      v.dist = u.dist + 1;
      distance[v.i][v.j] = v.dist;

    }
  }

  public static int[][] doBellmanFordAlgo(char[][] graph){
    int [][] distance = new int[graph.length][graph[0].length];
    GNode s = null;
    for(int i=0 ; i<graph.length; i++){
      for(int j=0; j < graph[0].length ; j++){
        if(graph[i][j] == 'W'){
          continue;
        }else if(graph[i][j] == 'G'){
           s = new GNode(i,j,-1);
          initializeSingleSource(graph,s,distance);

        }
        else if(graph[i][j] == 'O' && distance[i][j] > 0){
           s = new GNode(i,j,-1);
          initializeSingleSource(graph,s,distance);

        }

        if(s != null) {
          if (i - 1 >= 0 && i-1 <= graph.length-1 && graph[i - 1][j] == 'O') {
            GNode v = new GNode(i - 1, j, -1);
            relax(s, v, distance);
          }
          if (i + 1 >= 0 &&  i+1 <= graph.length-1 && graph[i + 1][j] == 'O') {
            GNode v = new GNode(i + 1, j, -1);
            relax(s, v, distance);
          }
          if (j - 1 >= 0 &&  j-1 <= graph[0].length-1 && graph[i][j - 1] == 'O') {
            GNode v = new GNode(i, j - 1, -1);
            relax(s, v, distance);
          }
          if (j + 1 >= 0 &&   j+1 <= graph[0].length-1 &&  graph[i][j + 1] == 'O') {
            GNode v = new GNode(i, j + 1, -1);
            relax(s, v, distance);
          }
        }

        }
      }

    return distance;

  }


}

class GNode {

  int i;
  int j;
  int dist;

  public GNode(int i, int j, int dist) {
    this.i = i;
    this.j = j;
    this.dist = dist;

  }
}
