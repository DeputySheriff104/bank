package ru.kolesnikov.bank.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import ru.kolesnikov.bank.web.handler.ServiceHandler;

public class JettyServer {

    public void start() throws Exception {
        Server server = new Server(8080);

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(ServiceHandler.class, "/api/users");

        server.setHandler(servletHandler);

        server.start();
        server.join();
    }
}
