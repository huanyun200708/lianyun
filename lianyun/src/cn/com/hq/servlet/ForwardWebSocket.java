package cn.com.hq.servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/forwardWebSocket" ,configurator=GetHttpSessionConfigurator.class)
public class ForwardWebSocket {


    private static final String GUEST_PREFIX = "Guest";
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private static final Map<String,Object> connections = new HashMap<String,Object>();
    private static final Map<String,HttpSession> sessionMap = new HashMap<String,HttpSession>();
    
    private final String nickname;
    private Session session;
    public ForwardWebSocket() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
    }


    @OnOpen
    public void start(Session session,EndpointConfig config) {
        this.session = session;
        String message = String.format("* %s %s", nickname, "has joined.");
        
        HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        String userId = httpSession.getAttribute("userId").toString();
        connections.put(userId, this);
        sessionMap.put(session.getId(), httpSession);
    }


    @OnClose
    public void end() {
        connections.remove(this.nickname);
        String message = String.format("* %s %s",
                nickname, "has disconnected.");
        broadcast(message);
    }


    /**
     * 消息发送触发方法
     * @param message
     */
    @OnMessage
    public void incoming(String message) {
    	System.out.println(message.toString());
        broadcast(message.toString());
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        System.out.println("Chat Error: " + t.toString());
    }

    /**
     * 消息发送方法
     * @param msg
     */
    private static void broadcast(String msg) {
    	sendAll(msg);
    } 
    
    /**
     * 向所有用户发送
     * @param msg
     */
    public static void sendAll(String msg){
    	Iterator<String> iterator = connections.keySet().iterator();   
    	while (iterator.hasNext()) {  
    		    String key = (String) iterator.next();  
    		    ForwardWebSocket client = null ;
    	            try {
    	            	client = (ForwardWebSocket) connections.get(key);
    	                synchronized (client) {
    	                	if(client.session.isOpen()){
    	                		 client.session.getBasicRemote().sendText(msg);
    	                	}else{
    	                		iterator.remove();        
    	         		       connections.remove(key);  
    	                	}
    	                   
    	                }
    	            } catch (Exception e) { 
    	            		iterator.remove();        
	         		       connections.remove(key);  
    	                try {
    	                    client.session.close();
    	                } catch (IOException e1) {
    	                    // Ignore
    	                }
    	            }
    		 }  

    }
    
    /**
     * 向指定用户发送消息 
     * @param msg
     */
    public static void sendUser(String userId ,String msg){
    	System.out.println("-----------start send massage to "+userId+"------------");
    	ForwardWebSocket c = (ForwardWebSocket)connections.get(userId);
		try {
			if(c != null){
				c.session.getBasicRemote().sendText(msg);
				System.out.println("-----------end send massage to "+userId+"------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
            connections.remove(c);
            try {
                c.session.close();
            } catch (Exception e1) {
            	e1.printStackTrace();
                // Ignore
            }
		} 
    }
}