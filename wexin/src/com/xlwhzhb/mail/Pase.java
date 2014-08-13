package com.xlwhzhb.mail;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Pase {
	private String status;    //数据返回状态
	private String message;   //返回信息
	private String nu;         //快递单号
	private String com;        //快递公司
	private String updatetime;  //更新日期
	
	public static List<Info> pase(String str)
	{
		List<Info> li = new ArrayList<Info>();
		JSONObject obj = JSONObject.fromObject(str);
		Object statu = obj.get("status");
		if(statu.equals("201"))
		{
			System.out.println("查询错误,快递单号不存在");
		}
		else
		{
			System.out.println(statu);
			JSONArray data = obj.getJSONArray("data");
			JSONObject rows=null;
			for(int i=0;i<data.size();i++)
			{
				Info in = new Info();
				rows = (JSONObject) data.get(i);
				String time = rows.getString("time");        //时间
				//String location = rows.getString("location");    //地点
			    String context = rows.getString("context");     //内容
			    String ftime = rows.getString("ftime");
			    in.setContext(context);
			    in.setFtime(ftime);
			//    in.setLocation(location);
			    in.setTime(time);
			    li.add(in);
			}
			 
		}
		return li;
	}
	
}
