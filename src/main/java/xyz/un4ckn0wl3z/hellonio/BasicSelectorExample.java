package xyz.un4ckn0wl3z.hellonio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class BasicSelectorExample {

	public static void main(String[] args) throws IOException {
		
		// Get the selector  
		Selector selector = Selector.open();
		
		// Get the selector  
		System.out.println("Selector is open for making connection: " + selector.isOpen());

		ServerSocketChannel SS = ServerSocketChannel.open();
		
		InetSocketAddress hostAddess = new InetSocketAddress("localhost",8080);
		
		SS.bind(hostAddess);
		
		SS.configureBlocking(false);
		
		int ops = SS.validOps();
		
		SelectionKey selectKy = SS.register(selector, ops, null);  
		
		// System.out.println("ValidOps: "+ops);
		// System.out.println("SelectionKey: "+selectKy.getClass());
		
		for (;;) {
			
			System.out.println("Waiting for the select operation...");  
			int noOfKeys = selector.select();
			System.out.println("The Number of selected keys are: " + noOfKeys);
			
			Set selectedKeys = selector.selectedKeys();
			
			Iterator itr = selectedKeys.iterator();
			
			while(itr.hasNext()){
				SelectionKey ky = (SelectionKey) itr.next();
				if(ky.isAcceptable()){
					 // The new client connection is accepted 
					SocketChannel clientChannel = SS.accept();
					clientChannel.configureBlocking(false);
					
					// The new connection is added to a selector  
					
					clientChannel.register(selector, SelectionKey.OP_READ);
					System.out.println("The new connection is accepted from the client: " + clientChannel);
					
					
				}else if (ky.isReadable()){
					// Data is read from the client  
					SocketChannel client = (SocketChannel) ky.channel();
					ByteBuffer buffer = ByteBuffer.allocate(256);  
					client.read(buffer); 
					
					String output = new String(buffer.array()).trim();
					
					System.out.println("Message read from client: " + output);
					
					if(output.equals("Bye Bye")){
						client.close();
						System.out.println("The Client messages are complete; close the session.");
						
					}
					
					
					
				}
				
				 itr.remove();
			} // end of while loop  
			
			
		} // end of for loop  
	
	}

}
