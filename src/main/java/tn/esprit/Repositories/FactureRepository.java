package tn.esprit.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.model.Client;
import tn.esprit.model.Facture;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
    List<Facture> getFactureByClient(Client client);

}
