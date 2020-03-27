package com.iotimc.mynettyserver.nettyutil;

/**
 * 心跳检测ping类型
 * @author lt
 *
 */
public class PingMsg extends BaseMsg {
    public PingMsg() {
        super();
        setType(MsgType.PING);
    }
}
