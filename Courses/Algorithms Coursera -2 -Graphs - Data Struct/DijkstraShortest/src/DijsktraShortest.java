import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
Greedy Algorithm - Dijsktra's Shortest
Given a graph and a source vertex in graph, find shortest paths from source to all vertices in the given graph
Algorithms Coursera -2 Graphs-DataStruct/DijkstraShortest

Uses a general datastructure for min. Can be optimized with min/max heap datastructure
 */

public class DijsktraShortest {

    int maxVertices=200;
    //Create array of Adjacency each element containing list of connected vertices to that element
    LinkedList<Edge>[] adj ;
    ArrayList<Vertex> al ;

    public static void main(String[] args) {

        DijsktraShortest ds = new DijsktraShortest();
        ds.read();
        //ds.printGraph();
        ds.Algo();
        ds.printSolution();

        int[] vertices = {7,37,59,82,99,115,133,165,188,197};
        ds.printAnswer(vertices);
    }

    public DijsktraShortest(){
        System.out.println("Dijkstra's Shortest path in a directed weighted graph!");

        adj = new LinkedList[maxVertices+1];
        for (int i = 1; i < adj.length; ++i) {
            adj[i] = new LinkedList<>();
        }

    }

    private void Algo() {
        try {

            //Array starting from 1
             al = new ArrayList();
            for(int i=0; i <=maxVertices; i++){

                //Create all Vertices and store the properties
                //Visited = 0(unvisited)or 1 (visited),
                Vertex v = new Vertex(i, 0, 1000000, -1);
                al.add(v);
            }
            //set distance of start vertex from start vertex =0
            al.get(1).shortestDist=0;

            int i=1;
            int currentVertex=-1;
            int vertex=-1;
            Edge edge=null;
            while(i<=maxVertices){

                System.out.println("i:" + i);
                if(al.get(i).visited==0) {
                    //Current vertex is the unvisited smallest known dist from start vertex
                    currentVertex = minDist();

                    System.out.println("Current Vertex is:" + currentVertex);
                    //For each unvisited neighbor of current vertex, calculate the distance from start

                    //Go through adj list and find neighbors and check if visited or not and then calc distance from start
                    Iterator itr = adj[currentVertex].listIterator();
                    System.out.println("Visiting unvisited neighbors of current Vertex:" + i);
                    edge = null;
                    vertex = -1;
                    int distFromStart = -1;
                    while (itr.hasNext()) {
                        edge = ((Edge) itr.next());
                        vertex = edge.vertex;
                        distFromStart = -1;
                        if (isVisited(vertex) == false) {
                            System.out.println("--Visited:" + vertex);
                            distFromStart = edge.weight + al.get(currentVertex).shortestDist;

                            if (distFromStart < al.get(vertex).shortestDist) {
                                System.out.println("---- updating shortest path for:" + vertex + " as:" + distFromStart);
                                al.get(vertex).shortestDist = distFromStart;
                                al.get(vertex).previousVertex = currentVertex;
                            }
                        }

                    }

                    // Add current vertex to visited
                    System.out.println("******************Updating visited for Vertex:" + currentVertex);
                    al.get(currentVertex).visited = 1;

                }
                i++;
            }

            System.out.println("Completed Algorithm");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Return vertex with min distance from start vertex
    //Ideally want to use a Heap+ Hashmap for quickly getting min, this is for simplicity
    private int minDist(){
        int min =Integer.MAX_VALUE;
        int minIndex=-1;
        for(int i=1; i <=maxVertices; i++) {
            if(al.get(i).visited==0){
                if(al.get(i).shortestDist<=min){
                    min = al.get(i).shortestDist;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }

    private boolean isVisited(int i){

        if(al.get(i).visited==0)
        return false;
        else return true;
    }

    private void printSolution() {
        System.out.println("Vertex \t\t Distance \t\t Visited \t\t  Previous Vertex");

        for (int i = 1; i <= maxVertices; i++) {
            System.out.println(i + "     \t\t " + al.get(i).shortestDist + "     \t\t " + al.get(i).visited + "     \t\t " + al.get(i).previousVertex );
        }
    }

    private void printAnswer(int[] vertices) {
        System.out.println("Answer:");

        for (int i = 0; i < vertices.length; i++){
            System.out.print(al.get(vertices[i]).shortestDist);
            if(i!=vertices.length-1 )System.out.print(",");
        }
    }

    private void read() {
        try {

            try (BufferedReader br = new BufferedReader(new FileReader("/Users/vs/Documents/code/courses/Algorithms Coursera -2 Graphs-DataStruct/DijkstraShortest/DijkstraData.txt"))) {
                String line;
                int u=1;
                while ((line = br.readLine()) != null) {
                    // process the line.
                    String[] strs = line.trim().split("\\s+");
                      u = Integer.parseInt(strs[0]);
                      //System.out.println("Reading:" + u);
                    for(int i=1; i < strs.length-1; i++){
                        String [] edgeWeight = strs[i].split(",");
                        Edge ed = new Edge(Integer.parseInt(edgeWeight[0]), Integer.parseInt(edgeWeight[1]));
                        adj[u].add(ed);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void printGraph() {
        try {

         for(int i=1; i <=maxVertices; i++){
             //go through adjacenty list and print
             Iterator itr = adj[i].listIterator();
             System.out.println("Vertex:" + i);
             while(itr.hasNext()){
                 System.out.println("--" + itr.next());
             }
         }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private class Edge{
        int vertex;
        int weight;
        public Edge(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        public String toString(){
            return "Vertex:" + String.valueOf(vertex) + " Weight:" + String.valueOf(weight);
        }
    }

    private class Vertex{
        int vertex;
        int visited;
        int shortestDist;
        int previousVertex;

        public Vertex(int vertex, int visited, int shortestDist, int previousVertex){
            this.vertex = vertex;
            this.visited = visited;
            this.shortestDist = shortestDist;
            this.previousVertex = previousVertex;
        }

        public String toString(){
            return "Vertex:" + String.valueOf(vertex) + " visited:" + String.valueOf(visited) +  " shortestDist:" + String.valueOf(shortestDist) + " previousVertex:" + String.valueOf(previousVertex);
        }
    }


}
