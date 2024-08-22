package org.example.javeeepos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.javeeepos.bo.CustomerBo;
import org.example.javeeepos.bo.impl.customerBoImpl;
import org.example.javeeepos.dao.CustomerDao;
import org.example.javeeepos.dto.CustomerDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerController extends HttpServlet{

    CustomerBo customerBo = new customerBoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDao =  jsonb.fromJson(req.getReader(), CustomerDTO.class);
        try (PrintWriter printWriter = resp.getWriter()){
            boolean isSaved = customerBo.saveCustomer(customerDao);

            if (isSaved) {
                printWriter.println("Saved");
            }else{
                printWriter.println("Failed");
            }


        } catch (SQLException | NamingException  e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try(PrintWriter printWriter = resp.getWriter()){
            boolean isDeleted = customerBo.DeleteCustomer(id);
            if (isDeleted) {
                printWriter.println("Delete Successfully");
            }else{
                printWriter.println("Delete failed");
            }
        }catch (SQLException | NamingException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
