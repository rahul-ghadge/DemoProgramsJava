package com.demo.program.hashequals;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeHashCode {

    private String name;
    private String surname;
    private int sal;

    public EmployeeHashCode(String name, String surname, int sal) {
        this.name = name;
        this.surname = surname;
        this.sal = sal;
    }

    public static void main(String args[]) {

        Map<EmployeeHashCode, String> map = new HashMap<>();

        EmployeeHashCode eh = new EmployeeHashCode("abc", "abc", 500);
        map.put(eh, "First");

        eh = new EmployeeHashCode("mno", "mno", 200);
        map.put(eh, "Second");

        eh = new EmployeeHashCode("xyz", "xyz", 100);
        map.put(eh, "Third");


        eh = new EmployeeHashCode("pqr", "pqr", 300);
        map.put(eh, "Forth");


        eh = new EmployeeHashCode("pqr", "surname", 300);
        map.put(eh, "Fifth");


        for (Map.Entry<EmployeeHashCode, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().getSurname() + " : " + entry.getValue());
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof EmployeeHashCode))
            return false;
        EmployeeHashCode that = (EmployeeHashCode) o;
        return Objects.equals(getSurname(), that.getSurname());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSurname());
    }
}
