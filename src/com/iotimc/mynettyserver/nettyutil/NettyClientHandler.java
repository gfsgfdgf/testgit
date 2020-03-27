package com.iotimc.mynettyserver.nettyutil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

import com.iotimc.mynettyserver.nettyutil.BaseMsg.MsgType;

public class NettyClientHandler extends SimpleChannelInboundHandler<BaseMsg> {

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
		 MsgType msgType=baseMsg.getType();
	        switch (msgType){
	            case LOGIN:{
	                //向服务器发起登录
	                LoginMsg loginMsg=new LoginMsg();
	                loginMsg.setPassword("yao");
	                loginMsg.setUserName("robin");
	                channelHandlerContext.writeAndFlush(loginMsg);
	            }break;
	            case PING:{
	                System.out.println("receive ping from server-");
	            }break;
	            case ASK:{
	                ReplyClientBody replyClientBody=new ReplyClientBody("客户端收到服务端的连接请求(保持心跳) client info **** !!!");
	                ReplyMsg replyMsg=new ReplyMsg();
	                replyMsg.setBody(replyClientBody);
	                channelHandlerContext.writeAndFlush(replyMsg);
	            }break;
	            case REPLY:{
	                ReplyMsg replyMsg=(ReplyMsg)baseMsg;
	                ReplyServerBody replyServerBody=(ReplyServerBody)replyMsg.getBody();
	                System.out.println("客户端收到服务端的回应  receive server msg: "+replyServerBody.getServerInfo());
	            }
	            default:break;
	        }
	        ReferenceCountUtil.release(msgType);
	}
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		// TODO Auto-generated method stub
		if(IdleStateEvent.class.isAssignableFrom(evt.getClass())){
			IdleStateEvent event = (IdleStateEvent)evt;
			if(event.state() == IdleState.READER_IDLE){
				System.out.println("read idle");
			}else if(event.state() == IdleState.WRITER_IDLE){
				System.out.println("write idle");
			}else if(event.state() == IdleState.ALL_IDLE){
				System.out.println("all idle");
			}
		}
	}
}
