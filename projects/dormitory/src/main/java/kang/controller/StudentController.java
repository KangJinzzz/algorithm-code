package kang.controller;

import kang.model.Student;
import kang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/add")
    public String add(String name, String age, String sex, String address, String dormId) {
        if (name == null || age == null || sex == null || address == null || dormId == null) {
            return "add";
        }
        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.valueOf(age));
        student.setSex(sex);
        student.setAddress(address);
        student.setDormId(Integer.valueOf(dormId));
        studentService.insert(student);
        return "index";
    }

    @RequestMapping("/find")
    public String add(String name, String id) {
        if (name == null && id == null) {
            return "find";
        }
        return "index";
    }
}
