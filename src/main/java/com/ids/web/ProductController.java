package com.ids.web;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.data.web.AbstractCrudController;
import com.ids.entity.Product;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends AbstractCrudController<Product, UUID> {
}