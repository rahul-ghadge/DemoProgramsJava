package com.demo.program.hashequals;

import java.util.Objects;

public class EmpHashAndEquals {


    private int empId;
    private String empName;
    private String department;
    private double salary;


    public int getEmpId() {
        return empId;
    }



    public String getEmpName() {
        return empName;
    }


    public String getDepartment() {
        return department;
    }



    public double getSalary() {
        return salary;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof EmpHashAndEquals)) return false;

        EmpHashAndEquals that = (EmpHashAndEquals) o;

        return getEmpId() == that.getEmpId() &&
                Double.compare(that.getSalary(), getSalary()) == 0 &&
                Objects.equals(getEmpName(), that.getEmpName()) &&
                Objects.equals(getDepartment(), that.getDepartment());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmpId(), getEmpName(), getDepartment(), getSalary());
    }
}
