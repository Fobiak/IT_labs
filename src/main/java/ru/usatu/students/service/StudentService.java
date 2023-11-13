package ru.usatu.students.service;

import ru.usatu.students.model.Student;

import java.util.List;

//объявляем интерфейс, чтобы избавиться от зависимости в классе StudentController с классом StudentService
public interface StudentService {

    List<Student> getStudents() throws Exception;

    Student getStudent(int id) throws Exception;

    Student addStudent(Student student) throws Exception;

    Student editStudent (int id, String name) throws Exception;

    void deleteStudent(int id) throws Exception;
}
