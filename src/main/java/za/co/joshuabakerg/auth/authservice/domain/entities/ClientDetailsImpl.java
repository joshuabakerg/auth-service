package za.co.joshuabakerg.auth.authservice.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import lombok.Data;

/**
 * @author Joshua Baker on 03/09/2019
 */
@Document(collection = "Client")
@Data
public class ClientDetailsImpl extends BaseClientDetails {

    @Id
    @JsonIgnore
    private ObjectId id;

}
