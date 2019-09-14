package com.solstice.restfulapi.services;

import com.solstice.restfulapi.enums.ErrorCode;
import com.solstice.restfulapi.exceptions.DuplicatedEntityException;
import com.solstice.restfulapi.exceptions.EntityNotFoundException;
import com.solstice.restfulapi.exceptions.InvalidEntityException;
import com.solstice.restfulapi.helpers.HelpfulMethod;
import com.solstice.restfulapi.helpers.Regex;
import com.solstice.restfulapi.models.Address;
import com.solstice.restfulapi.models.Contact;
import org.eclipse.jgit.annotations.NonNull;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ContactService {
    private static List<Contact> staticContactList = new ArrayList<>();

    private static List<Contact> filterList(List<Contact> contacts, Contact contact) {
        var filteredList = new ArrayList<>(contacts);
        if (contact != null) {

            var filterEmail = contact.getEmail();
            var filterPersonalNumber = contact.getPersonalNumber();
            var filterWorkNumber = contact.getWorkNumber();
            var address = contact.getAddress();
            var filterCity = address != null ? address.getCity() : null;
            var filterState = address != null ? address.getState() : null;

            if (validateEmail(filterEmail)) {
                filteredList = (ArrayList<Contact>) filteredList.stream().filter(c -> c.getEmail().trim().toLowerCase().equals(filterEmail.trim().toLowerCase())).collect(Collectors.toList());
            }

            if (validateNumber(filterPersonalNumber)) {
                filteredList = (ArrayList<Contact>) filteredList.stream().filter(c -> c.getPersonalNumber().equals(filterPersonalNumber)).collect(Collectors.toList());
            }

            if (validateNumber(filterWorkNumber)) {
                filteredList = (ArrayList<Contact>) filteredList.stream().filter(c -> c.getWorkNumber().equals(filterWorkNumber)).collect(Collectors.toList());
            }

            if (!HelpfulMethod.IsStringNullOrEmpty(filterCity)) {
                filteredList = (ArrayList<Contact>) filteredList.stream().filter(c -> c.getAddress().getCity().trim().toLowerCase().equals(filterCity.trim().toLowerCase())).collect(Collectors.toList());
            }

            if (!HelpfulMethod.IsStringNullOrEmpty(filterState)) {
                filteredList = (ArrayList<Contact>) filteredList.stream().filter(c -> c.getAddress().getState().trim().toLowerCase().equals(filterState.trim().toLowerCase())).collect(Collectors.toList());
            }
        }
        return filteredList;
    }

    private static boolean validateEmail(String email) {
        return !HelpfulMethod.IsStringNullOrEmpty(email) && Pattern.compile(Regex.EMAIL, Pattern.CASE_INSENSITIVE).matcher(email).matches();
    }

    private static boolean validateNumber(Long number) {
        return number != null && number > 10000000 && number < 9999999999L;
    }

    private static boolean validateName(String name) {
        return !HelpfulMethod.IsStringNullOrEmpty(name);
    }

    private static boolean validateCompany(String company) {
        return !HelpfulMethod.IsStringNullOrEmpty(company);
    }

    private static boolean validateBirthday(Date birthday) {
        return birthday != null && !LocalDate.now().isEqual(birthday.toLocalDate()) && Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), birthday.toLocalDate())) >= 18;
    }

    private static boolean validateAddress(Address address) {
        return address != null && address.getBlock() > 0 && !HelpfulMethod.IsStringNullOrEmpty(address.getStreet()) && !HelpfulMethod.IsStringNullOrEmpty(address.getCity()) && !HelpfulMethod.IsStringNullOrEmpty(address.getState());
    }

    public static List<Contact> getAll(Contact contact) {
        return filterList(staticContactList, contact);
    }

    public static Contact getById(@NonNull Long id) throws EntityNotFoundException {
        Contact contact = null;
        if (id != null && id > 0) {
            contact = staticContactList.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
            if (contact == null) {
                throw new EntityNotFoundException("The contact with id " + id + " has not been found", ErrorCode.ENTITYNOTFOUND);
            }
        }
        return contact;
    }

    private static boolean validateContact(@NonNull Contact contact) {
        return contact != null && validateName(contact.getName()) && validateCompany(contact.getCompany()) && validateEmail(contact.getEmail()) && validateNumber(contact.getPersonalNumber()) && validateNumber(contact.getWorkNumber()) && validateBirthday(contact.getBirthday()) && validateAddress(contact.getAddress());
    }

    private static boolean didContactExist(Contact contact) {
        return staticContactList.stream().anyMatch(c -> c.getEmail().trim().toLowerCase().equals(contact.getEmail().trim().toLowerCase()));
    }

    public static void create(@NonNull Contact contact) throws InvalidEntityException, DuplicatedEntityException {
        if (validateContact(contact)) {
            if (!didContactExist(contact)) {
                contact.setId(staticContactList.isEmpty() ? 1 : staticContactList.get(staticContactList.size() - 1).getId() + 1);
                staticContactList.add(contact);
            } else {
                throw new DuplicatedEntityException("This contact already exists", ErrorCode.DUPLICATEDENTITY);
            }
        } else {
            throw new InvalidEntityException("The contact you wanted to create is invalid", ErrorCode.INVALIDENTITY);
        }
    }

    public static Contact modify(@NonNull Long id, @NonNull Contact contact) throws EntityNotFoundException, DuplicatedEntityException, InvalidEntityException {
        Contact contactToModify;

        if (id != null && id > 0 && validateContact(contact)) {
            var contactRetrieved = getById(id);
            contactToModify = staticContactList.stream().filter(c -> c.equals(contactRetrieved)).findFirst().orElse(null);
            if (contactToModify != null) {
                if (!contactToModify.getEmail().toLowerCase().equals(contact.getEmail().trim().toLowerCase()) && didContactExist(contact)) {
                    throw new DuplicatedEntityException("This contact already exists", ErrorCode.DUPLICATEDENTITY);
                }
                contactToModify.setName(contact.getName());
                contactToModify.setCompany(contact.getCompany());
                contactToModify.setEmail(contact.getEmail());
                contactToModify.setBirthday(contact.getBirthday());
                contactToModify.setPersonalNumber(contact.getPersonalNumber());
                contactToModify.setWorkNumber(contact.getWorkNumber());
                contactToModify.setAddress(contact.getAddress());
            } else {
                throw new EntityNotFoundException("The contact with id " + id + " has not been found", ErrorCode.ENTITYNOTFOUND);
            }
        } else {
            throw new InvalidEntityException("The contact you wanted to modify is invalid", ErrorCode.INVALIDENTITY);
        }

        return contactToModify;
    }

    public static Contact erase(@NonNull Long id) throws EntityNotFoundException {
        var contact = getById(id);
        staticContactList.remove(contact);
        return contact;
    }
}
