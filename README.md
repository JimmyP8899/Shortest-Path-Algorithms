# Dijkstra and Floyd-Warshall Algorithm for Shortest Path

This program implements both the Dijkstra's algorithm and the Floyd-Warshall algorithm to find the shortest path in a directed weighted graph of a specified size. The graph is generated randomly with the specified size.

## Input

The program takes the size of the graph as input and generates a random directed weighted graph. The user can then input the source vertex and the destination vertex, and the program will find the shortest path between them

## Algorithms

The program uses two algorithms to find the shortest path:

- Dijkstra's algorithm: A greedy algorithm that starts at the source vertex and visits the vertices in a specific order, updating the distance from the source vertex to each vertex as it is visited.
- Floyd-Warshall algorithm: A dynamic programming algorithm that maintains a matrix of the shortest distance between all pairs of vertices. The algorithm iteratively updates this matrix until it reaches the final solution, which is the shortest distance between all pairs of vertices.

## Data Structures Used

The program uses arrays to represent the graph and the distances.

## Features

- Generate a random directed weighted graph of a specified size.
- Find the shortest path between two vertices using either Dijkstra's algorithm or the Floyd-Warshall algorithm.
- Display the shortest path and the distance.

## Usage

To run the program, compile the code using a Java compiler and run the compiled code with the required inputs.
