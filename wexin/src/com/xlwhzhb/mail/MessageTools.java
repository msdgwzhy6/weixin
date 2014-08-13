package com.xlwhzhb.mail;

public class MessageTools {
	public static int getNb(String str)
	{
		char ch[] = new char[4];
	    int i=0;
	    do{
	    	
	    	ch[i] = str.charAt(i);
	    	
	    	System.out.println(ch[i]);
	      //	System.out.println(i);
	    	
	    	i++;
	    }while(str.charAt(i)=='/');
	    
		return 0;
	}
	
	public static String getId(String str)
	{
		char ch[] = new char[4];
	    int i=0;
	    do{
	    	
	    	
	    	
	    	
	      //	System.out.println(i);
	    	
	    	i++;
	    }while(str.charAt(i)=='/');
	    
	    for(int j=i;j<5;j++)
	    {
	    	ch[j] = str.charAt(j);
	    	
	    }
	    
	    for(int k=0;k<10;k++)
	    {
	    	System.out.println(ch[k]);
	    }
	    
		return null;
	}
	
	public static void main(String[]args)
	{
		MessageTools.getNb("1/10116495647103");
		MessageTools.getId("1/10116495647103");
	}
}
