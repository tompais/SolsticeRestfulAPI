package com.solstice.restfulapi.controllers;

import com.solstice.restfulapi.exceptions.DuplicatedEntityException;
import com.solstice.restfulapi.exceptions.EntityNotFoundException;
import com.solstice.restfulapi.exceptions.InvalidEntityException;
import com.solstice.restfulapi.models.Contact;
import com.solstice.restfulapi.services.ContactService;
import org.eclipse.jgit.annotations.NonNull;

import javax.ws.rs.*;
import java.util.List;

@Path("/contact")
public class ContactController extends BaseController {

    @GET
    public List<Contact> Get(@BeanParam Contact contact) {
        return ContactService.getAll(contact);
    }

    @GET
    @Path("{id : \\d+}")
    public Contact GetById(@PathParam("id") @NonNull Long id, @BeanParam @NonNull Contact contact) throws EntityNotFoundException {
        return ContactService.getById(id != null && id > 0 ? id : contact.getId());
    }

    @POST
    public Contact Post(@NonNull Contact contact) throws DuplicatedEntityException, InvalidEntityException {
        ContactService.create(contact);
        return contact;
    }

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
}
