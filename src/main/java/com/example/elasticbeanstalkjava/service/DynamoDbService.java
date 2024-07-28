package com.example.elasticbeanstalkjava.service;

import com.example.elasticbeanstalkjava.domain.Person;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

@Service
public class DynamoDbService {
    private final DynamoDbTable<Person> table;

    public DynamoDbService(DynamoDbTable<Person> table) {
        this.table = table;
    }

    public Key createPartitionKey(long id) {
        return Key.builder().partitionValue(id).build();
    }

    public Key createSortKey(String firstname) {
        return Key.builder().sortValue(firstname).build();
    }

    public Person getPerson(long id) {
        return table.getItem(createPartitionKey(id));
    }

    public void putPerson(Person person) {
        table.putItem(person);
    }

    public void deletePerson(long id) {
        table.deleteItem(createPartitionKey(id));
    }
}
