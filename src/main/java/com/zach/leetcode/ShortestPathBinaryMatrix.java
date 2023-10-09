package com.zach.leetcode;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 *计算在网格中从原点到特定点的最短路径长度
 * [[1,1,0,1],
 * [1,0,1,0],
 * [1,1,1,1],
 * [1,0,1,1]]
 *
 * 题目描述：1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 */
public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {

    }

    /**
     * BFS 广度优先搜索，每层遍历都以上一层遍历的结果作为起点，遍历一个距离能访问到的所有节点。
     * 需要注意的是，遍历过的节点不能再次被遍历。
     * @param grid
     * @param tr
     * @param tc
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid,int tr,int tc){
        //表示前进后退，上下步进
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new MutablePair<>(0,0));
        int pathLength = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            while (size-->0){
                Pair<Integer,Integer> cur = queue.poll();
                Integer cr = cur.getKey();
                Integer cc = cur.getValue();
                //标记已经遍历过
                grid[cr][cc] = 0;
                for (int[] d : direction) {
                    //计算当前位置，每次遍历都以上一次遍历的结果为起点
                    int nr = cr+d[0],nc = cc+d[1];
                    if(nr<0||nr>=m||nc<0||nc>=n||grid[nr][nc]==0){
                        continue;
                    }
                    if(nr==tr&&nc==tc){
                        return pathLength;
                    }
                    queue.add(new MutablePair<>(nr,nc));
                }
            }
        }
        return -1;
    }

}
