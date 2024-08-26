package org.example.javeeepos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.javeeepos.bo.BoFactory;
import org.example.javeeepos.bo.Custom.ProductBo;
import org.example.javeeepos.bo.Custom.impl.ProductBoImpl;
import org.example.javeeepos.dto.ProductDto;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/product")
public class ProductController extends HttpServlet {

    ProductBo productBo = (ProductBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.PRODUCT);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if(id!=null){
            try(var writer = resp.getWriter()){
                ProductDto productDto = productBo.getProduct(id);
                resp.setContentType("application/json");
                Jsonb jsonb = JsonbBuilder.create();
                jsonb.toJson(productDto,writer);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            try(var writer = resp.getWriter()){
                List<ProductDto> productDto = productBo.getAllProduct();
                resp.setContentType("application/json");
                Jsonb jsonb = JsonbBuilder.create();
                jsonb.toJson(productDto,writer);
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        ProductDto productDto = jsonb.fromJson(req.getReader(), ProductDto.class);
        try(var writer = resp.getWriter()){
            boolean isSaved = productBo.saveProduct(productDto);

            if (isSaved) {
                writer.println("Saved Successfully");
            }else{
                writer.println("Saved Failed");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        ProductDto productDto = jsonb.fromJson(req.getReader(), ProductDto.class);

        try(var writer = resp.getWriter()){

            boolean isUpdated = productBo.updateProduct(productDto);
            if (isUpdated) {
                writer.println("Update Successfully");
            }else{
                writer.println("Update Failed");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try(var writer = resp.getWriter()){

            boolean isDelete = productBo.deleteProduct(id);

            if (isDelete) {
                writer.println("Delete Successfully");
            }else{
                writer.println("Delete Failed");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
