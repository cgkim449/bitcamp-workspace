package net.ex05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client0210 {
  public static void main(String[] args) throws Exception {
    DatagramSocket socket = new DatagramSocket();

    byte[] bytes = "Hello".getBytes("UTF-8");

    DatagramPacket packet = new DatagramPacket(
        bytes, 
        bytes.length, 
        InetAddress.getByName("localhost"), 
        8888);

    socket.send(packet);
    socket.close();
  }
}
