package com.minhaz;

import java.io.Serializable;

public class Person implements Serializable {

    private String personalName;
    private String personalAge;
    private String personalNumber;

    public Person (String personalName, String personalAge, String personalNumber){
        this.personalName = personalName;
        this.personalAge = personalAge;
        this.personalNumber = personalNumber;

    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getPersonalAge() {
        return personalAge;
    }

    public void setPersonalAge(String personalAge) {
        this.personalAge = personalAge;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

}
