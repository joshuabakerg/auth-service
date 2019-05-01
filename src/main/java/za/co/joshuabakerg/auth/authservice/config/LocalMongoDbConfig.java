package za.co.joshuabakerg.auth.authservice.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Profile("!prod")
@Configuration
public class LocalMongoDbConfig extends AbstractMongoConfiguration {


    @Override
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017/auth-service?retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        return mongoClient;
    }


    @Override
    protected String getDatabaseName() {
        return "auth-service";
    }

}
