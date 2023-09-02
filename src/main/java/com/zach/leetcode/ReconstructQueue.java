package com.zach.leetcode;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * 根据身高和序号重组队列
 *假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 * @Author Zach
 * @Date 2023-09-02 10:59
 * Version :1.0
 */
public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,4}, {7,1},{5,0},{6,1},{5,2}};
        int[][] sortQueue = reconstructQueue(people);
        List<int[]> sortQueue2 = reconstructQueue2(people);
        System.out.println(JSON.toJSONString(sortQueue));
        System.out.println(JSON.toJSONString(sortQueue2));
    }

    /**
     * 从小到大排序，逆向思维，当前人的位置，先计算空位置，前面k个位置，放比当前人高的位置
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people){
        //先按身高正序排序，再按个数逆向排序
        Arrays.sort(people, (p1, p2) -> {
            if(p1[0]!=p2[0]){
               return p1[0]-p2[0];
            }else {
                return p2[1]-p1[1];
            }
        });
        int n = people.length;
        int[][] res = new int[n][];
        for (int[] person : people) {
            //person的位置，前面有space-1个比person高的人
            int space = person[1]+1;
            for (int i = 0; i < n; i++) {
                if(res[i]==null){
                    --space;
                    //找到第person的位置，放入队列
                    if(space==0){
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }

    /**
     *从高到低考虑
     * @param people
     * @return
     */
    public static List<int[]> reconstructQueue2(int[][] people){
        //先按身高从大到小排序，身高一样时，按照位置升序排序
        Arrays.sort(people,(p1,p2)->{
            if(p1[0]!=p2[0]){
                return p2[0]-p1[0];
            }else {
                return p1[1]-p2[1];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            //身高较高的先做插入操作
           res.add(person[1],person);

        }
        return res;
    }
}
