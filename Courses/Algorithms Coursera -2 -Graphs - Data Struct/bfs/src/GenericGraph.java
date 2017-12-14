import java.util.*;

public class GenericGraph {

    private int[][] adjMatrix;
    private int n=0; //Num of Nodes
    private int rootNode=0;
    private boolean[] visited;
    public int[] distance;

    public GenericGraph(int[][] mat) {
        n = mat.length;

        if (n < 1) {
            System.out.println("Bad input");
            return;
       }
        adjMatrix= new int[n][n];
        visited = new boolean[n];
        distance = new int[n];

        for(int i=0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = mat[i][j];
            }
        }

      clearVisited();


    }
    void clearVisited(){
        //set visited as not true for each vertex
        for(int i=0; i < n ; i++){
            visited[i] = false;
        }
    }

    public void bfs(int startNode){

        int currentlyWorkingNode=0;
        int unVisited=0;
        Queue<Integer> bfsq = new LinkedList<Integer>();
        ArrayList al = new ArrayList();


        rootNode= startNode;
        currentlyWorkingNode = rootNode;
        visited[currentlyWorkingNode] = true;
        bfsq.add(currentlyWorkingNode);
        distance[currentlyWorkingNode] =0 ; //starting point

        al.add(currentlyWorkingNode);

        //Find adjacent unvisited node of currentlyWorkingNode
        int top=0;
        while(!bfsq.isEmpty()){

            // from top of queue get the element
            currentlyWorkingNode = bfsq.peek();
            unVisited = getAdjacentUnvisitedNode(currentlyWorkingNode);

            if(unVisited!=-1) {
                visited[unVisited] = true;
                bfsq.add(unVisited);
                distance[unVisited] = distance[currentlyWorkingNode] +1;

                al.add(unVisited);

            } else{
                //remove that node from queue
                bfsq.remove();
            }
        }


        //Print al
        System.out.println(Arrays.toString(al.toArray()));
        clearVisited();

    }

    public void dfs(int startNode){

        int currentlyWorkingNode=0;
        int unVisited=0;
        Stack<Integer> dfss = new Stack<Integer>();
        ArrayList al = new ArrayList();


        rootNode= startNode;
        currentlyWorkingNode = rootNode;
        visited[currentlyWorkingNode] = true;
        dfss.push(currentlyWorkingNode);
        al.add(currentlyWorkingNode);

        //Find adjacent unvisited node of currentlyWorkingNode
        int top=0;
        while(!dfss.isEmpty()){

            // from top of queue get the element
            currentlyWorkingNode = dfss.peek();
            unVisited = getAdjacentUnvisitedNode(currentlyWorkingNode);

            if(unVisited!=-1) {
                visited[unVisited] = true;
                dfss.push(unVisited);

                al.add(unVisited);

            } else{
                //remove that node from queue
                dfss.pop();
            }
        }


        //Print al
        System.out.println(Arrays.toString(al.toArray()));
        clearVisited();
    }

    private int getAdjacentUnvisitedNode(int currentNode){

        for(int k=0; k<n; k++){
            if ( adjMatrix[currentNode][k] > 0 ) {
                if (!visited[k])
                    return k;
            }
        }

        return -1; // no adjacent unvisited nodes

    }
    public static void main(String[] args) {

        int[][] matrix =
                {   { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
                    { 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
                    { 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
                    { 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
                    { 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
                    { 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
                    { 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
                    { 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
                    { 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8

        GenericGraph gg = new GenericGraph(matrix);
        gg.bfs(0);
        System.out.println("Distances for each Vertex from root " + Arrays.toString(gg.distance));

        gg.dfs(0);
    }
}
