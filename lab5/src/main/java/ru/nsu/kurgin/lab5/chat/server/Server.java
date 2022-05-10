package ru.nsu.kurgin.lab5.chat.server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(11111); // серверсокет прослушивает порт 4004
                System.out.println("Сервер запущен!"); // хорошо бы серверу
                //   объявить о своем запуске
                clientSocket = server.accept(); // accept() будет ждать пока
                System.out.println("client connect");
                //кто-нибудь не захочет подключиться
                try { // установив связь и воссоздав сокет для общения с клиентом можно перейти
                    // к созданию потоков ввода/вывода.
                    // теперь мы можем принимать сообщения
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // и отправлять
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
                    System.out.println(word);
                    // не долго думая отвечает клиенту
                    out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
                    out.flush(); // выталкиваем все из буфера

                } finally { // в любом случае сокет будет закрыт
                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//
//    private static Socket clientSocket; //сокет для общения
//    private static ServerSocket server; // серверсокет
//    private static BufferedReader in; // поток чтения из сокета
//    private static BufferedWriter out; // поток записи в сокет
//
//    public static void main(String[] args) {
//        try {
//            try {
//                server = new ServerSocket(5555); // серверсокет прослушивает порт 4004
//                System.out.println("Сервер запущен!"); // хорошо бы серверу
//                //   объявить о своем запуске
//                clientSocket = server.accept(); // accept() будет ждать пока
//                System.out.println("Client connect");
//                //кто-нибудь не захочет подключиться
//                try { // установив связь и воссоздав сокет для общения с клиентом можно перейти
//                    // к созданию потоков ввода/вывода.
//                    // теперь мы можем принимать сообщения
//                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                    // и отправлять
//                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//
//                    while (true) {
//                        System.out.println("1");
//                        String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
//                        System.out.println(word);
//                        // не долго думая отвечает клиенту
//                        out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
//                        out.flush(); // выталкиваем все из буфера
//                    }
//                } finally { // в любом случае сокет будет закрыт
//                    clientSocket.close();
//                    // потоки тоже хорошо бы закрыть
//                    in.close();
//                    out.close();
//                }
//            } finally {
//                System.out.println("Сервер закрыт!");
//                server.close();
//            }
//        } catch (IOException e) {
//            System.err.println(e);
//        }
//    }
//}