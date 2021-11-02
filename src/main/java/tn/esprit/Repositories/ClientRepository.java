package tn.esprit.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT c FROM Client c WHERE c.email=:email AND c.password=:password")
    Client getClientByEmailAndPassword(String email,String password);

    @Query("SELECT c FROM Client c WHERE c.email = :email")
    Client getClientByEmail(String email);
}
