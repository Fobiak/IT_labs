package ru.usatu.students.service;

import org.springframework.stereotype.Service;
import ru.usatu.students.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //аннотация для определения класса как сервисного
public class StudentServiceCollection implements StudentService { //класс реализует интерфейс StudentService

    private List<Student> students = new ArrayList<>(); //добавляем пустой список, для хранения объектов

    public StudentServiceCollection() { //конструктор, добавляет данные в список, который был объявлен выше
        students.add(new Student(1,"Ivan"));
        students.add(new Student(2,"Ivan2"));
        students.add(new Student(3, "Ivan3"));
    }

    public List<Student> getStudents() {return students; } //метод, который возвращает список всех студентов

    public Student getStudent(int id) { //метод, который возвращает инфорацию о студенте, по его идентификатору
        return students.stream().filter(student -> student.getId() == id).findFirst()
                .orElse(new Student());
    }
    public Student addStudent(Student student) { //метод, для добавления студнта в список
        students.add(student);
        return student;
    }
    public Student editStudent(int id, String name) { //метод, для изменения имени студента по его идентификатору
        return students.stream().filter(student -> student.getId() == id).findFirst()
                .map(student -> {
                    student.setName(name);
                    return student;
                }).orElse(new Student());
    }
    public void deleteStudent(int id) { //метод, для удаления студента по его id
        students = students.stream().filter(student -> student.getId() != id)
                .collect(Collectors.toList());
    }
}
