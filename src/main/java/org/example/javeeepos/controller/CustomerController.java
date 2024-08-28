package org.example.javeeepos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.javeeepos.bo.BoFactory;
import org.example.javeeepos.bo.Custom.CustomerBo;
import org.example.javeeepos.bo.Custom.impl.CustomerBoImpl;
import org.example.javeeepos.dto.CustomerDTO;

import javax.naming.NamingException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/customer")
public class CustomerController extends HttpServlet{

    CustomerBo customerBo = (CustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.CUSTOMER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id!=null) {

            try(var writer = resp.getWriter()){
                CustomerDTO customerDTO = customerBo.getCustomer(id);
                resp.setContentType("application/json");
                Jsonb jsonb = JsonbBuilder.create();
                jsonb.toJson(customerDTO,writer);
            }catch (Exception e){
                throw new RuntimeException(e);
            }

        }else {
            try (var writer = resp.getWriter()) {
                List<CustomerDTO> customer = customerBo.getAllCustomer();
                resp.setContentType("application/json");
                Jsonb jsonb = JsonbBuilder.create();
                jsonb.toJson(customer, writer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

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
        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        try(PrintWriter printWriter = resp.getWriter()){
            boolean isUpdated = customerBo.updateCustomer(customerDTO);

            if (isUpdated) {
                printWriter.println("Updated Successfully");
            }else{
                printWriter.println("Updated Failed");
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
