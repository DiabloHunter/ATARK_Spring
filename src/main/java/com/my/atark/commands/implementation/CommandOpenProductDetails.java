package com.my.atark.commands.implementation;

import com.my.atark.domain.Product;
import com.my.atark.exceptions.ProductServiceException;
import com.my.atark.service.IProductServ;
import com.my.atark.service.ServiceFactory;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/products")
public class CommandOpenProductDetails{

    @GetMapping(path = "{code}")
    public Product productByCode(@PathVariable("code") String code) {
        IProductServ serv = ServiceFactory.getProductService();
        Product product = null;
        try {
            product = serv.findProductByCode(code);
        } catch (ProductServiceException e) {
            e.printStackTrace();
        }
        return product;
    }
}
