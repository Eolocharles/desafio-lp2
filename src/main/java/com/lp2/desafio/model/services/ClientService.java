package com.lp2.desafio.model.services;

import com.lp2.desafio.model.entities.Client;
import com.lp2.desafio.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
   
    @Autowired
    private ClientRepository repository ;

    public Client create(Client client){

    
        if(repository.existsByName(client.getName())){
            throw new RuntimeException("Nome já existe");
           
        }

        return  repository.save(client);
    }

    public Client update(String id, Client client) {

        var clientDatabase = this.getById(id);
        
        var c = repository.findByName(client.getName());

        if(c != null && !c.getId().equals(id)) {
         
            throw new RuntimeException("Nome já existe");
            
        }

        clientDatabase.setName(client.getName());
        clientDatabase.setEmail(client.getEmail());

        return repository.save(clientDatabase);

    }

    

    public Page<Client> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Client getById(String id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Cliente não existe"));
    }
    
    public void delete(String id){
        repository.deleteById(id);
    }
}
