package com.iotimc.mynettyserver.nettyutil;

//相应类型body对像
public class ReplyClientBody extends ReplyBody {
    private String clientInfo;
 
    public ReplyClientBody(String clientInfo) {
        this.clientInfo = clientInfo;
    }
 
    public String getClientInfo() {
        return clientInfo;
    }
 
    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }
}
