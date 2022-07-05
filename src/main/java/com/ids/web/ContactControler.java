package com.ids.web;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.entity.Contact;

import lombok.AllArgsConstructor;

//http://localhost:1000/api/v1/contacts
@RestController
@RequestMapping("/api/v1/contacts")
@CrossOrigin("*")
@AllArgsConstructor
public class ContactControler extends AbstractCrudController<Contact, UUID> {

}
