package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import model.Message;
import model.RsMessage;
import utils.MessageUtils;

public class TestMessageUtils {

	public static void main(String[] args) {
		try {
			FileInputStream in = new FileInputStream("D:\\msg.xml");
			Message msg = MessageUtils.pase(in);
			System.out.println("消息内容："+msg.getContent());
			System.out.println("消息创建时间："+msg.getCreateTime());
			System.out.println("消息来自："+msg.getFromUserName());
			System.out.println("消息id:"+msg.getMsgId());
			System.out.println("消息类型："+msg.getMsgType());
			System.out.println("发送给："+msg.getToUserName());
			FileOutputStream out = new FileOutputStream("D:\\temp.xml");
			RsMessage ms = new RsMessage();
			ms.setContent("你好");
			ms.setCreateTime("20034243254");
			ms.setFromUserName("njupt");
			ms.setMsgType("text");
			ms.setToUserName("18951898");
		    MessageUtils.sendMsg(ms, out);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
