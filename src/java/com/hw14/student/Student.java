/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw14.student;

/**
 *
 * @author Rinjin
 */
public class Student {
    int id;
    String firstname;
    String lastname;
    double GPA;

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", GPA=" + GPA + ", AutoID=" + AutoID + '}';
    }
    int AutoID;

    public int getId() {
        return id;
    }

    public Student() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getAutoID() {
        return AutoID;
    }

    public void setAutoID(int AutoID) {
        this.AutoID = AutoID;
    }

    
}
