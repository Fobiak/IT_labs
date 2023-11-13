package ru.usatu.students.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.usatu.students.model.Student;
import ru.usatu.students.service.StudentService;


import java.util.List;

@CrossOrigin
@RestController //объявляет класс как контроллер RestApi - обрабатывать http запросы и возвращать рез-ты в формате json
@RequestMapping("/students") //Эта аннотация определяет базовый URL-путь для обработчиков запросов внутри этого контроллера.
//например, /students, /students/{id}
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) { this.studentService = studentService; } //класс зависит от интерфейса StudentService

    // Обработчик HTTP-запроса GET для получения списка студентов
    @GetMapping
    public @ResponseBody //в Spring Framework указывает, что возвращаемое значение метода контроллера должно быть преобразовано в тело ответа HTTP
    List<Student> getStudents() throws Exception {return studentService.getStudents(); } //List<Student> getStudents() { return studentService.getStudents(); }

    // Обработчик HTTP-запроса GET для получения информации о конкретном студенте по его ид
    @GetMapping("/{id}")
    public @ResponseBody
    Student getStudent(@PathVariable int id) throws Exception { return studentService.getStudent(id); }

    // Обработчик HTTP-запроса POST для добавления нового студента
    @PostMapping
    public @ResponseBody
    Student addStudent(@RequestBody Student student) throws Exception { return studentService.addStudent(student); }

    // Обработчик HTTP-запроса PUT для редактирования имени студента по его ид
    @PutMapping("/{id}")
    public @ResponseBody
    Student editStudent(@PathVariable int id, @RequestBody String name) throws Exception { return studentService.editStudent(id, name); }


    // Обработчик HTTP-запроса DELETE для удаления студента по его ид
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable int id) throws Exception { studentService.deleteStudent(id); }

}