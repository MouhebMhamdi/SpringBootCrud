package tn.esprit.spring;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.model.CategorieClient;
import tn.esprit.model.Client;
import tn.esprit.model.Profession;
import tn.esprit.services.ClientServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
public class ClientTest {

    @Autowired
    private ClientServiceImpl clientServiceImpl;




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

            // clientServiceImpl.supprimerClient(1);
        }catch (Exception e){


            System.out.println(e.getMessage());
        }

        
        

    }
}
