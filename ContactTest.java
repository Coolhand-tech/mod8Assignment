package com.example.contacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    /**
     * Sets up a valid contact before each test.
     */
    @BeforeEach
    void setUp() {
        contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    /**
     * Tests successful creation of a contact with valid fields.
     */
    @Test
    void testValidContactCreation() {
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    /**
     * Tests that a null contact ID throws an exception.
     */
    @Test
    void testNullContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Contact ID must not be null and must be 10 characters or less", exception.getMessage());
    }

    /**
     * Tests that a contact ID longer than 10 characters throws an exception.
     */
    @Test
    void testLongContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Contact ID must not be null and must be 10 characters or less", exception.getMessage());
    }

    /**
     * Tests that a null first name throws an exception.
     */
    @Test
    void testNullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
        });
        assertEquals("First name must not be null and must be 10 characters or less", exception.getMessage());
    }

    /**
     * Tests that a first name longer than 10 characters throws an exception.
     */
    @Test
    void testLongFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Johnathannn", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("First name must not be null and must be 10 characters or less", exception.getMessage());
    }

    /**
     * Tests that a null last name throws an exception.
     */
    @Test
    void testNullLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", null, "1234567890", "123 Main St");
        });
        assertEquals("Last name must not be null and must be 10 characters or less", exception.getMessage());
    }

    /**
     * Tests that a last name longer than 10 characters throws an exception.
     */
    @Test
    void testLongLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
        });
        assertEquals("Last name must not be null and must be 10 characters or less", exception.getMessage());
    }

    /**
     * Tests that a phone number with fewer than 10 digits throws an exception.
     */
    @Test
    void testInvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "123456789", "123 Main St");
        });
        assertEquals("Phone number must not be null and must be exactly 10 digits", exception.getMessage());
    }

    /**
     * Tests that a null phone number throws an exception.
     */
    @Test
    void testNullPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", null, "123 Main St");
        });
        assertEquals("Phone number must not be null and must be exactly 10 digits", exception.getMessage());
    }

    /**
     * Tests that an address longer than 30 characters throws an exception.
     */
    @Test
    void testLongAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street, Springfield, IL, USA");
        });
        assertEquals("Address must not be null and must be 30 characters or less", exception.getMessage());
    }

    /**
     * Tests that a null address throws an exception.
     */
    @Test
    void testNullAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", null);
        });
        assertEquals("Address must not be null and must be 30 characters or less", exception.getMessage());
    }

    /**
     * Tests updating all mutable fields successfully.
     */
    @Test
    void testUpdateFields() {
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Ave");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }
}
