package com.iotimc.mynettyserver.nettyutil;

/**
 * 请求类型消息
 * @author lt
 *
 */
public class AskMsg extends BaseMsg {
    public AskMsg() {
        super();
        setType(MsgType.ASK);
    }
    private AskParams params;
 
    public AskParams getParams() {
        return params;
    }
 
    public void setParams(AskParams params) {
        this.params = params;
    }
}
