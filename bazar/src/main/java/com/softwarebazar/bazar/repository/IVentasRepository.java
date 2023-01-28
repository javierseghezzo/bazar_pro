
package com.softwarebazar.bazar.repository;
import com.softwarebazar.bazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentasRepository extends JpaRepository<Venta, Long> {
    
}
