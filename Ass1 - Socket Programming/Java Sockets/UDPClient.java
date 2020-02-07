import java.io.*;
import java.net.*;

public class UDPClient{
	public static void main(String args[]) throws Exception{
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		byte[] chatData = new byte[1024];
		while(true){
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		String sentence = inFromUser.readLine();
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("172.16.4.142");
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 5666);
		clientSocket.send(sendPacket);
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);
		
		DatagramPacket chatPacket = new DatagramPacket(chatData, chatData.length);
		clientSocket.receive(chatPacket);
		String modifiedSentence2 = new String(chatPacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence2);
		
		
		clientSocket.close();
		}
}
}