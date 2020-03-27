package com.iotimc.mynettyserver.nettyutil;

import java.io.Serializable;

/**
 * 请求类型参数
 * @author lt
 *
 */
public class AskParams implements Serializable {
    private static final long serialVersionUID = 1L;
    private String auth;
 
    public String getAuth() {
        return auth;
    }
 
    public void setAuth(String auth) {
        this.auth = auth;
    }
}
