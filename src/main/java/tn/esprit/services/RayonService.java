package tn.esprit.services;


import tn.esprit.model.Rayon;

public interface RayonService {
    public void addRayon(Rayon rayon);
    public Rayon getRayonById(long id);
}
