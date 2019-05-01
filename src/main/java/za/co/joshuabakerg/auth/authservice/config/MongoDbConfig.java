package za.co.joshuabakerg.auth.authservice.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Profile("prod")
@Configuration
public class MongoDbConfig extends AbstractMongoConfiguration {

    @Value("${dbConnectionString}")
    private String connectionUrl;


    @Override
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI(connectionUrl);
        MongoClient mongoClient = new MongoClient(uri);
        return mongoClient;
    }


    @Override
    protected String getDatabaseName() {
        return "auth-service";
    }

}
