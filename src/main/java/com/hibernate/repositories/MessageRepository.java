package com.hibernate.repositories;

import com.hibernate.entities.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query(value = "select * from message where message LIKE '%C%'", nativeQuery = true)
    public Collection<Message> fetchMessagesThatContainCapitalLetter();
}
