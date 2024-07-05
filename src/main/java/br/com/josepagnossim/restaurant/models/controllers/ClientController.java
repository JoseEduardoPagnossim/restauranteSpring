package br.com.josepagnossim.restaurant.models.controllers;

import br.com.josepagnossim.restaurant.models.dtos.ClientDto;
import br.com.josepagnossim.restaurant.models.entities.Client;
import br.com.josepagnossim.restaurant.models.services.ClientService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

//    @Id
//    private final UUID id = UUID.randomUUID();

    @PostMapping
    public Client create(@RequestBody ClientDto clientDto) {
        return clientService.create(clientDto);
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable UUID id) {
        return clientService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Client> findByName(@PathVariable String name) {
        return clientService.findByNameContainingIgnoreCase(name);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable UUID id,@RequestBody ClientDto clientDto) {
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Client deleted");
    }
}
