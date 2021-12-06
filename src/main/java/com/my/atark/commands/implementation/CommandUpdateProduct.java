package com.my.atark.commands.implementation;

import com.my.atark.domain.Product;
import com.my.atark.service.IProductServ;
import com.my.atark.service.ServiceFactory;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/product")
public class CommandUpdateProduct {

    @PostMapping
    public void execute(@RequestBody Product product) {
        IProductServ serv = ServiceFactory.getProductService();
        serv.updateProduct(product);
    }
}
