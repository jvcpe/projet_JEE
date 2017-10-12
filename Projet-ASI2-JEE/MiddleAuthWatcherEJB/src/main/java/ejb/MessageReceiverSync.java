package ejb;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

import fr.cpe.model.UserModel;

/**
 * Session Bean implementation class MessageReceiverSync
 */

@Stateless
@LocalBean
public class MessageReceiverSync implements MessageReceiverSyncLocal {
	// TODO get jms context
	// TODO associate queue from "java:/jms/queue/watcherqueue"
	
	@Inject
	JMSContext context;
	
	@Resource(mappedName = "java:/jms/queue/watcherqueue")
	Queue queue;
	
	public UserModel receiveMessage() {

		JMSConsumer consumer = context.createConsumer(queue);
		Message m = consumer.receive(1000);

		UserModel c = null;
		if (m instanceof ObjectMessage) {
			c = (UserModel)m;
		}
		return c;
	}
}
