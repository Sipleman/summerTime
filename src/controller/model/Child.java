package controller.model;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Created by Ilias on 08.03.2016.
 */
public class Child {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty adres;
    private final IntegerProperty postalCode;
    private final StringProperty phoneNumber;
    private final StringProperty parentPhoneNumber;

    private final ObjectProperty<LocalDate> birthday;

    public Child(){
        this(null,null);
    }
    public Child(String firstName, String lastName){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        this.adres= new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.phoneNumber = new SimpleStringProperty("0934123132");
        this.parentPhoneNumber = new SimpleStringProperty("0505123122");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getadres() {
        return adres.get();
    }

    public void setadres(String adres) {
        this.adres.set(adres);
    }

    public StringProperty adresProperty() {
        return adres;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public StringProperty phoneNumberPropery() {
        return phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }
    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber.get();
    }

    public StringProperty parentPhoneNumberProperty() {
        return parentPhoneNumber;
    }
}
