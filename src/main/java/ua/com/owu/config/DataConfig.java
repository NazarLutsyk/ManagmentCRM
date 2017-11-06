package ua.com.owu.config;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    @Bean
    public MongoClient mongoClient(){
        MongoClient mongoClient = new MongoClient("localhost");
        return mongoClient;
    }

    @Bean
    public Morphia morphia(){
        Morphia morphia = new Morphia();
        morphia.mapPackage("ua.com.owu.entity");
        return morphia;
    }

    @Bean
    public Datastore datastore (){
        return morphia().createDatastore(mongoClient(), "managmentCrm");
    }
}
