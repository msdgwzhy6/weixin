package com.xlwhzhb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xlwhzhb.mail.Info;
import com.xlwhzhb.mail.QueryMailImp;
import com.xlwhzhb.mail.Type;
import com.xlwhzhb.message.resp.TextMessage;
import com.xlwhzhb.util.MessageUtil;
import com.xlwhzhb.util.SignUtil;

/**
 * 核心请求处理类 
 * @author 张洪斌
 * @Email zyw205@gmail.com
 * 
 */
public class Server extends HttpServlet {

    private static final long serialVersionUID = -5021188348833856475L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	
    	// 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
        PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();
        out = null;
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        // 调用核心业务类接收消息、处理消息  
       //   String respMessage = MessagePro.processRequest(request); 
        
        
        
        String respContent =null;                     // 默认返回的文本消息内容

        // xml请求解析
        Map<String, String> requestMap = null;
		try {
			requestMap = MessageUtil.parseXml(request);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

        
        String fromUserName = requestMap.get("FromUserName");   	// 发送方帐号（open_id）
        String toUserName = requestMap.get("ToUserName");		    // 公众帐号
        String msgType = requestMap.get("MsgType"); 				// 消息类型
        String msg = requestMap.get("Content"); 				//消息内容
        String time = requestMap.get("CreateTime");  				//消息创建时间
        
     // 回复文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);
        StringBuffer res = null;
        
       if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
        	//韵达快递
    	   
    	 	char tp[] = new char[2];
    	    for(int i=0;i<2;i++)
    	    {
    	    	tp[i] = msg.charAt(i);
    	    }
        	
    	    String type  = new String(tp);
    	    
    	    char nb[] = new char[30]; 
    	    for(int i=3;i<msg.length();i++)
    	    {
    	    	nb[i-3] = msg.charAt(i) ;
    	    }
              
    	    
    	    String number = new String(nb); 
    	    
    	    int t = Integer.parseInt(type);
    	    
    	    switch(t)
    	    {
    	    case 1:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_YUNDA);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 2:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_HT);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 3:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_YUANTONG);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 4:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_SHUNFENG);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 5:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_TIANTIAN);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 6:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_DEBANG);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 7:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_QUANFENG);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 8:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_JD);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 9:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_RUFENGDA);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 10:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_ZT);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 11:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_ZJS);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    case 12:{
    	    	List<Info> lst = new QueryMailImp().query(number.trim(), Type.TYPE_EMS);
    	    	if(lst.size()>0)
    	    	{
    	    	for(int i=0;i<lst.size();i++) 
    	    	{
    	    		Info inf = lst.get(i);
    	    		res = new StringBuffer().append(inf.getFtime()+":"+inf.getContext()+"\n");
    	    	   
    	    	}
    	    	
    	    	}
    	    	else
    	    	{
    	    		res = new StringBuffer().append("对不起，您的快递数据好像还没有录入数据库哦！");
    	    	}
    	    	textMessage.setContent(res.toString());
    			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    }break;
    	    default:{
    	    	String s = "谢谢关注微邮！请输入正确格式，查询快递\n"
						 + "01.韵达快递\n"
						 + "02.百世汇通"
						 + "03.圆通快递\n"
						 + "04.顺丰快递 "
						 + "05.天天快递"
						 + "06.德邦物流\n"
						 + "07.全峰快递"
						 + "08.京东物流"
						 + "09.如风达快递\n"
						 + "10.中铁快运"
						 + "11.宅急送\n"
						 + "12.EMS速递\n"
						 + "请回复序号+单号查询，例：\n"
						 + "01,10116495647103";
			textMessage.setContent(s);
			out.print(MessageUtil.textMessageToXml(textMessage));
    	    	
    	    };
    	    }
    	    
    	    
    	   
    	   
    	   
        	
    	   String str = "谢谢关注微邮!\n"
					 + "01.韵达快递\n"
					 + "02.百世汇通\n"
					 + "03.圆通快递\n"
					 + "04.顺丰快递 \n"
					 + "05.天天快递\n"
					 + "06.德邦物流\n"
					 + "07.全峰快递\n"
					 + "08.京东物流\n"
					 + "09.如风达快递\n"
					 + "10.中铁快运\n"
					 + "11.宅急送\n"
					 + "12.EMS速递\n"
					 + "请回复序号+单号查询，例：\n"
					 + "01,10116495647103";
		textMessage.setContent(str);
		out.print(MessageUtil.textMessageToXml(textMessage));
		
       
		
    	   
           }
        
        
        
        
        
        
        else
        {
        	textMessage.setContent("请发送文本消息！");
        	out.print(MessageUtil.textMessageToXml(textMessage));
        }
        
        
          
        // 响应消息  
          
        //out.print(respMessage);
        out.close();  
    }
}