package tn.esprit.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Client;

import tn.esprit.services.ClientServiceImpl;


import java.util.List;

@RestController
@Api(tags = "Client Manager")
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl ClientService;



    public ClientController(ClientServiceImpl ClientService){
        this.ClientService=ClientService;
    }
        @GetMapping("/getAllClients")
    public List<Client> getClients(){
        return ClientService.chercherClient();
    }

    @GetMapping("/deletClient/{id}")
    @ApiOperation(value = "Delete Client By Id ")
    public List<Client> deletClient(@PathVariable(value="id") long id){
        ClientService.supprimerClient(id);
        return ClientService.chercherClient();
    }


        @PostMapping("/registerClient")
        @ApiOperation(value = "Add Client By Id ")
    public String RegisterClient(@RequestBody Client Client){
            ClientService.ajouterClient(Client);
        return "Hi "+ Client.getNom()+" your registration process successfuly Don!!";
    }

    @GetMapping("/getClientByEmail/{email}")
    @ApiOperation(value = "Get Client By Email ")
    public Client getClientByEmail(@PathVariable(value = "email") String email){

        return ClientService.getClientByEmail(email);
    }

    @PostMapping("/updateClient/{id}")
    @ApiOperation(value = "Update Client ")
    public String UpdateClient(@RequestBody Client Client, @PathVariable long id){
        ClientService.updateClient(Client,id);
        return "Client updated successfuly Don !!";
    }

    @GetMapping("/DeleteAllUsers")
    @ApiOperation(value = "Delete All Clients ")
    public String DeleteAllUsers(){
        ClientService.supprimerToutLesClients();
        return  "All Clients deleted !";
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login ")
    public Client login(@RequestBody Client Client) throws Exception {
            String email=Client.getEmail();
            String password=Client.getPassword();
            Client cl=null;
            if(email!=null && password!=null)  cl=ClientService.doLogin(email,password);

            if(cl==null) throw new Exception("No Account to connect !");


        return cl;
    }



}
