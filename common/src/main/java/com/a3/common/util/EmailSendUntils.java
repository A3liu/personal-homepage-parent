package com.a3.common.util;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 这是一个发送邮箱验证码的工具类
 * @author Donald 上午8:50:49
 */
public class EmailSendUntils {
	private static Properties properties;
	static{
		  properties = new Properties();
		  properties.put("mail.transport.protocol", "smtp");// 连接协议        
		  properties.put("mail.smtp.host", "smtp.qq.com");// 主机名        
		  properties.put("mail.smtp.port", 465);// 端口号        
		  properties.put("mail.smtp.auth", "true");        
		  properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用        
		  properties.put("mail.debug", "true");//设置是否显示debug信息  true 会在控制台显示相关信息        
	}
	/**
	 * 发送成功返回sendOK　失败sendfail
	 * @param emailAddress 收件人邮箱地址
	 * @return [0] OK/Fail 邮件是否发送成功 [1] 验证码
	 * @throws Exception 
	 * @throws AddressException 
	 */
	public static String[] sendEmail(String emailAddress) {
		String[] resulte ={"Fail",""};//邮件发送结果 SendOK 邮件发送成功
		//得到回话对象        
		Session session = Session.getInstance(properties);        
		// 获取邮件对象        
		Message message = new MimeMessage(session);        
	  
		try {
			//设置发件人邮箱地址       
			message.setFrom(new InternetAddress("942014375@qq.com"));       
			//设置收件人地址        
			message.setRecipients(RecipientType.TO,new InternetAddress[] { new InternetAddress(emailAddress) });       
			 //设置邮件标题        
			message.setSubject("这是第一封虾米音乐网站注册验证邮件"); 
			//获取随机验证码！！！！！
			String itemID = getItemID();
			//设置邮件内容        
			message.setText("你的虾米音乐网验证码是："+itemID+"\r\n"+"验证码将在10分钟后失效");  
			 //得到邮差对象        
			Transport transport = session.getTransport();        
			//连接自己的邮箱账户      
			transport.connect("942014375@qq.com", "omkgfxkfyzzpbcda");
			transport.sendMessage(message, message.getAllRecipients()); //发送邮件        
			resulte[0]="OK"; //邮件发送成功
			resulte[1]=itemID;//密码为刚才得到的授权码    
		} catch (MessagingException e) {
			e.printStackTrace();
		}   
		return resulte;
	}
	/**
	 * 产生六位数的随机邮箱验证码
	 * @return
	 */
	private static String getItemID(){
			int n =6;
	        String val = "";
	        Random random = new Random();
	        for ( int i = 0; i < n; i++ )
	        {
	            String str = random.nextInt( 2 ) % 2 == 0 ? "num" : "char";
	            if ( "char".equalsIgnoreCase( str ) )
	            { // 产生字母
	                int nextInt = random.nextInt( 2 ) % 2 == 0 ? 65 : 97;
	                val += (char) ( nextInt + random.nextInt( 26 ) );
	            }
	            else
	            { // 产生数字
	                val += String.valueOf( random.nextInt( 10 ) );
	            }
	        }
	        return val;
	    }
}
