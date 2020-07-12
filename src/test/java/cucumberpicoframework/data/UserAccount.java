package cucumberpicoframework.data;

import com.github.javafaker.Faker;

public class UserAccount {
    private Faker faker = new Faker();

    private String gender = "Male";
    private String password = "TestTest12300!@£!";
    private String dayOfBirth = String.valueOf(11);
    private String monthOfBirth = String.valueOf(11);
    private String yearOfBirth = String.valueOf(1990);
    private String firstName = "Testtest";
    private String lastName = faker.name().lastName();
    private int stateIndex = faker.number().numberBetween(1, 50);
    private String postcode = String.valueOf(faker.number().numberBetween(10000, 99999));
    private String email = faker.internet().safeEmailAddress();
    //maybe dont need this as only one option
    private int countryIndex = faker.number().numberBetween(21, 21);
    private String alias = "alias address";

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return faker.address().buildingNumber();
    }

    public void setEmail(String email) {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
    }

    public String getCity() {
        return faker.address().city();
    }

    public void setCity(String city) {
    }

    public int getStateIndex() {
        return stateIndex;
    }

    public void setStateIndex(int stateIndex) {
        this.stateIndex = stateIndex;
    }

    public String getPostCode() {
        return postcode;
    }

    public void setPostCode(String postCode) {
    }

    public int getCountryIndex() {
        return countryIndex;
    }

    public void setCountryIndex(int countryIndex) {
        this.countryIndex = countryIndex;
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public void setPhoneNumber(String phoneNumber) {
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
