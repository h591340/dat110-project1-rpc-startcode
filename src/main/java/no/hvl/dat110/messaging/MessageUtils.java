package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		// TODO - START
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer
		data=message.getData();
		
		
		segment = new byte[data.length];
		Arrays.fill(segment, (byte) 0);

		for (int i = 0; i < data.length; i++) {
		    segment[i] = data[i];
		}
		

			
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		// TODO - START
		// decapsulate segment and put received payload data into a message
	
		message=new Message(segment);
		
		
		
		// TODO - END
		
		return message;
		
	}
	
}
