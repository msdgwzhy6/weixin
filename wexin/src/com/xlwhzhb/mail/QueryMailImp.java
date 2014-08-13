package com.xlwhzhb.mail;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class QueryMailImp implements QueryMail{

	private String u ="http://www.kuaidi100.com";
	private String action ="query";
	private String type;
	private String postid;
	private int id = 1;
	private String valicode="";
	private String temp= "0.7686049821303382";
	private String furl;
	@Override
	public List<Info> query(String postcode, String tp) {
		//查询百世汇通快递
		
			furl =""+u+"/"+action+"?type="+tp+"&postid="+postcode+"&id="+id+"&valicode="+valicode+"&temp="+temp+"";
			System.out.println(furl);
			try {
				URL url = new URL(furl);
				try {
					URLConnection conn = url.openConnection();
					InputStream in = conn.getInputStream();
					System.out.println(furl);
					BufferedInputStream bin = new BufferedInputStream(in);
					byte b[] = new byte[bin.available()];
					bin.read(b);
					String str = new String(b);
					System.out.println(str);
					return Pase.pase(str);
					
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
			
			return null;
	}
	

}
