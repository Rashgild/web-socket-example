package ru.rashgild.websocket.server;

public class ServerRun {

    public static void main(String[] args) {
        WebSocketService webSocketService = new WebSocketServiceImpl();
        webSocketService.start();
        while (true) ;
    }
}
