package com.iotimc.mynettyserver.nettyutil;

import java.io.Serializable;

public abstract class BaseMsg  implements Serializable {
	
	public enum MsgType {
		
		PING, ASK, REPLY, LOGIN
	}
    private static final long serialVersionUID = 1L;
    private MsgType type;
    //必须唯一，否者会出现channel调用混乱
    private String clientId;
 
    //初始化客户端id
    public BaseMsg() {
        this.clientId = Constants.getClientId();
    }
 
    public String getClientId() {
        return clientId;
    }
 
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
 
    public MsgType getType() {
        return type;
    }
 
    public void setType(MsgType type) {
        this.type = type;
    }
}
