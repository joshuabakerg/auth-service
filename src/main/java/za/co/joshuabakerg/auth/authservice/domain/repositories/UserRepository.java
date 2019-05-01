package za.co.joshuabakerg.auth.authservice.domain.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.joshuabakerg.auth.authservice.domain.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);

}
