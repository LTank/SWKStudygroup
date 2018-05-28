import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) {
        try{

            //lige nu sender den til jon, hvis den skal sende til server
            //så ændr InetAddress address = InetAddress.getByName("localhost");
            DatagramSocket dgs = new DatagramSocket();
            System.out.println("Client: dgs created...");
                byte[] sendArr = "NOW WATCH ME WHIP".getBytes();
            InetAddress address = InetAddress.getByName("localhost");

            int port = 6780;
            DatagramPacket datagramPacket = new DatagramPacket(sendArr, sendArr.length, address, port);
            dgs.send(datagramPacket);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}