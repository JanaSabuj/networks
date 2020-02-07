import java.io.*;
import java.net.*;
public class TCPClient {
	public static void main(String args[]) throws Exception{
	String sentence;
	String modifiedSentence;
while(true){
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Server: ");
	sentence = inFromUser.readLine();

	Socket clientSocket = new Socket("172.16.4.142",5555);
	OutputStream outToServer = clientSocket.getOutputStream();
	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

	outToServer.write((sentence+"\n").getBytes());
	modifiedSentence = inFromServer.readLine();
	
	// get the chat
	String hischat;
	hischat = inFromServer.readLine();
	outToServer.write((hischat).getBytes());
	System.out.println("CLIENT : "+ hischat);
	
	clientSocket.close();
}
}
}