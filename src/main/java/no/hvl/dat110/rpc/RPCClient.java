package no.hvl.dat110.rpc;

import java.io.IOException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	// underlying messaging client used for RPC communication
	private MessagingClient msgclient;

	// underlying messaging connection used for RPC communication
	private MessageConnection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		// TODO - START
		// connect using the RPC client
		
		
			try {
				connection=msgclient.connect();
			}
			catch(Exception e) {
				System.out.println("Something wrong happens"+e);
			}
		}
	
      
       
        
    
	
		
		 
		
		// TODO - END
	
	
	public void disconnect() {
		
		// close the messaging connection
		try {
			if(connection != null) {
				connection.close();

			}

		} catch(Exception e) {
			System.out.println("Error occurred: " + e);
		}
	}
	
		
		
		// TODO - END
	

	/*
	 Make a remote call om the method on the RPC server by sending an RPC request message and receive an RPC reply message

	 rpcid is the identifier on the server side of the method to be called
	 param is the marshalled parameter of the method to be called
	 */

	public byte[] call(byte rpcid, byte[] param) {
		
		byte[] returnval = null;
		
		// TODO - START
		
		try {
			byte[]rpcmsg=RPCUtils.encapsulate(rpcid, param);
		

		
			Message request = new Message(rpcmsg);
		
		// send the request to the server
		
			connection.send(request);
	
		
		
		
		// receive the reply from the server
			Message reply = connection.receive();
		
		// get the return value from the reply message
		

			if(reply!=null)
			{
				returnval=RPCUtils.decapsulate(reply.getData());
			}
			
		}
		
		
		catch (Exception e) {
            System.out.println("Error occurred while receiving reply: " + e.getMessage());
		}
		
		
		/*

		The rpcid and param must be encapsulated according to the RPC message format

		The return value from the RPC call must be decapsulated according to the RPC message format

		*/
				
		
		// TODO - END
		return returnval;
		
	}

}
