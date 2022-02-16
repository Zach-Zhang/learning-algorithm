package com.zach;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author Zhangshengzhi
 * @version 1.0.0
 * @Description
 * @createTime 2022年02月15日 17:44:00
 */
public class Application {
    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                "192.168.31.184:2181,192.168.31.207:2181,192.168.31.192:2181",
                retryPolicy);
        client.start();

        client.create()
                .creatingParentsIfNeeded().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath("/user/dir", "hello world".getBytes());

        System.out.println(new String(client.getData().forPath("/my/path")));
    }
}
