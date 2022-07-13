package com.mveril.documentationmanager.api;

import com.mveril.documentationmanager.dao.DAOFactory;
import com.mveril.documentationmanager.entity.Category;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
@Path("doc")
public class DocApi {
    @GET()
    public String test(){
        Category cat1 = new Category();
        cat1.setName("HTML");
        DAOFactory.getCategoryDAO().create(cat1);
        return "Hello";
    }
}
