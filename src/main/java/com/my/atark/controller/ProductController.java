package com.my.atark.controller;


import com.my.atark.domain.Product;
import com.my.atark.exceptions.ProductServiceException;
import com.my.atark.service.IProductServ;
import com.my.atark.service.ServiceFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    @GetMapping(path = "allProducts")
    public List<Product> allProducts() {
        List<Product> result = null;
        try {
            IProductServ productServ = ServiceFactory.getProductService();
            result = productServ.findAllProducts();
        }
        catch (ProductServiceException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(path = "allProducts/from={from}&offset={offset}")
    public  List<Product> productOffset(@PathVariable("from") String from, @PathVariable("offset") String offset) {
        List<Product> result = null;
        try {
            IProductServ productServ = ServiceFactory.getProductService();
            result = productServ.findProducts(Integer.parseInt(from),Integer.parseInt(offset));
        }
        catch (ProductServiceException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(path = "allProducts/{code}")
    public Product productByCode(@PathVariable("code") String code) {
        Product result = null;
        try {
            IProductServ productServ = ServiceFactory.getProductService();
            result = productServ.findProductByCode(code);
        }
        catch (ProductServiceException e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(path = "allProducts/addNew")
    public void addProduct(@PathVariable String code) {
        IProductServ serv = ServiceFactory.getProductService();
        serv.deleteProduct(code);
    }

    @PutMapping(path = "allProducts/{code}")
    public void updateProduct(@PathVariable("code") String code) {
        IProductServ serv = ServiceFactory.getProductService();
        serv.deleteProduct(code);
    }

    @DeleteMapping(path = "allProducts/{code}")
    public void deleteProduct(@PathVariable("code") String code) {
        IProductServ serv = ServiceFactory.getProductService();
        serv.deleteProduct(code);
    }
}
