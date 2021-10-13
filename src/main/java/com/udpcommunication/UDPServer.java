package com.udpcommunication;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.PublicKey;

import org.apache.commons.lang3.SerializationUtils;

public class UDPServer {

	public static void main(String[] args) {
		new UDPServer(50001).run();
	}

	private int port;

	/**
	 * @param port The port in which the server will listen
	 */
	public UDPServer(int port) {
		this.port = port;
	}

	public void run() {
		while (true) {
			//Some other small change
			try (DatagramSocket serverSocket = new DatagramSocket(port);) {
				InetAddress address = InetAddress.getLocalHost();
				byte[] buffer = new byte[256];
				DatagramPacket received_packet = new DatagramPacket(buffer, buffer.length, address, port);
				serverSocket.receive(received_packet);
				
				//This is an object command.
				Command received_command = SerializationUtils.deserialize(received_packet.getData());

				System.out.println(received_command.getCommand_number());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}
