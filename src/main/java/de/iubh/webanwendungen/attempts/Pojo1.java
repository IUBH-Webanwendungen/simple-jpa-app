package de.iubh.webanwendungen.attempts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pojo1 {

    public Pojo1() {}

    private String attr;

    @Id
    @GeneratedValue
    private int id;

    public void setAttr(String a) { this.attr = a; }
    public String getAttr() { return attr; }

    public void setId(int i) { this.id = i; }
    public int getId() { return id;}

}
