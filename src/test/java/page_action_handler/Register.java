package page_action_handler;

public class Register {
    private final String firstName;
    private final String lastName;
    private final String month;
    private final String day;
    private final String year;
    private final String address;
    private final String postcode;
    private final String city;
    private final String state;
    private final String country;
    private final String phoneNumber;
    private final String email;
    private final String password;

    public Register(RegisterBuilder registerBuilder) {
        this.firstName = registerBuilder.firstName;
        this.lastName = registerBuilder.lastName;
        this.month = registerBuilder.month;
        this.day = registerBuilder.day;
        this.year = registerBuilder.year;
        this.address = registerBuilder.address;
        this.postcode = registerBuilder.postcode;
        this.city = registerBuilder.city;
        this.state = registerBuilder.state;
        this.country = registerBuilder.country;
        this.phoneNumber = registerBuilder.phoneNumber;
        this.email = registerBuilder.email;
        this.password = registerBuilder.password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class RegisterBuilder {
        private String firstName;
        private String lastName;
        private String month;
        private String day;
        private String year;
        private String address;
        private String postcode;
        private String city;
        private String state;
        private String country;
        private String phoneNumber;
        private String email;
        private String password;

        public RegisterBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public RegisterBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public RegisterBuilder setMonth(String month) {
            this.month = month;
            return this;
        }

        public RegisterBuilder setDay(String day) {
            this.day = day;
            return this;
        }

        public RegisterBuilder setYear(String year) {
            this.year = year;
            return this;
        }

        public RegisterBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public RegisterBuilder setPostcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public RegisterBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public RegisterBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public RegisterBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public RegisterBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public RegisterBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public RegisterBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
        ThreadLocal<Register> threadLocal = new ThreadLocal<>();

        public Register build() {
            threadLocal.set(new Register(this));
            return threadLocal.get();
        }
    }
}
