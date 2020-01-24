import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPServer {
	public static void main(String args[]) throws Exception{
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		DatagramSocket serverSocket = new DatagramSocket(5666);
	while(true){
		//recieve data
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		serverSocket.receive(receivePacket);
		
		String sentence = new String(receivePacket.getData());
		InetAddress IPAddress = receivePacket.getAddress();
		int port = receivePacket.getPort();
		String modifiedSentence = sentence.toUpperCase();
		sendData = modifiedSentence.getBytes();
		System.out.println("CLIENT: " + modifiedSentence);
					
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
		serverSocket.send(sendPacket);
		
		// send my chat
		Scanner input = new Scanner(System.in);
		
		String mychat = input.nextLine();
		DatagramPacket sendPacket2 = new DatagramPacket(mychat.getBytes(), mychat.getBytes().length, IPAddress, port);
		serverSocket.send(sendPacket2);
	}
	}
}