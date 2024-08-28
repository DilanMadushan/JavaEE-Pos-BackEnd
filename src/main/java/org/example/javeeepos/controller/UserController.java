package org.example.javeeepos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.javeeepos.bo.Custom.UserBo;
import org.example.javeeepos.bo.Custom.impl.UserBoImpl;
import org.example.javeeepos.dto.CustomerDTO;
import org.example.javeeepos.dto.UserDto;

import java.io.IOException;
@WebServlet (urlPatterns = "/user")
public class UserController extends HttpServlet{

    UserBo userBo = new UserBoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        UserDto dto = jsonb.fromJson(req.getReader(), UserDto.class);

        try(var writer = resp.getWriter()){
            boolean isSaved = userBo.saveUser(dto);
            if (isSaved) {
                writer.println("Save Successfully");
            }else{
                writer.println("Save Failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try(var writer = resp.getWriter()){
            UserDto user = userBo.getUser(id);
            resp.setContentType("application/json");
            Jsonb jsonb = JsonbBuilder.create();
            jsonb.toJson(user,writer);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
