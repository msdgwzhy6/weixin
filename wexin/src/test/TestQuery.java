package test;

import java.util.List;

import com.xlwhzhb.mail.Info;
import com.xlwhzhb.mail.QueryMailImp;
import com.xlwhzhb.mail.Type;

public class TestQuery {

	public static void main(String[] args) {
	List<Info> li=	new QueryMailImp().query("1016495647103", Type.TYPE_EMS);
	for(int i=0;i<li.size();i++)
	{
		Info in = li.get(i);
		System.out.println("时间："+in.getFtime()+"   内容："+in.getContext()+"");
	}
	

	}

}
