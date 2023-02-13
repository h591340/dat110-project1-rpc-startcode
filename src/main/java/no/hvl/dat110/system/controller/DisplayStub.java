package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
		
		// TODO - START
		 
		  byte[] msgString = RPCUtils.marshallString(message);
		  RPCUtils.unmarshallString(msgString);	
	
		// implement marshalling, call and unmarshalling for write RPC method
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
	}
}
