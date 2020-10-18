package ru.kolesnikov.bank.web.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ru.kolesnikov.bank.dao.entities.user.UserDAOImpl;
import ru.kolesnikov.bank.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServiceHandler extends HttpServlet {

    public static final ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

    private static final UserServiceImpl userService =
            new UserServiceImpl(
                    new UserDAOImpl());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println(writer.writeValueAsString(userService.getAll()));
    }
}
