package tn.esprit.services;

import tn.esprit.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService  {
    void ajouterClient(Client client);
    Optional<Client> chercherClientByID(long id);
    void supprimerClient(long id);
    void supprimerToutLesClients();
    List<Client> chercherClient();

}
