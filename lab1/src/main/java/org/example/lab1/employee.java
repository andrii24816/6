package org.example.lab1;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.validation.*;

public class employee extends people implements Serializable {

    private  String company;
    private  String position;
    private int salary;

    public employee(String name, String company1) {

        super(name);
        company = company1;
        position = "manager";
        salary = 12500;
    }

    public employee(String name, String company1,  String position1, int salary1) {
        super(name);
        company = company1;
        position = position1;
        salary = salary1;
    }

    public employee(String name, int number, int exp, int codeP, String company1,  String position1, int salary1) {

        super(name, number, exp, codeP);
        company = company1;
        position = position1;
        salary = salary1;
    }

    public String getCompany(){ return company; }

    public String toString(){

        return "Info{ " +
                "Name - " + this.getName()+ " |" +
                "CodeP - " + this.getCodeP() + " |" +
                "Phone Number +" + this.getPhoneNumber() + " |" +
                "Lease Term " + this.getExp() + "mounth |" +
                "Company name " + this.getCompany() + " |" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        employee people = (employee) o;
        return Objects.equals(getName(), people.getName()) && Objects.equals(getCodeP(), people.getCodeP()) && Objects.equals(getPhoneNumber(), people.getPhoneNumber())  && Objects.equals(salary, people.salary) && Objects.equals(company, people.company) &&  Objects.equals(position, people.position);
    }
    @Override
    public int hashCode() { return Objects.hash( codeP, name, phoneNumber, exp); }

    public String toStringFile() {
        return this.getName()+
                " " + this.getCodeP() + " " +
                this.getPhoneNumber() + " " +
                this.getExp() + " " +
                this.getCompany() + "\n";


    }
    public employee validate(employee obj) throws ValidationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<employee>> violations = validator.validate(obj);
        if (violations.isEmpty())
            return obj;
        StringBuilder sb=new StringBuilder("\n");
        for (var violation : violations) {
            sb.append("Invalid value : ").append(violation.getInvalidValue()).append(" " + violation.getMessage() + "\n");
        }
        throw new ValidationException(sb.toString());
    }
}
