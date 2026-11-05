package br.com.nomedaempresa.iniciandojava.controller;

import br.com.nomedaempresa.iniciandojava.service.interfac.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    @Qualifier("v2")
    private IMessageService messageService;


    @GetMapping("/hello")
    public String sayHello(){
        return messageService.sayCustomMessage("Hello World");
    }
}
