package ru.rashgild.websocket.client;

import static ru.rashgild.websocket.server.WebSocketServiceImpl.SERVER_ADDRESS;

import java.net.URI;
import java.net.URISyntaxException;

public class ClientRun {

    public static void main(String[] args) {
        try {
            final WebsocketClientEndpoint clientEndPoint =
                    new WebsocketClientEndpoint(new URI(SERVER_ADDRESS + "/hello"));

            while (true) {
                clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                    @Override
                    public void handleMessage(String message) {
                        System.out.println("Message from server: " + message);
                    }
                });
                clientEndPoint.sendMessage("{\"hello\":\"server\"}");
                Thread.sleep(5000);
            }


        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
