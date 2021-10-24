package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.StockRepository;
import tn.esprit.model.Stock;

@Service
public class StockServiceImpl implements stockService{
    @Autowired
    StockRepository stockRepository;
    @Override
    public void addStock(Stock stock) {
        if(!stockRepository.findById(stock.getIdStock()).isPresent()){
            stockRepository.save(stock);
        }
    }

    @Override
    public Stock getStockById(long id) {
        return stockRepository.findById(id).get();
    }
}
