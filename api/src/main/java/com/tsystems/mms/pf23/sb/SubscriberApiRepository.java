package com.tsystems.mms.pf23.sb;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@RepositoryRestResource(collectionResourceRel = "subscribers", path = "subscribers")
public interface SubscriberApiRepository extends PagingAndSortingRepository<Subscriber, String> {
    List<Subscriber> findByName(@Param("name") String name);
}
