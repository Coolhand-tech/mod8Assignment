package com.example.contacts;

public class Contact {


    // Immutable contact ID (unique, non-null, max 10 characters)
    private final String contactId;
    // First name (non-null, max 10 characters)
    private String firstName;
    // Last name (non-null, max 10 characters)
    private String lastName;
    // Phone number (non-null, exactly 10 digits)
    private String phone;
    // Address (non-null, max 30 characters)
    private String address;

    /**
     * Constructor to create a new Contact with validated fields.
     * @param contactId Unique identifier (max 10 chars, non-null)
     * @param firstName First name (max 10 chars, non-null)
     * @param lastName Last name (max 10 chars, non-null)
     * @param phone Phone number (exactly 10 digits, non-null)
     * @param address Address (max 30 chars, non-null)
     * @throws IllegalArgumentException if any field validation fails
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate contact ID
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and must be 10 characters or less");
        }
        // Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or less");
        }
        // Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less");
        }
        // Validate phone number (must be exactly 10 digits)
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must not be null and must be exactly 10 digits");
        }
        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or less");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    /**
     * Gets the contact ID.
     * @return The contact ID
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Gets the first name.
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name.
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the phone number.
     * @return The phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the address.
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    // Setters for updatable fields
    /**
     * Updates the first name with validation.
     * @param firstName New first name (max 10 chars, non-null)
     * @throws IllegalArgumentException if validation fails
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or less");
        }
        this.firstName = firstName;
    }

    /**
     * Updates the last name with validation.
     * @param lastName New last name (max 10 chars, non-null)
     * @throws IllegalArgumentException if validation fails
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less");
        }
        this.lastName = lastName;
    }

    /**
     * Updates the phone number with validation.
     * @param phone New phone number (exactly 10 digits, non-null)
     * @throws IllegalArgumentException if validation fails
     */
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must not be null and must be exactly 10 digits");
        }
        this.phone = phone;
    }

    /**
     * Updates the address with validation.
     * @param address New address (max 30 chars, non-null)
     * @throws IllegalArgumentException if validation fails
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or less");
        }
        this.address = address;
    }


}
