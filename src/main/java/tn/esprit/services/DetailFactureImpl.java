package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.DetailFactureRepository;
import tn.esprit.model.DetailFacture;

@Service
public class DetailFactureImpl implements DetailFactureService{

    @Autowired
    DetailFactureRepository detailFactureRepository;


    @Override
    public void AddDetailFacture(DetailFacture detailFacture) {
        if(!detailFactureRepository.findById(detailFacture.getIdDetailFacture()).isPresent()){
            detailFactureRepository.save(detailFacture);
        }else{
            System.out.println("Detail Facture Existe déja !!");
        }
    }

    @Override
    public DetailFacture getDetailFacture(long id) {
        return detailFactureRepository.findById(id).get();
    }
}
