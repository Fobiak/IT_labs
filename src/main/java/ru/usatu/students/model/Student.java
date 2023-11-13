package ru.usatu.students.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

// класс, описывающий данные
@Entity
@Table(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @Id
    @XmlElement(name = "id")
    private int id; //объявление данных

    @Column(name = "name")
    @XmlElement(name = "name")
    private String name;

    public Student() {
    }

    public Student(int id, String name){ //конструктор, принимающий id и name
        this.id = id;
        this.name = name;
    }

    public int getId() {return id; } //геттер, который возвращает аргумент id
    public void setId(int id) { this.id = id; } //сеттер, к которому можно обратиться
    public String getName() {return name; } //метод, возвращает имя студента
    public void setName(String name) {this.name = name; } //устанавливает имя студента

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id);}
}
