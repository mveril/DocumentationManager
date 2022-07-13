package com.mveril.documentationmanager.api;

import com.mveril.documentationmanager.dao.DAOFactory;
import com.mveril.documentationmanager.dao.DocumentationDAO;
import com.mveril.documentationmanager.entity.Documentation;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("docs")
public class DocApi {
    
    private DocumentationDAO documentationDAO;

    public DocApi() {
        documentationDAO = DAOFactory.getDocumentationDAO();
    }
    
    
  
    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public List<Documentation> list(){
        return documentationDAO.findAll();
    }
    
    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(){
        Optional<Documentation> doc = documentationDAO.findById(0);
        if(doc.isPresent()){
            return Response.ok(doc.get()).build();
        }  else{
             return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @Path("/{id}")
    @DELETE()
    public Response delete(@PathParam("id") int id){
        if(documentationDAO.delete(id)){
            return Response.ok().build();
        }  else{
             return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public long post(Documentation documentation){
        documentationDAO.create(documentation);
        return documentation.getId();
    }
    
    @Path("/{id}")
    @PUT()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, Documentation documentation){
        if(id == documentation.getId()){
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
