package com.ids.mymaquete.web;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.mymaquete.entity.Exemple;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/exemple")
@CrossOrigin("*")
@AllArgsConstructor
public class ExempleController extends AbstractCrudController<Exemple, UUID> {

}
