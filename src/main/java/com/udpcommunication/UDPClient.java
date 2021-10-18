package com.udpcommunication;

import java.net.DatagramPacket;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import org.apache.commons.lang3.SerializationUtils;

public class UDPClient {

	private int port;
	byte[] buffer;

	public static void main(String[] args) {

			new UDPClient(50001).run();
		
	}

	public UDPClient(int port) {
		this.port = port;
	}

	public void run() {
		while (true) {
			try (DatagramSocket clientSocket = new DatagramSocket();) {
				InetAddress address = InetAddress.getLocalHost();
				
				String message = "";
				Scanner scanner = new Scanner(System.in);
				message = scanner.nextLine();
				
				if(message.equals("1") ) {
					Command firs_command = new Command((byte)1);
					buffer = SerializationUtils.serialize(firs_command);
				}
				else if (message.equals("2")) {
					Command second_Command = new Command((byte)2);
					buffer = SerializationUtils.serialize(second_Command);
				}
				else {
					System.out.println("Invalid command");
					continue;
				}

				DatagramPacket sent_packet = new DatagramPacket(buffer, buffer.length, address, port);
				clientSocket.send(sent_packet);
				
				byte[] buffer = new byte[256];
				DatagramPacket response_packet = new DatagramPacket(buffer, buffer.length, address, port);
				clientSocket.receive(response_packet);
				
				Response response = SerializationUtils.deserialize(buffer);
				System.out.println("The status of the command is: "+ response.getResponse_status());
				System.out.println("The message of the command is: "+ response.getResponse_object());
				

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
