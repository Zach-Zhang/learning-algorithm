package com.zach.datastructure.tree;

import java.util.Arrays;

/**
 * 二叉树的顺序存储实现
 * @param <T>
 */
public class ArrayBinTree<T> {

    //使用数组来记录该树的所有节点
    private Object[] datas;
    private int DEFAULT_DEEP = 8;

    //保存该树的深度
    private int deep;
    private int arraySize;

    //以默认的深度创建二叉树
    public ArrayBinTree() {
        this.deep = DEFAULT_DEEP;
        this.arraySize = (int)Math.pow(2,deep)-1;
        datas = new Object[arraySize];
    }

    //以指定深度创建二叉树
    public ArrayBinTree(int deep) {
        this.deep = deep;
        this.arraySize = (int)Math.pow(2,deep)-1;
        datas = new Object[arraySize];
    }

    //以指定深度,指定根节点创建二叉树
    public ArrayBinTree(int deep,T data) {
        this.deep = deep;
        this.arraySize = (int)Math.pow(2,deep)-1;
        datas = new Object[arraySize];
        datas[0] = data;
    }

    //为指定节点添加子节点
    public void add(int index,T data,boolean left) {
        if(datas[index] == null)
            throw new RuntimeException(index +"节点处为空,无法添加子节点");

        if(2*index +1>=arraySize)
            throw new RuntimeException(index +"树底层的数组已满,树越界异常");


        if(left)
            datas[2*index+1] = data;
        else
            datas[2*index+2] = data;

    }

    //判断二叉树是否为空
    public boolean empty() {
        //根据元素判断二叉树是否为空
        return datas[0] == null;
    }

    //返回根节点
    public T root() {
        return (T) datas[0];
    }

    //返回指定节点(非根节点)的父节点
    public T parent(int index){
        return (T) datas[(index - 1) /2];
    }

    //返回指定节点(非叶子)的左子节点,不存在返回null
    public T left(int index) {
        if(2*index+1>=arraySize)
            throw new RuntimeException(index +"该节点为叶子节点,无子节点");

        return (T)datas[index*2+1];
    }

    //返回指定节点(非叶子)的右节点,当右子节点不存在时返回null
    public T right(int index) {
        if(2*index+1>=arraySize)
            throw new RuntimeException(index +"该节点为叶子节点,无子节点");

        return (T)datas[index*2+2];
    }

    //返回二叉树的深度
    public int deep(int index) {
        return deep;
    }

    //返回指定节点的位置
    public int pos(T data){
        //该循环实际上就是按广度遍历来搜索每个节点
        for(int i=0;i<arraySize;i++){
            if(datas[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return Arrays.toString(datas);
    }

    public static void main(String[] args) {
        ArrayBinTree<String> binTree = new ArrayBinTree<>(4,"根");
        binTree.add(0,"第二层右子节点",false);
        binTree.add(2,"第三层右子节点",false);
        binTree.add(6,"第四层右子节点",false);
        System.out.println(binTree);

    }
}
