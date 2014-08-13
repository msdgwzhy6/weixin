package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.Message;
import model.RsMessage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MessageUtils {
	
	
	public static Message pase(InputStream stream){
		Message msg = new Message();
		 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
         Document document = null;
		try {
			document = builder.parse(stream);
		} catch (SAXException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}		  
		/* 
		 <ToUserName><![CDATA[toUser]]></ToUserName>
		 <FromUserName><![CDATA[fromUser]]></FromUserName> 
		 <CreateTime>1348831860</CreateTime>
		 <MsgType><![CDATA[text]]></MsgType>
		 <Content><![CDATA[this is a test]]></Content>
		 <MsgId>1234567890123456</MsgId>*/
		
		 Element root=document.getDocumentElement();   			//根节点           
		 NodeList items1=root.getElementsByTagName("ToUserName");
		 NodeList items2=root.getElementsByTagName("FromUserName");
		 NodeList items3=root.getElementsByTagName("CreateTime");
		 NodeList items4=root.getElementsByTagName("MsgType");
		 NodeList items5=root.getElementsByTagName("Content");
		 NodeList items6=root.getElementsByTagName("MsgId");
		 Element item1=(Element)items1.item(0);
		 Element item2=(Element)items2.item(0);
		 Element item3=(Element)items3.item(0);
		 Element item4=(Element)items4.item(0);
		 Element item5=(Element)items5.item(0);
		 Element item6=(Element)items6.item(0);
		 msg.setToUserName(item1.getTextContent());
		 msg.setFromUserName(item2.getTextContent());	
		 msg.setCreateTime(item3.getTextContent());
		 msg.setMsgType(item4.getTextContent());
		 msg.setContent(item5.getTextContent());
		// msg.setMsgId(item6.getTextContent());
		 return msg;
		
	}
	
	
	public static void sendMsg(RsMessage msg,OutputStream out){
		/*<xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[fromUser]]></FromUserName>
		<CreateTime>12345678</CreateTime>
		<MsgType><![CDATA[text]]></MsgType>
		<Content><![CDATA[你好]]></Content>
		</xml>*/
		String str = "<xml>"
				+ "<ToUserName><![CDATA["+msg.getToUserName()+"]]></ToUserName>"
				+ "<FromUserName><![CDATA["+msg.getFromUserName()+"]]</FromUserName>"
				+ "<CreateTime>"+msg.getCreateTime()+"</CreateTime>"
				+ "<MsgType><![CDATA["+msg.getMsgType()+"]]</MsgType>"
				+ "<Content><![CDATA["+msg.getContent()+"]]</Content>"
				+ "</xml>";
	    try {
			out.write(str.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	
	
}
