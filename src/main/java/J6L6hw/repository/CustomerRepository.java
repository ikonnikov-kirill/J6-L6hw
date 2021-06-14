package J6L6hw.repository;

import J6L6hw.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final EntityManager entityManager;

    public List<Customer> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM customers", Customer.class).getResultList();
    }

    public Customer getById(int id) {
        return entityManager.find(Customer.class, id);
    }

}
