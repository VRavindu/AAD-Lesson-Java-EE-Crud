package lk.ijse.gdse.aad68.javaeecrud.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.aad68.javaeecrud.dto.StudentDTO;
import lk.ijse.gdse.aad68.javaeecrud.util.Util;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/student")
public class Student extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET Student
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*System.out.println(req.getParameter("id"));
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("address"));*/

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        /*BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        reader.lines().forEach(line -> sb.append(line).append("\n"));
        System.out.println(sb);*/

        //Process the JSON
        /*JsonReader reader = Json.createReader(req.getReader());
        JsonObject jsonObject = reader.readObject();
        String email = jsonObject.getString("email");
        System.out.println("email : " + email);

        PrintWriter writer = resp.getWriter();
        writer.write(email);*/

        //OPTIONAL - JSON Array Processing
        /*JsonReader reader = Json.createReader(req.getReader());
        JsonArray jsonArray = reader.readArray();
        for (int i = 0; i< jsonArray.size(); i++){
            JsonObject jsonObject = jsonArray.getJsonObject(i);
            System.out.println(jsonObject.getString("name"));
            System.out.println(jsonObject.getString("email"));
        }*/

        //Object binding of the JSON
        Jsonb jsonb = JsonbBuilder.create();
        PrintWriter writer = resp.getWriter();
        StudentDTO student = jsonb.fromJson(req.getReader(), StudentDTO.class);
        student.setId(Util.idGenerate());
        System.out.println(student);

        //create response
        resp.setContentType("application/json");
        jsonb.toJson(student, resp.getWriter());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
