class Contact {
    private String name;
    private String phone;
    private String email;
    private String location;

    public Contact(String name, String phone, String email, String location) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public void setPhone(String newNumber) {
        throw new UnsupportedOperationException("Unimplemented method 'setPhone'");
    }
}