package io.github.synfirecloud.jt.zookeeper;

import org.apache.zookeeper.WatchedEvent;

/**
 * Created by fc on 7/26/16.
 */
public interface PathWatchedEvent {
    void process(WatchedEvent watchedEvent);
}
