package com.iotimc.mynettyserver.nettyutil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;

import com.iotimc.mynettyserver.nettyutil.BaseMsg.MsgType;

public class NettyServerHandler extends SimpleChannelInboundHandler<BaseMsg> {

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg)
			throws Exception {
		 if(MsgType.LOGIN.equals(baseMsg.getType())){
	            LoginMsg loginMsg=(LoginMsg)baseMsg;
	            if("robin".equals(loginMsg.getUserName())&&"yao".equals(loginMsg.getPassword())){
	                //登录成功,把channel存到服务端的map中
	                NettyChannelMap.add(loginMsg.getClientId(),(SocketChannel)channelHandlerContext.channel());   //通过channelHandlerContext.channel()获取唯一标示的连接
	                System.out.println("client"+loginMsg.getClientId()+" 登录成功");
	            }
	        }else{
	            if(NettyChannelMap.get(baseMsg.getClientId())==null){
	                    //说明未登录，或者连接断了，服务器向客户端发起登录请求，让客户端重新登录
	                    LoginMsg loginMsg=new LoginMsg();
	                    channelHandlerContext.channel().writeAndFlush(loginMsg);
	            }
	        }
	        switch (baseMsg.getType()){
	            case PING:{
	                PingMsg pingMsg=(PingMsg)baseMsg;
	                PingMsg replyPing=new PingMsg();
	                NettyChannelMap.get(pingMsg.getClientId()).writeAndFlush(replyPing);
	            }break;
	            case ASK:{
	                //收到客户端的请求
	                AskMsg askMsg=(AskMsg)baseMsg;
	                if("authToken".equals(askMsg.getParams().getAuth())){
	                    ReplyServerBody replyBody=new ReplyServerBody("服务端收到客户端的请求 server info $$$$ !!!");
	                    ReplyMsg replyMsg=new ReplyMsg();
	                    replyMsg.setBody(replyBody);
	                    NettyChannelMap.get(askMsg.getClientId()).writeAndFlush(replyMsg);
	                }
	            }break;
	            case REPLY:{
	                //收到客户端
	                ReplyMsg replyMsg=(ReplyMsg)baseMsg;
	                ReplyClientBody clientBody=(ReplyClientBody)replyMsg.getBody();
	                System.out.println("服务端收到客户端的回应  receive client msg: "+clientBody.getClientInfo());
	            }break;
	            default:break;
	        }
	        //netty4开始，对象生命周期由引用计数管理，而不是由垃圾收集器管理。   引用计数的缺点容易发生泄漏，因为JVM并不知道netty实现的引用计数的存在；一旦对象被GC掉，引用数不为0，这些对象回不到对象池中或者产生内存泄漏
	        ReferenceCountUtil.release(baseMsg);    
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		//channel失效，从Map中移除
        NettyChannelMap.remove((SocketChannel)ctx.channel());
	}
}
