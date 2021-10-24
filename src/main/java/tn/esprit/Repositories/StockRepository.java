package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.model.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
