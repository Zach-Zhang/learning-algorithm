package com.zach.frequency;

/**
 * @author Zhangshengzhi
 * @version 1.0.0
 * @Description 描述一:
 * 让小朋友们围成一个大圈。然后，随机指定一个数 m，让编号为 0的小朋友开始报数。每次喊到 m-1的那个小朋友
 * 要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中，从他的下一个小朋友开始，继续 0...m-1
 * 报数 .... 这样下去 直到剩下最后一个小朋友，可以不用表演。
 * <p>
 * 描述二:
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出:3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出:2
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 解题思路:
 * f(n,m) = y
 * 这个y到底表示了啥呢？注意，y是下标，所以就意味着你从index=0开始数，数y+1个数，然后就停，停谁身上谁就是结果。
 * <p>
 * 行了，我们假设f(n-1,m)=x，然后来找一找f(n,m)和f(n-1,m)到底啥关系。
 * <p>
 * f(n-1,m)=x意味着啥呢？意味着有n-1个数的时候从index=0开始数，数x+1个数你就找到这结果了。那我不从index=0开始数呢？比如我从index=i开始数？那很简单，你把上面的答案也往后挪i下，就得到答案了。当然了，你要是挪到末尾了你就取个余，从头接着挪。
 * <p>
 * 于是我们来思考f(n,m)时考虑以下两件事：
 * <p>
 * 有n个数的时候，要划掉一个数，然后就剩n-1个数了呗，那划掉的这个数，**下标**是多少？
 * 划完了这个数，往后数，数x+1个数，停在谁身上谁就是我们的答案。当然了，数的过程中你得取余
 * **问题一**：有n个数的时候，划掉了谁？**下标**是多少？
 * <p>
 * 因为要从0数m个数，那最后肯定落到了下标为m-1的数身上了，但这个下标可能超过我们有的最大下标（n-1）了。所以攒满n个就归零接着数，逢n归零，所以要模n。
 * <p>
 * 所以有n个数的时候，我们划掉了下标为(m-1)%n的数字。
 * <p>
 * **问题二**：我们划完了这个数，往后数x+1下，能落到谁身上呢，它的下标是几？
 * <p>
 * 你往后数x+1，它下标肯定变成了(m-1)%n +x+1，和第一步的想法一样，你肯定还是得取模，所以答案为[(m-1)%n+x+1]%n，则
 * <p>
 * f(n,m)=[(m-1)%n+x+1]%n
 * 其中x=f(n-1,m)
 * <p>
 * 我们化简它！
 * <p>
 * 定理一：两个正整数a，b的和，模另外一个数c，就等于它俩分别模c，模完之后加起来再模。
 * <p>
 * (a+b)%c=((a%c)+(b%c))%c
 * 定理二：一个正整数a，模c，模一遍和模两遍是一样的。
 * <p>
 * a%c=(a%c)%c
 * 你稍微一琢磨就觉得，嗯，说得对。
 * <p>
 * 所以
 * <p>
 * f(n,m)=[(m-1)%n+x+1]%n
 * =[(m-1)%n%n+(x+1)%n]%n
 * =[(m-1)%n+(x+1)%n]%n
 * =(m-1+x+1)%n
 * =(m+x)%n
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2022年01月25日 20:06:00
 */
public class LastRemaining {
    public static void main(String[] args) {
        int count = lastRemaining(5, 3);
        int count1 = lastRemaining2(5, 3);
        System.out.println(count);
        System.out.println(count1);
    }

    /**
     * @param n 绳子的总长度
     * @param m 指定的数字m
     */
    public static int lastRemaining(int n, int m) {
        return f(n, m);
    }

    private static int f(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    /**
     * 使用迭代替换递归
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining2(int n, int m) {
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = (m + f) % i;
        }
        return f;
    }
}
