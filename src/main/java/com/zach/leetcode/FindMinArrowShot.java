package com.zach.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 *
 * @Author Zach
 * @Date 2023-08-16 14:47
 * Version :1.0
 */
public class FindMinArrowShot {
    public static void main(String[] args) {
        int[][] points =  {{10,16},{2,8},{1,5},{6,7}};
        int minArrowShot = findMinArrowShot(points);
        System.out.println(minArrowShot);
    }

    /**
     * 贪心思想:
     * 有重叠的区间，只需要一只箭就可以都射破，无重叠的区间需要两支箭，重叠区域越多，射爆气球需要的弓箭越少
     * 一定存在一种最优（射出的箭数最小）的方法，使得每一支箭的射出位置都恰好对应着某一个气球的右边界
     * 考虑所有气球中右边界位置最靠左的那一个，那么一定有一支箭的射出位置就是它的右边界（否则就没有箭可以将其引爆了）。
     * 当我们确定了一支箭之后，我们就可以将这支箭引爆的所有气球移除，并从剩下未被引爆的气球中，
     * 再选择右边界位置最靠左的那一个，确定下一支箭，直到所有的气球都被引爆
     *
     * @param points
     * @return
     */
    public static int findMinArrowShot(int[][] points){
        //按照右区间升序排序
        Arrays.sort(points, Comparator.comparing(n->n[1]));
        //重叠区间，只需要一支弓箭射爆
        int arrowNum = 1;
        //假设第一个元素的右边界为所有右边界最靠左的元素
        int rightPos = points[0][1];
        for (int i = 0; i < points.length; i++) {
            //找出第一个不重叠区间，
            if(points[i][0]>rightPos){
                //不重叠区间需要增加弓箭数
                arrowNum++;
                //以不重叠区间的右边界作为所有右边界的最靠左的起点
                rightPos = points[i][1];
            }
        }
        return arrowNum;
    }
}
