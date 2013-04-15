package lab2;

import Lab1WithContactObject.*;
import lab2.*;

public class Contact2 {
    
    private static final int CONSTRUCTOR_ARRAY_SIZE = 8;
    
    private String fName = null;
    private String lName = null;
    private String address = null;
    private String city = null;
    private String state = null;
    private String zipcode = null;
    private String email = null;
    private String phoneNum = null;
    
    public Contact2() {
        fName = null;
        lName = null;
        address = null;
        city = null;
        state = null;
        zipcode = null;
        email = null;
        phoneNum = null;
    }
    
    public Contact2(String[] contactFields) {
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
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.fName != null ? this.fName.hashCode() : 0);
        hash = 17 * hash + (this.lName != null ? this.lName.hashCode() : 0);
        hash = 17 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact2 other = (Contact2) obj;
        if ((this.fName == null) ? (other.fName != null) : !this.fName.equals(other.fName)) {
            return false;
        }
        if ((this.lName == null) ? (other.lName != null) : !this.lName.equals(other.lName)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
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
    
    public String toString(String delimiter) {
        String str = fName + delimiter
                + lName + delimiter
                + address + delimiter
                + city + delimiter
                + state + delimiter
                + zipcode + delimiter
                + email + delimiter
                + phoneNum;
        return str;
    }
    
}
