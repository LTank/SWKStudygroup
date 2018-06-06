import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class UDPClient {

    public static void main(String[] args) {
        try{

            ArrayList<String> spaceOddity = new ArrayList<>();
            spaceOddity.add("Ground control to major tom...");
            spaceOddity.add("Take your protein pills and put your helmet on ");
            spaceOddity.add("Ground Control to Major Tom (ten, nine, eight, seven, six) ");
            spaceOddity.add("Commencing countdown, engines on (five, four, three)");
            spaceOddity.add("Check ignition and may God's love be with you (two, one, liftoff)");
            //lige nu sender den til jon, hvis den skal sende til server
            //så ændr InetAddress address = InetAddress.getByName("localhost");

            DatagramSocket dgs = new DatagramSocket();
            System.out.println("Client: dgs created...");

            for (String line : spaceOddity) {
                Thread.sleep(2000);
                byte[] sendArr = line.getBytes();

                InetAddress address = InetAddress.getByName("localhost");
                int port = 6780;

                DatagramPacket datagramPacket = new DatagramPacket(sendArr, sendArr.length, address, port);
                dgs.send(datagramPacket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}