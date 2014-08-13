/* 
 *
 * @author  张洪斌
 * @email   1079039435@qq.com
 * @date    2014年7月15日下午8:37:46
 *
 */

package test;

public class Msg {
	
	public static void main(String[] args)
	{
		String str = "11,3333333333";
		char type[] = new char[2];
	    for(int i=0;i<2;i++)
	    {
	    	type[i] = str.charAt(i);
	    }
	    
	    System.out.println(new String(type));
	    System.out.println(Integer.parseInt(new String(type)));
	    System.out.println("============");
	    
	    char nb[] = new char[30]; 
	    for(int i=3;i<str.length();i++)
	    {
	    	nb[i-3] = str.charAt(i) ;
	    }
	    
		System.out.println(new String(nb).trim());
		
	}

}
