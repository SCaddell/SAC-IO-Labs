package Lab1WithContactObject;

import lab2.*;

public class Contact1 {
    
    private static final int CONSTRUCTOR_ARRAY_SIZE = 8;
    
    private String fName = null;
    private String lName = null;
    private String address = null;
    private String city = null;
    private String state = null;
    private String zipcode = null;
    private String email = null;
    private String phoneNum = null;
    
    public Contact1() {
        fName = null;
        lName = null;
        address = null;
        city = null;
        state = null;
        zipcode = null;
        email = null;
        phoneNum = null;
    }
    
    public Contact1(String[] contactFields) {
        if (contactFields.length == CONSTRUCTOR_ARRAY_SIZE) {
            setfName(contactFields[0]);
            setlName(contactFields[1]);
            setAddress(contactFields[2]);
            setCity(contactFields[3]);
            setState(contactFields[4]);
            setZipcode(contactFields[5]);
            setEmail(contactFields[6]);
            setPhoneNum(contactFields[7]);
        }
        else {
             InstantiationException invalidArrayInContactConstructor =
                     new  InstantiationException("Incorrect array length in "
                     + "Contact constructor (" 
                     + contactFields.length + ")");
        }
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    @Override
    public String toString() {
        String str = "fname: " + fName
                + ", lName: " + lName
                + ", address: " + address
                + ", city: " + city
                + ", state: " + state
                + ", zipcode: " + zipcode
                + ", email: " + email
                + ", phoneNum: " + phoneNum;
        return str;
    }
    
}
