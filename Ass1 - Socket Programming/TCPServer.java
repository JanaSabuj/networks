import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPServer {
	public static void main(String args[]) throws Exception{
		String sentence;
		String modifiedSentence;
		ServerSocket welcomeSocket = new ServerSocket(5555);
		while(true){
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			OutputStream outToClient = connectionSocket.getOutputStream();
			sentence = inFromClient.readLine();
			System.out.println("Client: " + sentence);
			outToClient.write((sentence + "\n").getBytes());
			
			// take my chat
			Scanner input = new Scanner(System.in);
			System.out.print("SERVER: ");
			String mychat = input.nextLine();
			
			outToClient.write((mychat).getBytes());
			
			
			connectionSocket.close();
		}
	}
}