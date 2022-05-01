package com.ids.web;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.entity.Unit;

@RestController
@RequestMapping("/api/v1/units")
public class UnitController extends AbstractCrudController<Unit, UUID> {
}