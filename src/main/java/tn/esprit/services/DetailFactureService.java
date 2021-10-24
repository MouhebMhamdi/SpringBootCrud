package tn.esprit.services;

import tn.esprit.model.DetailFacture;


public interface DetailFactureService {
    void AddDetailFacture(DetailFacture detailFacture);

    DetailFacture getDetailFacture(long id);
}
