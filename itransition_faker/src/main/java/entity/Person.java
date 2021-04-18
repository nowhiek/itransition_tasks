package entity;

public class Person {

    private String fullName;
    private String fullAddress;
    private String phone;

    private Person() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getPhone() {
        return phone;
    }

    public static Builder newBuilder() {
        return new Person().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setFullName(String fullName) {
            Person.this.fullName = fullName;

            return this;
        }

        public Builder setFullAddress(String fullAddress) {
            Person.this.fullAddress = fullAddress;

            return this;
        }

        public Builder setPhone(String phone) {
            Person.this.phone = phone;

            return this;
        }

        public Person build() {
            return Person.this;
        }
    }
}
