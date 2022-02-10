package ru.alexeiadamov.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        final PrintWriter writer = resp.getWriter();
        writer.println("<h1>Hello, world!</h1>");
        writer.println("<h2>Hola, mondo!</h2>");
        writer.println("<h3>Привет, мир!</h3>");
    }
}
