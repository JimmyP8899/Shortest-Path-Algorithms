import java.lang.*;
import java.util.*;
import java.io.*;

public class ShortestPath {
    public static int inf=99999;
    int length;
    // public int size = 4;
    public static void main(String args[]){

        ShortestPath sp = new ShortestPath();
        ShortestPath fw = new ShortestPath();
        for(int n = 100; n < 3001; n += 100){
            System.out.println(n);
            int matrix[][] = {
                {0,6,inf,1,inf,inf,5},
                {inf,0,inf,inf,1,inf,inf},
                {2,inf,0,3,inf,inf,inf},
                {inf,inf,inf,0,4,inf,inf},
                {inf,inf,inf,inf,0,inf,inf},
                {inf,inf,inf,inf,2,0,inf},
                {3,inf,2,inf,inf,6,0}



            };
            sp.dijkstra(matrix, 6);
          
            
        }


   
    }
    public void dijkstra(int graph[][], int sourceNode){
        length = graph.length;
        int distance[] = new int[length];
        Boolean previous[] = new Boolean[length];
        for(int i = 0; i < length; i ++){
            distance[i] = inf;
            previous[i] = false;
        }
        distance[sourceNode] = 0;
        for (int i = 0; i < length - 1; i++){
            int k = minimumDistance(distance, previous);
            previous[k] = true;
            for (int j = 0; j < length - 1; j++)
                if(!previous[j] && graph[k][j] != 0 && distance[k] + graph[k][j] < distance[j] && distance[k] != inf ){
                    distance[j] = distance[k] + graph[k][j];
                }
        }
        printArray(distance);
    }
    public int minimumDistance(int distance[], Boolean previous[]){
        int minimum = inf;
        int minimum_index = -1;
        for(int i = 0; i < length; i++){
            if(previous[i] == false && distance[i] <= minimum){
                minimum = distance[i];
                minimum_index = i;
            }
        }
        return minimum_index;
    }
    void printArray(int distance[])
    {
        System.out.print("Vertex:   ");
        for (int i = 0; i < length; i++){
            System.out.print(((char)(i+65)) + " ");
          
        }
        System.out.println();
        System.out.print("Distance: ");
        for (int i = 0; i < length; i++){
            System.out.print(distance[i] + " ");
        }
        System.out.println();

    }
  
    public static void printGraph(int graph[][])
    {
        int n = graph.length;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (graph[i][j]== inf)
                    System.out.print("Inf");
                else 
                    System.out.print(graph[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public void floydWarshall(int graph[][])
    {
        int n = graph.length;
        int[][] distance = new int[n][n];
        int[][] pred = new int[n][n];
        /*        for  𝑢 ← 1 to 𝑛 do
                    for  𝑣 ← 1 to 𝑛 do
                        𝐷0[u,v] ← 𝑤(𝑢,𝑣) 
        */
        for (int u=0; u<n; u++)
        {
            for (int v=0; v<n; v++)
            {
                distance[u][v]= graph[u][v];
                pred[u][v]= u+1;
                
               
            }
        }

        /*
            for  𝑘 ← 1 to 𝑛 do
                for  𝑢 ← 1 to 𝑛 do
                    for  𝑣 ← 1 to 𝑛 do
                        𝐷k[u,v] ← min(𝐷k-1[u,v],𝐷k-1[u,k]+𝐷k-1[k,v])
         */ 
        for (int k=0; k<n; k++)
        {
            for (int u=0; u<n; u++)
            {
                for (int v=0; v<n; v++)
                {
                    
                    if (distance[u][k]+distance[k][v]< distance[u][v])
                    {
                        distance[u][v]= distance[u][k]+distance[k][v];
                        pred[u][v]= pred[k][v];
                    }
                }

            }
        }
        //return 𝐷k
     //   System.out.println("Distance Matrix");
       //printGraph(distance);
        //System.out.println("Predecessor Matrix");
       //printGraph(pred);
       


    }

    public static int[][] generateRandomMatrix(int n, int percentInfinity) {
        percentInfinity = percentInfinity / 10; 
        int[][] adjacencyMatrix = new int[n][n];
        int infinityRandom = (int)((Math.random() * 10) + 1);
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                infinityRandom = (int)((Math.random() * 10) + 1);
                if(infinityRandom <= percentInfinity){
                    adjacencyMatrix[i][j] = (inf);
                }else{
                adjacencyMatrix[i][j] = (int)((Math.random() * 10) + 1);
                }
            }
        }
        return adjacencyMatrix;
    }


}
 
