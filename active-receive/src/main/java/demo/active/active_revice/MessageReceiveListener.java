package demo.active.active_revice;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageReceiveListener implements MessageListener {

	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		if (msg instanceof  TextMessage){
			TextMessage  txtmsg = (TextMessage)msg;
			try {
				System.out.println("消费一条信息:" + txtmsg.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}

	
}
