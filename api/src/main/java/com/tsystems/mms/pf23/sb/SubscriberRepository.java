package com.tsystems.mms.pf23.sb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, String> {
    List<Subscriber> findAll();
    List<Subscriber> findByName(String name);
    Subscriber findByEmail(String email);
}
