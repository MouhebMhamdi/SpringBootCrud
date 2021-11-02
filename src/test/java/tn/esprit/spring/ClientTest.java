package tn.esprit.spring;


import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.Repositories.ClientRepository;
import tn.esprit.model.CategorieClient;
import tn.esprit.model.Client;
import tn.esprit.model.Profession;
import tn.esprit.services.ClientServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@SpringBootTest
@Slf4j
public class ClientTest {

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @MockBean
    private ClientRepository ClientRepository;




    @Test
    public void test(){

        try {
            Client client=new Client();
            Date date= new SimpleDateFormat( "yyyyMMdd" ).parse( "19981105" );
            client.setEmail("mouhebmh2@gmail.com");
            client.setNom("mouheb");
            client.setPrenom("mhamdi");
            client.setPassword("1234");
            client.setCategorie(CategorieClient.Premium);
            client.setProffesion(Profession.Etudiant);
            client.setDateNaissance(date);
            clientServiceImpl.ajouterClient(client);
            String mail = "scolarite1@esprit.tn";
            String mdp = "scolarite1";


            if(client.getEmail().equals(mail) && client.getPassword().equals(mdp)){
                Mockito.when(ClientRepository.getClientByEmailAndPassword(mail,mdp)).thenReturn(client);

            }else{
                Mockito.when(ClientRepository.getClientByEmailAndPassword(client.getEmail(),client.getPassword())).thenReturn(null);
                if (client.getEmail().equals(mail)){
                    Mockito.when(ClientRepository.getClientByEmail(client.getEmail())).thenReturn(client);
                }
            }

            Client found = clientServiceImpl.doLogin(mail,mdp);

            //assertThat(found.geteMail()).isEqualTo(d.geteMail());
            System.out.println(client.getEmail()+" "+client.getPassword()+" ");





            // clientServiceImpl.supprimerClient(1);


                Optional<Client> C1 = clientServiceImpl.chercherClientByID(client.getIdClient());
                Assertions.assertNotNull(C1.get().getDateNaissance());
                log.info("le nom du client d'id : "+C1.get().getIdClient()+" est "+ C1.get().getNom());
                log.info("le prenom du client d'id : "+C1.get().getIdClient()+" est "+ C1.get().getPrenom());


        }catch (Exception e){


            System.out.println(e.getMessage());
        }

        
        

    }
}
