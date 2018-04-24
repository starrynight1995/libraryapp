package com.libraryapp.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@ComponentScan(basePackages = "com.libraryapp")
public class MongoConfig {
	
 
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
    	MongoCredential credential = MongoCredential.createCredential("username", "database", "password".toCharArray()); 
    	MongoClient mongoClient = new MongoClient(new ServerAddress("host", 27982), Arrays.asList(credential));

                return new SimpleMongoDbFactory(mongoClient, "library");
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
 
}