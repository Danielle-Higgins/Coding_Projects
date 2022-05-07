package Networking.GroupChat;

/*
 * Implementation of a Group Chat server in Java
 * By Danielle Higgins for CSCE 416
 */

// I/O related package
import java.io.*;

// Socket related package
import java.net.*;

// Package for other things
import java.util.*;

/*
 * This class does all of Group Chats server's job
 *
 * It consists of 2 threads: parent thread (code inside main method) which accepts
 * new client connections and then spawns a thread per connection
 * 
 * And child thread (code inside run method)
 * Each child thread reads messages from its socket and relays the message to all
 * the active clients (connections)
 *
 * Since a thread is being created with this class object,
 * this class declaration includes "implements Runnable"
 */
public class GroupChatServer implements Runnable
{
	// Each instance has a separate socket
	private Socket clientSock;

	// Using an ArrayList to keep track of all the active clients
	private static ArrayList<PrintWriter> clientList = new ArrayList<PrintWriter>();

	// Constructor sets the socket for the child thread to process
	public GroupChatServer(Socket sock) {
		clientSock = sock;
	}

	// Adds client to active list of clients
	// Since all threads share this, we use "synchronized" to make it atomic
	public static synchronized boolean addClient(PrintWriter toClientWriter) {
		return(clientList.add(toClientWriter));
	}

	// Removes client from active list of clients
	// Since all threads share this, we use "synchronized" to make it atomic
	public static synchronized boolean removeClient(PrintWriter toClientWriter) {
		return(clientList.remove(toClientWriter));
	}

	// Relay the given message to all the active clients
	// Since all threads share this, we use "synchronized" to make it atomic
	public static synchronized void relayMessage(PrintWriter fromClientWriter, String message) {
		// Iterate through the client list and
		// relay message to each client (but not the sender)
		// There are two ways of doing this
		for (PrintWriter print : clientList) {
		 	if (fromClientWriter != print) {
				print.println(message);
		 	}
		}
		// for (int i = 0; i < clientList.size(); i++) {
		// 	if (fromClientWriter != clientList.get(i)) {
		// 		clientList.get(i).println(message);
		// 	}
		// }
	}

	// The child thread starts here
	public void run()
	{
		// Read from the client and relay to other clients
		try {
			// Prepare to read from socket
			BufferedReader fromSockReader = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));

			// Get the client name
			String name = fromSockReader.readLine();

			// Prepare to write to socket with auto flush on
			PrintWriter toSockWriter = new PrintWriter(clientSock.getOutputStream(), true);

			// Add this client to the active client list
			addClient(toSockWriter);
			System.out.println(name + " has joined the chat!");

			// Keep doing until client send EOF
			while (true) {
				// Read a line from the client
				String line = fromSockReader.readLine();

				// If we get null, it means client quit, so break out of loop
				if (line == null) {
					break;
				}

				// Else, relay the line to all active clients
				relayMessage(toSockWriter, name + ": " + line);
			}
			// Done with the client, remove it from client list
			removeClient(toSockWriter);
			System.out.println(name + " has left the chat!");
		}
		catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
	}

	/*
	 * The group chat server program starts from here.
	 * This main thread accepts new clients and spawns a thread for each client
	 * Each child thread does the stuff under the run() method
	 */
	public static void main(String args[]) {
		// Server needs a port to listen on
		if (args.length != 1) {
			System.out.println("usage: java GroupChatServer <server port>");
			System.exit(1);
		}

		// Get the port on which server should listen
		int serverPort = Integer.parseInt(args[0]);

		// Be prepared to catch socket related exceptions
		Socket clientSock = null;
		try {
			// Create a server socket with the given port
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("Waiting for clients ...");

			// Keep accepting/serving new clients
			while (true) {
				// Wait to accept another client
				clientSock = serverSocket.accept();
				
				// Spawn a thread to read/relay messages from this client
				//GroupChatServer chat = new GroupChatServer(clientSock); // Create object of this class
				Thread thread = new Thread(new GroupChatServer(clientSock)); // Create thread from this object
				thread.start(); // start
			}
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}

	}
}