package io.github.synfirecloud.jt.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fc on 7/26/16.
 */
public class Main implements Watcher{
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    ZooKeeper zooKeeper;

    final static String ZOOKEEPER_ROOT_NODE="/Main";

    public Main() throws IOException, KeeperException, InterruptedException {
        zooKeeper = ZookeeperService.getInstance(null);
        if(zooKeeper.exists(ZOOKEEPER_ROOT_NODE,false)==null){
            zooKeeper.create(ZOOKEEPER_ROOT_NODE,ZOOKEEPER_ROOT_NODE.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        //产生临时节点，心跳包超时将删除
        zooKeeper.create(ZOOKEEPER_ROOT_NODE+"/"+"FC","FC".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zooKeeper.getChildren(ZOOKEEPER_ROOT_NODE,this);
    }

    public void start() throws KeeperException, InterruptedException, IOException {
        System.in.read();
        zooKeeper.setData(ZOOKEEPER_ROOT_NODE+"/"+"FC","SYN".getBytes(),-1);
        System.in.read();
        zooKeeper.delete(ZOOKEEPER_ROOT_NODE+"/"+"FC",-1);
        System.in.read();
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        Main main = new Main();
        main.start();
    }

    public void process(WatchedEvent event) {
        logger.log(Level.INFO,"process:"+event.getType());
        if(event.getType().equals(Event.EventType.NodeChildrenChanged)){
            try {
                logger.log(Level.INFO,"process:"+zooKeeper.getChildren(event.getPath(),this));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
