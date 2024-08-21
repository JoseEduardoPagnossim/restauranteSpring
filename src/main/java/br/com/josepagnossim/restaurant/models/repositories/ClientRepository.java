package br.com.josepagnossim.restaurant.models.repositories;

import br.com.josepagnossim.restaurant.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    //@Param("name") - RETIRADO POIS SÓ DEVE SER USADO QUANDO FIZER A CONSULTA ATRAVES DO @Query e não pelo Spring direto
    //@Query("SELECT c FROM Client c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Client> findByNameContainingIgnoreCase(String name);

    List<Client> findByDocumentContainingIgnoreCase(String document);

}
