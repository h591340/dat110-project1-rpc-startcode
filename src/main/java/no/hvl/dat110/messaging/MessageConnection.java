package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;


public class MessageConnection {

	private DataOutputStream outStream; // for writing bytes to the underlying TCP connection
	private DataInputStream inStream; // for reading bytes from the underlying TCP connection
	private Socket socket; // socket for the underlying TCP connection
	
	public MessageConnection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream (socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {

		byte[] data;
		
		// TODO - START
		// encapsulate the data contained in the Message and write to the output stream
		try {				
			
			data = message.getData();
			outStream.write(data);
			
			outStream.close();
			
			socket.close();
					
		} catch (IOException ex){
			System.out.println("TCP clint: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
		}
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
			
		// TODO - END

	}

	public Message receive() {

		Message message = null;
		byte[] data;
		
		// TODO - START
		// read a segment from the input stream and decapsulate data into a Message
		int length;
		try {
			length = inStream.readInt();
			data =new byte[length];
			System.out.print("TCP Receiver starting");
			
		    System.out.println("TCP Receiver reading");
		    inStream.read(data);
		    
		    System.out.print("TCP Receiver received: ");
		    for (byte b : data) {
		    	System.out.print((byte) b);
		    }
		    
			
		    System.out.println();
		    
		    inStream.close();
		    
		    socket.close();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			System.out.println("TCPServer: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
			

		}
		System.out.println("TCP Receiver stopping");
		
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return message;
		
	}

	// close the connection by closing streams and the underlying socket	
	public void close() {

		try {
			
			outStream.close();
			inStream.close();

			socket.close();
			
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
