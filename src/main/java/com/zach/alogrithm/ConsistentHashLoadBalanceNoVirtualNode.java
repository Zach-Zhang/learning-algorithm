package com.zach.alogrithm;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ConsistentHashLoadBalanceNoVirtualNode {
    private TreeMap<Long, String> realNodes = new TreeMap<>();
    private String[] nodes;

    public ConsistentHashLoadBalanceNoVirtualNode(String[] nodes) {
        this.nodes = Arrays.copyOf(nodes, nodes.length);
        //初始化哈希环
        initalization();
    }

    /**
     * 初始化哈希环,循环计算每个node的哈希值,放入TreeMap中
     */
    private void initalization() {
        for (String nodeName : nodes) {
            realNodes.put(calculateHash(nodeName, 0), nodeName);
        }

    }

    /**
     * 根据资源key选择返回相应的节点名称
     *
     * @param key
     * @return
     */
    public String selectNode(String key) {
        Long hashofKey = calculateHash(key, 0);
        if (!realNodes.containsKey(hashofKey)) {
            //获得比hashofKey大的第一个Entry
            Map.Entry<Long, String> entry = realNodes.ceilingEntry(hashofKey);
            if (entry != null) {
                return entry.getValue();
            } else {
                return nodes[0];
            }
        } else {
            return realNodes.get(hashofKey);
        }
    }

    /**
     * 使用KETAMA_HASH算法重新计算哈希值
     *
     * @param nodeName
     * @param number
     * @return
     */
    private Long calculateHash(String nodeName, int number) {

        byte[] digest = this.md5(nodeName);
        return ((long) (digest[3 + number * 4] & 0xFF) << 24
                | ((long) (digest[2 + number * 4] & 0xFF) << 16)
                | ((long) (digest[1 + number * 4] & 0xFF) << 8)
                | (digest[number * 4] & 0xFF))
                & 0xFFFFFFFFL;
    }

    private byte[] md5(String nodeName) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(nodeName.getBytes("UTF-8"));
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void printTreeNode() {
        if (realNodes != null && !realNodes.isEmpty()) {
            realNodes.forEach((hashKey, node) -> {
                System.out.println(new StringBuffer(node)
                        .append("==>")
                        .append(hashKey));
            });
        } else {
            System.out.println("Cycle is Empty");
        }
    }

    public static void main(String[] args) {
        String[] nodes = new String[]{"192.168.2.1:8080", "192.168.2.2:8080", "192.168.2.3:8080", "192.168.2.4:8080"};
        ConsistentHashLoadBalanceNoVirtualNode consistentHash = new ConsistentHashLoadBalanceNoVirtualNode(nodes);
        consistentHash.printTreeNode();
    }
}
