package com.mveril.documentationmanager.api;

import com.mveril.documentationmanager.dao.CategoryDAO;
import com.mveril.documentationmanager.dao.DAOFactory;
import com.mveril.documentationmanager.dao.DocumentationDAO;
import com.mveril.documentationmanager.entity.Category;
import com.mveril.documentationmanager.entity.Documentation;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("categories")
public class CategoryApi {
    
    private DocumentationDAO documentationDAO;
    private final CategoryDAO categoryDAO;

    public CategoryApi() {
        categoryDAO = DAOFactory.getCategoryDAO();
    } 
  
    @GET()
    @Produces({MediaType.APPLICATION_JSON})
    public List<Category> list(){
        return categoryDAO.findAll();
    }
    
    @Path("/{id}")
    @GET()
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") int id){
        Optional<Category> doc = categoryDAO.findById(id);
        if(doc.isPresent()){
            return Response.ok(doc.get()).build();
        }  else{
             return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @Path("/{id}")
    @DELETE()
    public Response delete(@PathParam("id") int id){
        if(categoryDAO.delete(id)){
            return Response.ok().build();
        }  else{
             return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST()
    @Consumes({MediaType.APPLICATION_JSON})
    public long post(Category category){
        categoryDAO.create(category);
        return category.getId();
    }
    
    @Path("/{id}")
    @PUT()
    @Consumes({MediaType.APPLICATION_JSON})
    public Response put(@PathParam("id") int id, Category category){
        if(id == category.getId()){
            categoryDAO.update(category);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}