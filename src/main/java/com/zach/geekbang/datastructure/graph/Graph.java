package com.zach.geekbang.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 功能描述: 
 *
 * @param: 
 * @return: 
 * @auther: Zach
 * @date: 2019/3/29 20:57
 */
public class Graph {
    private int v; //顶点个数
    private LinkedList<Integer> adj[]; //邻接表
    private boolean found = false;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0;i<v;++i) {
            adj[i] = new LinkedList<>();
        }
    }
    //无向图一条边存两次
    public void addEdge(int s,int t) {
        adj[s].add(t);
        adj[t].add(s);
    }
    //广度优先搜索
    public void bfs(int s,int t) {
        if(s == t)
            return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for(int i=0;i<v;++i) {
            prev[i] = -1;
        }

        while (queue.size() !=0) {
            int w = queue.poll();
            for(int i=0;i<adj[w].size();++i) {
                int q = adj[w].get(i);
                if(!visited[q]){
                    prev[q] = w;
                    if(q == t) {
                        print(prev,s,t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     *
     * 功能描述:
     *  深度优先搜索
     * @param:
     * @return:
     * @auther: Zach
     * @date: 2019/4/2 21:01
     */
    public void dfs(int s,int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if(found == true)
            return;
        visited[w] = true;
        if(w == t){
            found = true;
            return;
        }
        for (int i = 0;i<adj[w].size();++i) {
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q] = w;
                recurDfs(q,t,visited,prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if(prev[t] !=-1 && t != s) {
            print(prev,s,prev[t]);
        }
        System.out.println(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(3,7);
        System.out.println(Arrays.asList(graph.adj));
        graph.bfs(3,7);
    }
}
