

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static int port = 8901;
	private static ServerSocket servSock;
	private static PrintWriter out;
	private static BufferedReader in;
	//ClientConnections clients;
	//Room[] rooms;
	
	//Server()
	//createRoom()
	
	public static void main(String[] args) throws Exception{

		servSock = new ServerSocket(port);
		Socket s = servSock.accept(); //So that we can get an input stream
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = new PrintWriter(s.getOutputStream(), true);
		
		//To take input from the Server Console itself?
		BufferedReader sysIn = new BufferedReader( new InputStreamReader(System.in));
		
		boolean inSession = true;
		String nextLine = "", sysInput = "";
		while(inSession){
			sysInput = sysIn.readLine();
			nextLine = in.readLine();
			//if("quit".equals(sysInput) || sysInput != null){
			if("quit".equals(sysInput)){

				System.out.println("Quiting");
				inSession = false;
			}
			else{
				//Reads a line and writes it to the connected socket, sending it to the server
				out.println(nextLine);
				//The server echoes the info back, so we can print that here:
				System.out.println("Echo of client: " + nextLine);
				//System.out.println("Echo of SysInput: " + sysInput);
			}
			
		}
		s.close();
		servSock.close();//Closes socket after end of session

	}

}
