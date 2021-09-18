package com.lp2.desafio.controller.request;

import com.lp2.desafio.model.entities.Client;

import lombok.Setter;

@Setter
public class ClientRequest {
    
    private String name;
    private String email;

    public Client toClient(){

        var client = new Client();

        client.setName(name);
        client.setEmail(email);

        return client;

    }
    
}
