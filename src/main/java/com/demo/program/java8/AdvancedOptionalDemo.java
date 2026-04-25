package com.demo.program.java8;

import java.util.Optional;

/**
 * Advanced Optional Demo
 * Demonstrates complex Optional chaining, flatMap, and handling nested optionals.
 * Suitable for senior developers to handle null-safety in functional style.
 */
public class AdvancedOptionalDemo {

    public static void main(String[] args) {
        // Sample data with potential nulls
        User user1 = new User("Alice", new Address("123 Main St", new City("New York", "NY")));
        User user2 = new User("Bob", new Address("456 Elm St", null)); // City is null
        User user3 = new User("Charlie", null); // Address is null
        User user4 = null; // User is null

        // Process users
        processUser(user1);
        processUser(user2);
        processUser(user3);
        processUser(user4);
    }

    private static void processUser(User user) {

        String result = Optional.ofNullable(user)
            .flatMap(u -> Optional.ofNullable(u.getAddress()))
            .flatMap(addr -> Optional.ofNullable(addr.getCity()))
            .map(City::getName)
            .orElse("Unknown City");

        System.out.println("User: " + (user != null ? user.getName() : "null") + ", City: " + result);



        // More complex: Get state if city exists, else default
        String state = Optional.ofNullable(user)
            .flatMap(u -> Optional.ofNullable(u.getAddress()))
            .flatMap(addr -> Optional.ofNullable(addr.getCity()))
            .map(City::getState)
            .orElse("N/A");

        System.out.println("State: " + state);



        // Chaining with filters
        boolean hasValidAddress = Optional.ofNullable(user)
            .flatMap(u -> Optional.ofNullable(u.getAddress()))
            .filter(addr -> addr.getStreet() != null && !addr.getStreet().isEmpty())
            .isPresent();

        System.out.println("Has valid address: " + hasValidAddress);



        // Using ifPresentOrElse (Java 9, but since Java 8, we can simulate)
        Optional.ofNullable(user)
            .ifPresent(u -> System.out.println("Processing user: " + u.getName()));



        // For else, we can use orElse
        // Complex: Compute something based on nested optionals
        int streetLength = Optional.ofNullable(user)
            .flatMap(u -> Optional.ofNullable(u.getAddress()))
            .map(Address::getStreet)
            .map(String::length)
            .orElse(0);

        System.out.println("Street name length: " + streetLength);

        System.out.println("------------------------------------");
    }



    static class User {
        private String name;
        private Address address;

        public User(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        public String getName() { return name; }
        public Address getAddress() { return address; }
    }

    static class Address {
        private String street;
        private City city;

        public Address(String street, City city) {
            this.street = street;
            this.city = city;
        }

        public String getStreet() { return street; }
        public City getCity() { return city; }
    }

    static class City {
        private String name;
        private String state;

        public City(String name, String state) {
            this.name = name;
            this.state = state;
        }

        public String getName() { return name; }
        public String getState() { return state; }
    }
}


//        ---------------------------------------------------------------
//        Output
//        ---------------------------------------------------------------
//        User: Alice, City: New York
//        State: NY
//        Has valid address: true
//        Processing user: Alice
//        Street name length: 11
//        ------------------------------------
//        User: Bob, City: Unknown City
//        State: N/A
//        Has valid address: true
//        Processing user: Bob
//        Street name length: 10
//        ------------------------------------
//        User: Charlie, City: Unknown City
//        State: N/A
//        Has valid address: false
//        Processing user: Charlie
//        Street name length: 0
//        ------------------------------------
//        User: null, City: Unknown City
//        State: N/A
//        Has valid address: false
//        Street name length: 0
//        ------------------------------------