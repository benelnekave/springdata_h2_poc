package com.ben.springdata_h2_poc.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ben.springdata_h2_poc.models.Customer;

/**
 * This interface is extending the implemented by spring data.
 * I wrote another function which return Stream for better performance over the db
 * @author belnekave
 *
 */
public interface  CustomerRepository extends CrudRepository<Customer, Long> {
	

 // custom query example and return a stream
    @Query("select c from Customer c where c.id = :id")
    public Stream<Customer> findByIdReturnStream(@Param("id") Long id);

}
