package ru.rashgild.websocket.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/{path}")
public class ExampleEndpoint {


    /**
     * Getting message from Client.
     *
     * @param session the current websocket session.
     * @param name    message from client
     * @return String message to client
     */
    @OnMessage
    public String onMessage(Session session, String name) {
        System.out.println("client " + session.getId() + " send message:" + name);
        return "Hello from server," + name;
    }

    /**
     * Event if client is connected to this server.
     *
     * @param session the current session.
     * @param path    String path of server`s endpoint
     * @return String message to client
     */
    @OnOpen
    public String onOpen(Session session, @PathParam("path") String path) {
        System.out.println("client " + session.getId() + " connected on path \"" + path + "\"");
        return "Hello from server!";
    }


    /**
     * If client leave (close) socket.
     *
     * @param session the current websocket session.
     * @return String message
     */
    @OnClose
    public String onClose(Session session) {
        return "closed";
    }

    /**
     * Show if error detected.
     *
     * @param session   the current websocket session.
     * @param throwable the detected error to be logged.
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Error for session " + session.getId());
    }
}

