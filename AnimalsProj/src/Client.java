

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private static int port = 8901;

	public static void main(String[] args) throws Exception{
		Socket clientSocket = new Socket("localhost", port);

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
		BufferedReader sysIn = new BufferedReader( new InputStreamReader(System.in));
		
		String userInput;
        while ((userInput = sysIn.readLine()) != null) {
        	//System.out.println("echo 1: " + in.readLine());
        	out.println(userInput);
        	System.out.println("echo 2: " + in.readLine());
        	//System.out.println("echo 1: " + in.readLine());
        }
	}

}
