package ru.rashgild.websocket.server;

import javax.websocket.DeploymentException;

import org.glassfish.tyrus.server.Server;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/

public class WebSocketServiceImpl implements WebSocketService {

    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 8025;
    private static final String SERVER_CONTEXT_PATH = "/websocket";

    public static final String SERVER_ADDRESS =
            "ws://" + SERVER_HOSTNAME + ":" + SERVER_PORT + SERVER_CONTEXT_PATH;

    private Server server;

    public void start() {
        try {
            System.out.println("Starting server for " + SERVER_ADDRESS);
            server = new Server(
                    SERVER_HOSTNAME,
                    SERVER_PORT,
                    SERVER_CONTEXT_PATH,
                    null,
                    ExampleEndpoint.class
            );

            server.start();
        } catch (DeploymentException e) {
            server = null;
        }
    }

    public void stop() {
        if (server != null) {
            System.out.println("Stopping server for " + SERVER_ADDRESS);
            server.stop();
        }
    }
}
