package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.ProduitRepository;
import tn.esprit.Repositories.StockRepository;
import tn.esprit.model.Produit;

@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    StockRepository stockRepository;
    @Override
    public void addProduit(Produit produit) {
        produitRepository.save(produit);


    }

    @Override
    public Produit getProduitById(long id) {
        return  produitRepository.findById(id).get();
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit prod=produitRepository.getById(idProduit);
        prod.setStock(stockRepository.findById(idStock).get());
        produitRepository.save(prod);
    }
}
