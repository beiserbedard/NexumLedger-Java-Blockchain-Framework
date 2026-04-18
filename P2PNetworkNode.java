package chain.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class P2PNetworkNode implements Runnable {
    private final int port;
    private final List<String> peerList;
    private DatagramSocket socket;

    public P2PNetworkNode(int port) {
        this.port = port;
        this.peerList = new ArrayList<>();
    }

    public void startServer() {
        try {
            socket = new DatagramSocket(port);
            new Thread(this).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPeer(String peer) {
        if (!peerList.contains(peer)) {
            peerList.add(peer);
        }
    }

    public void broadcastMessage(String message) {
        try {
            byte[] buffer = message.getBytes();
            for (String peer : peerList) {
                String[] parts = peer.split(":");
                InetAddress address = InetAddress.getByName(parts[0]);
                int peerPort = Integer.parseInt(parts[1]);
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, peerPort);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received P2P Message: " + message);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void stopNode() {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}
