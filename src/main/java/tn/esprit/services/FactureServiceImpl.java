package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.ClientRepository;
import tn.esprit.Repositories.FactureRepository;
import tn.esprit.model.Client;
import tn.esprit.model.Facture;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService{

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    ClientRepository clientRepository;
    @Override
    public void ajouterFacture(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public void supprimerFacture(long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public void supprimerToutLesFactures() {
        factureRepository.deleteAll();
    }

    @Override
    public List<Facture> chercherFacture() {
        return factureRepository.findAll();
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        Client user=clientRepository.findById(idClient).get();
        List<Facture> fact=factureRepository.getFactureByClient(user);
        return fact;
    }

    @Override
    public Facture addFacture(Facture f, Long idClient) {
        Client client= clientRepository.findById(idClient).get();
        f.setClient(client);
        factureRepository.save(f);
        return null;
    }
}
