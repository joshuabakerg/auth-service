package za.co.joshuabakerg.auth.authservice.domain.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import za.co.joshuabakerg.auth.authservice.domain.entities.ClientDetailsImpl;

/**
 * @author Joshua Baker on 03/09/2019
 */
@Repository
public interface ClientDetailsRepository extends MongoRepository<ClientDetailsImpl, ObjectId> {

    ClientDetailsImpl findByClientId(String clientId);

}
