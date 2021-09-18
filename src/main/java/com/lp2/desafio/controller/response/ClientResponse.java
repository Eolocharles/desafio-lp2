package com.lp2.desafio.controller.response;

import com.lp2.desafio.model.entities.Client;

import lombok.Getter;

@Getter
public class ClientResponse {

    private String id;
    private String name;
    private String email;

    public ClientResponse fromClient(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        return this;
    }
    
}
