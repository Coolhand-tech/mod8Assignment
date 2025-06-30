package com.example.contacts;
import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // In-memory storage for contacts, mapping contact ID to Contact object
    private final Map<String, Contact> contacts;

    /**
     * Constructor initializes an empty HashMap for storing contacts.
     */
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    /**
     * Adds a new contact to the collection.
     * @param contactId Unique identifier (max 10 chars, non-null)
     * @param firstName First name (max 10 chars, non-null)
     * @param lastName Last name (max 10 chars, non-null)
     * @param phone Phone number (exactly 10 digits, non-null)
     * @param address Address (max 30 chars, non-null)
     * @throws IllegalArgumentException if contact ID already exists or any field is invalid
     */
    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        // Check for duplicate contact ID
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        // Create new contact with validated fields
        Contact contact = new Contact(contactId, firstName, lastName, phone, address);
        // Add to HashMap
        contacts.put(contactId, contact);
    }

    /**
     * Deletes a contact from the collection by ID.
     * @param contactId The ID of the contact to delete
     * @throws IllegalArgumentException if contact ID does not exist
     */
    public void deleteContact(String contactId) {
        // Check if contact exists
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        // Remove contact from HashMap
        contacts.remove(contactId);
    }

    /**
     * Updates the fields of an existing contact by ID.
     * @param contactId The ID of the contact to update
     * @param firstName New first name
     * @param lastName New last name
     * @param phone New phone number
     * @param address New address
     * @throws IllegalArgumentException if contact ID does not exist or any field is invalid
     */
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        // Check if contact exists
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        // Update fields with validation
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

    /**
     * Retrieves a contact by ID (used for testing).
     * @param contactId The ID of the contact to retrieve
     * @return The Contact object, or null if not found
     */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

}
