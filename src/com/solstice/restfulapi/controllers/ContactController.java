package com.solstice.restfulapi.controllers;

import com.solstice.restfulapi.exceptions.DuplicatedEntityException;
import com.solstice.restfulapi.exceptions.EntityNotFoundException;
import com.solstice.restfulapi.exceptions.InvalidEntityException;
import com.solstice.restfulapi.helpers.HelpfulMethod;
import com.solstice.restfulapi.models.Contact;
import com.solstice.restfulapi.services.ContactService;
import org.eclipse.jgit.annotations.NonNull;

import javax.ws.rs.*;
import java.util.List;

@Path("/contact")
public class ContactController extends BaseController {

    //With this method you can either get a list of contacts by their email and/or phone,
    //or you can also do this by city and/or state
    //This HttpGet Method will filter everything as you want
    @GET
    public List<Contact> Get(@BeanParam Contact contact) {
        return ContactService.getAll(contact);
    }


    //The parameter ID can be sent either by PathParam or the entity with QueryParam
    @GET
    @Path("{id : \\d+}")
    public Contact GetById(@PathParam("id") @NonNull Long id, @BeanParam @NonNull Contact contact) throws EntityNotFoundException {
        return ContactService.getById(id != null && id > 0 ? id : contact.getId());
    }

    //Same concept as getById, but with the email
    @GET
    @Path("{email}")
    public Contact GetByEmail(@PathParam("email") @NonNull String email, @BeanParam @NonNull Contact contact) throws EntityNotFoundException {
        return ContactService.getByEmail(!HelpfulMethod.IsStringNullOrEmpty(email) ? email : contact.getEmail());
    }

    @POST
    public Contact Post(@NonNull Contact contact) throws DuplicatedEntityException, InvalidEntityException {
        ContactService.create(contact);
        return contact;
    }


    //I use the id to find the record.
    //Then, I use the contact param to send the information that I want to modify from the specified record.
    @PUT
    @Path("{id : \\d+}")
    public Contact Put(@PathParam("id") @NonNull Long id, @NonNull Contact contact) throws EntityNotFoundException, InvalidEntityException, DuplicatedEntityException {
        return ContactService.modify(id != null && id > 0 ? id : contact.getId(), contact);
    }

    @DELETE
    @Path("{id : \\d+}")
    public Contact Delete(@PathParam("id") @NonNull Long id) throws EntityNotFoundException {
        return ContactService.erase(id);
    }

    //I give you the opportunity to delete the record by id or by email
    @DELETE
    @Path("{email}")
    public Contact DeleteByEmail(@PathParam("email") @NonNull String email) throws EntityNotFoundException {
        return ContactService.erase(email);
    }
}
