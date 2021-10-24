package tn.esprit.services;

import tn.esprit.model.Stock;

public interface stockService {

    public void addStock(Stock stock);
    public Stock getStockById(long id);
}
