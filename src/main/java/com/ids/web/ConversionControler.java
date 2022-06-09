package com.ids.web;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.entity.Conversion;

import lombok.AllArgsConstructor;

//http://localhost:1000/api/v1/devises
@RestController
@RequestMapping("/api/v1/conjversions")
@CrossOrigin("*")
@AllArgsConstructor
public class ConversionControler extends AbstractCrudController<Conversion, UUID> {

}