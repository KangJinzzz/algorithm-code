package kang.controller;

import kang.model.Student;
import kang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

//    @RequestMapping("/find")
//    public String add(String name, String id) {
//        if (name == null && id == null) {
//            return "find";
//        }
//        return "index";
//    }

    @RequestMapping("/find")
    public String find(Model model) {
        List<Student> students = studentService.selectAll();
        model.addAttribute("studentList", students);
        return "find";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        studentService.deleteByPrimaryKey(id);
        return "redirect:/find";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        Student student = studentService.selectByPrimaryKey(id);
        model.addAttribute("student", student);
        return "update";
    }

    @RequestMapping("/update/{id}/submit")
    public String updateSubmit(@PathVariable("id") int id, String name, String age, String sex, String address, String dormId) {
        if (name == null || age == null || sex == null || address == null || dormId == null) {
            return "redirect:/update/id";
        }
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(Integer.valueOf(age));
        student.setSex(sex);
        student.setAddress(address);
        student.setDormId(Integer.valueOf(dormId));
        studentService.updateByPrimaryKey(student);
        return "redirect:/find";
    }

    @RequestMapping(value = "/findName", method = RequestMethod.POST)
    public String findName(String name, Model model) {
        List<Student> students = studentService.selectByName(name);
        model.addAttribute("studentList", students);
        return "find";
    }

    @RequestMapping(value = "/findId", method = RequestMethod.POST)
    public String findId(String id, Model model) {
        List<Student> students = studentService.selectByPrimaryKey2(Integer.parseInt(id));
        model.addAttribute("studentList", students);
        return "find";
    }
}
