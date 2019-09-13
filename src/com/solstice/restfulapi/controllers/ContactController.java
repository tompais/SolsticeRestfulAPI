package com.solstice.restfulapi.controllers;

import com.solstice.restfulapi.models.Contact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/contact")
public class ContactController extends BaseController {

    @GET
    public List<Contact> Get(Contact contact){
        return new ArrayList<>();
    }
}
