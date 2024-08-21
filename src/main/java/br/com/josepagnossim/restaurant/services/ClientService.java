package br.com.josepagnossim.restaurant.services;

import br.com.josepagnossim.restaurant.exceptions.client.ClientNotFound;
import br.com.josepagnossim.restaurant.exceptions.client.InvalidInsertionOfClientData;
import br.com.josepagnossim.restaurant.models.dtos.ClientDto;
import br.com.josepagnossim.restaurant.models.entities.Client;
import br.com.josepagnossim.restaurant.models.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(ClientDto clientDto) {
        if (clientDto.name() == null || clientDto.document() == null) {
            throw new InvalidInsertionOfClientData("Client name and document are required");
        } else {
            Client client = new Client();
            client.setId(UUID.randomUUID());
            client.setName(clientDto.name());
            client.setDocument(clientDto.document());
            return clientRepository.save(client);
        }
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFound("Client not found for the ID " + id));
    }

    public List<Client> findByName(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Client> findByDocument(String document) {
        return clientRepository.findByDocumentContainingIgnoreCase(document);
    }

    public Client updateClient(UUID id, ClientDto clientDto) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        Client client = null;
        if (optionalClient.isPresent()) {
            client = optionalClient.get();
            client.setName(clientDto.name());
            client.setDocument(clientDto.document());
            return clientRepository.save(client);
        } else {
            throw new ClientNotFound("Client not found for update, for the id provided " + id);
        }
    }

    public void deleteClient(UUID id) {
        clientRepository.deleteById(id);
    }
}
