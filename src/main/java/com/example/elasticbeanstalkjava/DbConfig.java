package com.example.elasticbeanstalkjava;

import com.example.elasticbeanstalkjava.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DbConfig {
    @Bean
    public TableSchema<Person> tableSchema() {
        return TableSchema.fromBean(Person.class);
    }

    @Bean
    public DynamoDbEnhancedClient enhancedClient() {
        Region region = Region.EU_CENTRAL_1;
        DynamoDbClient dbClient = DynamoDbClient.builder()
                .region(region)
                .build();
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dbClient)
                .build();
    }

    @Bean
    public DynamoDbTable<Person> table(DynamoDbEnhancedClient enhancedClient,
                                       TableSchema<Person> tableSchema) {
        return enhancedClient.table("People", tableSchema);
    }
}
