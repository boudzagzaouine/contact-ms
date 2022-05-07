package com.ids.web;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.entity.Client;

//http://localhost:1000/api/v1/clients
@RestController
@RequestMapping("/api/v1/clients")
@CrossOrigin("*")
public class ClientController extends AbstractCrudController<Client, UUID> {
}
