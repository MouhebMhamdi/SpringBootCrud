package tn.esprit.services;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.ClientRepository;
import tn.esprit.model.Client;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
    public  ClientRepository clientRepositorie;


    public ClientServiceImpl(ClientRepository clientRepositorie) {
        this.clientRepositorie = clientRepositorie;
    }

    @Override
    public void ajouterClient(Client client) {

        clientRepositorie.save(client);
    }

    @Override
    public Optional<Client> chercherClientByID(long id) {
        return clientRepositorie.findById(id);
    }

    @Override
    public void supprimerClient(long id) {
        clientRepositorie.deleteById(id);
    }

    @Override
    public void supprimerToutLesClients() {
        clientRepositorie.deleteAll();
    }

    @Override
    public List<Client> chercherClient() {
        return clientRepositorie.findAll();
    }

    @Override
    public Boolean getClientByEmailAndPassword(String email, String Password) {
        if(clientRepositorie.getClientByEmailAndPassword(email,Password)!=null) return true;
        return false;
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepositorie.getClientByEmail(email);
    }

    @Override
    public Client doLogin(String email, String Password) {
        return clientRepositorie.getClientByEmailAndPassword(email,Password);
    }


}
