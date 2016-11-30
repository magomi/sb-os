package com.tsystems.mms.pf23.sb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@Repository public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    Subscriber findByEmail(String email);
}
