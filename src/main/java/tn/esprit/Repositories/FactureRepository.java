package tn.esprit.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.model.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
}
