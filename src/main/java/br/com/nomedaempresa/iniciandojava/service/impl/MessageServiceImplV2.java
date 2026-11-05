package br.com.nomedaempresa.iniciandojava.service.impl;

import br.com.nomedaempresa.iniciandojava.service.interfac.IMessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("v2")
public class MessageServiceImplV2 implements IMessageService {

    @Override
    public String sayCustomMessage(String original) {
        return original.replaceAll(" ", "-");
    }
}
