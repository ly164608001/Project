package com.tgb.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.tgb.model.User;

public class SendMail implements Runnable{
	//用于给用户发送邮件的邮箱
//	private String from = "164608001@qq.com";
	private String from = "18960816449@163.com";
	//邮箱用户名
//	private String username = "164608001";
	private String username = "18960816449";
	//邮箱密码授权码cajrbioknnalcajb
//	private String password = "cajrbioknnalcajb";
	private String password = "lmj03820";
	//发送邮件的服务器地址
//	private String host = "smtp.exmail.qq.com";
	private String host = "smtp.163.com";
	public User user;
	public SendMail(User user){
		this.user = user;
	}
	public void run() {
		Properties properties = new Properties();
		properties.setProperty("mail.host", host);
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		//1、创建session
		Session session = Session.getInstance(properties);
		//开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);
		try {
			//2、通过session得到transport对象
			Transport transport = session.getTransport();
			//3、连上邮件服务器，需要发件人提供邮箱的用户名和密码进行验证
			transport.connect(host, username, password);
			//4、创建邮件
			Message message = createEmail(session,user);
			//5、发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//创建要发送的邮件
	private Message createEmail(Session session, User user) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
			message.setSubject("注册邮件");
			String info = "恭喜您注册成功！您的用户名："+user.getUserName()+",密码："+user.getPassword()+",请妥善保管！";
			message.setContent(info,"text/html;charset=UTF-8");
			message.saveChanges();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

}
