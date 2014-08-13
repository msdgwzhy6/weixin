/* 
 *
 * @author  张洪斌
 * @email   1079039435@qq.com
 * @date    2014年7月15日下午10:33:16
 *
 */

package test;

import java.util.Date;
import java.util.List;

import com.xlwhzhb.mail.Info;
import com.xlwhzhb.mail.QueryMailImp;
import com.xlwhzhb.mail.Type;
import com.xlwhzhb.message.resp.TextMessage;
import com.xlwhzhb.util.MessageUtil;

public class Test {
	
	public void tst(String msg)
	{
		TextMessage textMessage = new TextMessage();
        textMessage.setToUserName("100000000");
        textMessage.setFromUserName("33333333");
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);
		StringBuffer res = null;
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
	    number.trim();
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
			System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
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
			System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
	    }break;
	    case 6:{
	    	List<Info> lst = new QueryMailImp().query(number, Type.TYPE_DEBANG);
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
	    }break;
	    case 7:{
	    	List<Info> lst = new QueryMailImp().query(number, Type.TYPE_QUANFENG);
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
	    }break;
	    case 8:{
	    	List<Info> lst = new QueryMailImp().query(number, Type.TYPE_JD);
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
	    }break;
	    case 9:{
	    	List<Info> lst = new QueryMailImp().query(number, Type.TYPE_RUFENGDA);
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
	    }break;
	    case 10:{
	    	List<Info> lst = new QueryMailImp().query(number, Type.TYPE_ZT);
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
	    }break;
	    case 11:{
	    	List<Info> lst = new QueryMailImp().query(number, Type.TYPE_ZJS);
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
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
	    	System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
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
		System.out.print(MessageUtil.textMessageToXml(textMessage));
	    	
	    };
	    }
	    
	    
	}

	
	public static void main(String[]args)
	{
		String str = "12,1016495647103";
		new Test().tst(str);
	}
	
}
