package com.example.contacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService contactService;

    /**
     * Sets up a new ContactService before each test.
     */
    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    /**
     * Tests adding a contact and verifying its fields.
     */
    @Test
    void testAddContact() {
        contactService.addContact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact = contactService.getContact("1234567890");
        assertNotNull(contact);
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    /**
     * Tests that adding a contact with a duplicate ID throws an exception.
     */
    @Test
    void testAddDuplicateContact() {
        contactService.addContact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact("1234567890", "Jane", "Smith", "0987654321", "456 Oak Ave");
        });
        assertEquals("Contact ID already exists", exception.getMessage());
    }

    /**
     * Tests deleting an existing contact.
     */
    @Test
    void testDeleteContact() {
        contactService.addContact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    /**
     * Tests that deleting a non-existent contact throws an exception.
     */
    @Test
    void testDeleteNonExistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("1234567890");
        });
        assertEquals("Contact ID does not exist", exception.getMessage());
    }

    /**
     * Tests updating an existing contact's fields.
     */
    @Test
    void testUpdateContact() {
        contactService.addContact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.updateContact("1234567890", "Jane", "Smith", "0987654321", "456 Oak Ave");
        Contact contact = contactService.getContact("1234567890");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    /**
     * Tests that updating a non-existent contact throws an exception.
     */
    @Test
    void testUpdateNonExistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567890", "Jane", "Smith", "0987654321", "456 Oak Ave");
        });
        assertEquals("Contact ID does not exist", exception.getMessage());
    }

    /**
     * Tests that updating with invalid fields throws an exception.
     */
    @Test
    void testUpdateWithInvalidFields() {
        contactService.addContact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("1234567890", "Johnathannn", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("First name must not be null and must be 10 characters or less", exception.getMessage());
    }

}
