package com.webserver;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Webserver {

    /*
    1. Forb
    2. Modtage req
    3. Parse
    4. Læs fil
    5. Send fil
    6. Luk
     */

    static String path = System.getProperty("user.dir") + "/"; // giver roden til projektmappen
    public static void main(String[] args) {

        try {
            //Server på port 6500
            ServerSocket serverSocket = new ServerSocket(6500);
            while (true){
                System.out.println("server er startet");
                Socket socket = serverSocket.accept();
                System.out.println("forbindelsen er oprettet");

                Scanner requestScanner = new Scanner(socket.getInputStream());
                String httpRequest = requestScanner.nextLine();
                System.out.println("HTTP Request modtaget: ");
                System.out.println("=======================");
                System.out.println(httpRequest);
                System.out.println("=======================");

                System.out.println("Deler requesten op i tokens");
                StringTokenizer requestTokens = new StringTokenizer(httpRequest, " ");
                System.out.println("Der blev lavet i alt: " +  requestTokens.countTokens() + " tokens");

                String fileName = "";

                /*JavaDOCS A data output stream lets an application write primitive
                Java data types to an output stream in a portable way.
                An application can then use a data input stream to read the data back in.*/
                DataOutputStream DOS = new DataOutputStream(socket.getOutputStream());

                String tokenString = requestTokens.nextToken();

                System.out.println("Første token er: " + tokenString);
                //is this a GET request? (vil vi gerne have)
                if(tokenString.equals("GET")){

                    tokenString = requestTokens.nextToken();

                    if(tokenString.startsWith("/")){
                        if(tokenString.equals("/favicon.ico")){
                            fileName = path + "favicon.ico";
                        } else if(tokenString.equals("/")) {
                            fileName = path + "index.html";
                        } else if(tokenString.startsWith("/") ){
                            fileName = path + tokenString;
                        } else {
                            fileName = path + "error404.html";
                            System.out.println("File not found");
                        }
                    }

                    File fileToLoad = new File(fileName); //finder fil lokalt
                    System.out.println("filen er: " + fileToLoad.length() + " lang");
                    int fileByteLength = (int)fileToLoad.length(); // længden af filen caster til int
                    byte[] fileByteArray = new byte[fileByteLength];
                    FileInputStream fileInputStream = new FileInputStream(fileToLoad);
                    fileInputStream.read(fileByteArray, 0, fileByteLength);
                    fileInputStream.close();


                    /*Skriver den standard OK HTTP Response*/
                    DOS.writeBytes("HTTP/1.0 200 OK\r\n");

                    /*Skriver en tilføjelse hvis der er et billede eller et favicon*/
                    if(fileName.endsWith(".jpg")){
                        DOS.writeBytes("Content-Type:image/jpeg\r\n");
                    }
                    if(fileName.endsWith(".gif")){
                        DOS.writeBytes("Content-Type:image/gif\r\n");
                    }
                    if(fileName.endsWith(".ico")){
                        DOS.writeBytes("Content-Type:image/ico\r\n");
                    }

                    /*SIMULERING AF KOMMANDOER!*/
                    System.out.println("Sådan ser vores response ud:");
                    System.out.println("============================");
                    System.out.print("Content-Length:"+fileByteLength+"\r\n");
                    System.out.print("\r\n");
                    for (int i = 0; i < 10; i++){
                        System.out.println("(Byte no " + i + ":) " + Integer.toHexString(fileByteArray[i]));
                    }
                    System.out.println("(many many more bytes....)");
                    System.out.print("\r\n");
                    System.out.println("==============");


                    DOS.writeBytes("Content-Length:"+fileByteLength+"\r\n"); // Her kommer en fil der x lang
                    DOS.writeBytes("\r\n");                     // er et krav fra protokollen ("ny linie")
                    DOS.write(fileByteArray,0,fileByteLength); // her sendes filen
                    DOS.writeBytes("\r\n");                      // er et krav fra protokollen ("ny linie")


                }else {
                    System.out.println("bad request (not a GET)");
                    DOS.writeBytes("HTTP/1.0 400 unknown request");
                    DOS.writeBytes("\r\n");
                }
                DOS.close();
                socket.close();
            }
        }catch (Exception e){

        }

    }




}