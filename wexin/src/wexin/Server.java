package wexin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import model.RsMessage;
import utils.MessageUtils;



@SuppressWarnings("serial")
public class Server extends HttpServlet {
	private String TOKEN = "xlwhzhb1898784";
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String signature = request.getParameter("signature");
		String echostr = request.getParameter("echostr");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
        String[] str = { TOKEN, timestamp, nonce };
		Arrays.sort(str); 
		String bigStr = str[0] + str[1] + str[2];
		String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
        if (digest.equals(signature)) {
			response.getWriter().print(echostr);
		}
	}
	
	
	
	//接受post请求
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  super.doPost(req, resp);
		  InputStream in = req.getInputStream();
		  OutputStream out = resp.getOutputStream();
		  Message msg = MessageUtils.pase(in);
		  if(msg.getMsgType().equals("text"))
		  {
			  RsMessage ms = new RsMessage();
			  ms.setContent("你好，欢迎关注我！您发送的事文本消息");
			  ms.setCreateTime("1348831860");
			  ms.setFromUserName("njupt_zhanghongbin");
			  ms.setMsgType("text");
			  ms.setToUserName(msg.getFromUserName());
			  MessageUtils.sendMsg(ms, out);
		  }
		  else
		  {
			  RsMessage ms = new RsMessage();
			  ms.setContent("你好，欢迎关注我！请发送合适消息");
			  ms.setCreateTime("1348831860");
			  ms.setFromUserName("njupt_zhanghongbin");
			  ms.setMsgType("text");
			  ms.setToUserName(msg.getFromUserName());
			  MessageUtils.sendMsg(ms, out);
		  }
	}
	   
	
	
}
