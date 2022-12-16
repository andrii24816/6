
package org.example.lab1;

import java.util.Objects;
import java.util.Set;


import jakarta.validation.*;
import jakarta.validation.constraints.Size;

public class people  implements Comparable<people> {

    @Size(min = 2)
    public
    String name;
    long phoneNumber;
    int exp;
    long codeP;

    @Override
    public int compareTo(people anotherPeople)
    {
        return this.exp -anotherPeople.exp;
    }
    public  String GetName() {
        return name;
    }
    public void SetName(String Name) {
        this.name = name;
    }


    public long getCodeP() {
        return codeP;
    }

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int Exp) {
        this.exp = exp;
    }

    @Override
    public String toString(){
        return "Info{ " +
                "Name - " + name+ " |" +
                "CodeP - " + codeP + " |" +
                "Phone PhoneNumber +" + phoneNumber + " |" +
                "Lease Term " + exp + "mounth |" +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        people people = (people) o;
        return Objects.equals(name, people.name) && Objects.equals(codeP, people.codeP) && Objects.equals(phoneNumber, people.phoneNumber);
    }
    @Override
    public int hashCode() { return Objects.hash( codeP, name, phoneNumber, exp); }

    people(String Name1)
    {
        name = Name1;
        phoneNumber= 3806676;
        exp=36;
        codeP=9529;
    }

    people()
    {
    }

    public people(String name1, int phoneNumber1, int exp1, int codeP1)
    {   name = name1;
        phoneNumber= phoneNumber1;
        exp=exp1;
        codeP=codeP1;
    }

    public static class Builder{
        private people newPeople;

        public Builder(){ newPeople = new people(); }

        public Builder(String name1)
        { newPeople = new people();
            newPeople.name = name1;
            newPeople.phoneNumber= 3806676;
            newPeople.exp=35;
            newPeople.codeP=9529;
        }

        public Builder(String name, int phoneNumber, int exp, int codeP)
        { newPeople = new people();
            newPeople.name = name;
            newPeople.phoneNumber= phoneNumber;
            newPeople.exp=exp;
            newPeople.codeP=codeP;
        }
        public people.Builder withName(String name){
            newPeople.name = name;
            return this;
        }

        public people.Builder withPhoneNumber(long phoneNumber){
            newPeople.phoneNumber = phoneNumber;
            return this;
        }

        public people.Builder withCodeP(long codeP){
            newPeople.codeP = codeP;
            return this;
        }

        public people.Builder withExp(int exp){
            newPeople.exp = exp;
            return this;
        }


        public people build()
        {var res = validate(newPeople);
            return newPeople; }
    }

    public static people validate(people obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<people>> violations = validator.validate(obj);
        if (violations.isEmpty()) {
            return obj;
        } else {
            StringBuilder sb = new StringBuilder();
            for (var violation : violations) {
                sb.append(violation.getInvalidValue()).append(" : ").append(violation.getMessage());
            }
            return null;
        }
    }
}


