package lk.ijse.gdse.aad68.javaeecrud.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.aad68.javaeecrud.dto.StudentDTO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/demo")
public class Demo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        ArrayList<StudentDTO> studentList = jsonb.fromJson(req.getReader(),
                new ArrayList<StudentDTO>() {}.getClass().getGenericSuperclass());

        studentList.forEach(System.out::println);
    }
}
