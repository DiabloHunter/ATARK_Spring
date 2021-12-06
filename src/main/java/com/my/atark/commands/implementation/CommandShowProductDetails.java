package com.my.atark.commands.implementation;

import com.my.atark.domain.Product;
import com.my.atark.domain.User;
import com.my.atark.exceptions.ProductServiceException;
import com.my.atark.exceptions.UnknownUserException;
import com.my.atark.service.IProductServ;
import com.my.atark.service.IUserServ;
import com.my.atark.service.ServiceFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/user")
public class CommandShowProductDetails{

    @GetMapping(path = "{id}")
    public Product execute(@PathVariable("id") String id) {
        IProductServ serv = ServiceFactory.getProductService();
        Product product = null;
        try {
            product = serv.findProductById(Integer.parseInt(id));
        }catch (ProductServiceException e) {
            e.printStackTrace();
        }
        return product;
    }
}
