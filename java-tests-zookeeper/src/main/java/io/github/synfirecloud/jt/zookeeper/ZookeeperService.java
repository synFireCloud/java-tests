package io.github.synfirecloud.jt.zookeeper;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by fc on 7/26/16.
 */
public class ZookeeperService{
    private static ZooKeeper zooKeeper;
    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public static synchronized ZooKeeper getInstance(Watcher watcher) throws IOException {
        if (zooKeeper == null) {
            zooKeeper = new ZooKeeper("localhost:2181", 2000,watcher);
        }
        return zooKeeper;
    }
}
