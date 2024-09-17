package com.zach.geekbang.datastructure.lru;

/**
 * 基于单节点实现LRU算法，最近最少使用原则
 */
public class LRUBaseLinkedList<T> {
    private final static Integer DEFAULT_CAPACITY = 10;
    /**
     * 链表容量
     */
    private Integer capacity;
    /**
     * 链表长度
     */
    private Integer length;
    /**
     * 头节点(默认空节点，不存数据）
     */
    private Node<T> head;

    public LRUBaseLinkedList(){
        this.head = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity){
        this.head = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * 新增元素
     * @param data
     */
    public void add(T data){
        //根据元素值查找是否存在原节点中
        Node<T> preNode = getPreNodeByData(data);
        if(preNode==null){
            //元素超出限制
            if(length>=this.capacity){
                //删除尾结点
                deleteEndNode();
            }
            //插入头结点
            insertFromHead(data);
        }else {
            //数据已经在，删除原有节点，数据插入到头节点中
            deleteExistNode(preNode);
            insertFromHead(data);
        }
    }

    private void deleteExistNode(Node<T> preNode) {
        if(preNode!=null){
            Node<T> node = preNode.getNext();
            node.setData(null);
            preNode.setNext(null);
            node = null;
            length++;
        }
    }

    /**
     * 从头节点插入元素
     * @param data
     */
    private void insertFromHead(T data) {
        Node<T> node = head;
        head.setNext(new Node<>(node,data));
        length++;
    }

    /**
     * 删除尾结点
     */
    private void deleteEndNode() {
        Node<T> node = this.head;
        if(node.getNext()==null){
            return;
        }
        //找到尾结点的上个节点
        while (node.getNext().getNext()!=null){
            node = node.getNext();
        }
        Node<T> tailNode = node.getNext();
        node.setNext(null);
        tailNode.setData(null);
        tailNode=null;
        length--;
    }

    /**
     * 查找元素所在的节点的前一个节点
     * @param data
     * @return
     */
    public Node<T> getPreNodeByData(T data){
        Node<T> node = this.head;
        //从头开始查找最末尾的节点
        while (node.getNext()!=null){
            if(data.equals(node.getNext().getData())){
                return node;
            }else {
                node = node.getNext();
            }
        }
        return null;
    }
    /**
     * 链表节点
     * @param <T>
     */
    public class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }

        public Node(){
            this.next=null;
        }
        public void setData(T data){
            this.data = data;
        }

        public T getData(){
            return this.data;
        }
        public Node(Node<T> next,T data){
            this.next=next;
            this.data = data;
        }
       public void setNext(Node<T> next){
            this.next = next;
       }

       public Node<T> getNext(){
            return this.next;
       }
    }
}
