package kang.service;

import kang.mapper.StudentMapper;
import kang.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public int insert(Student student) {
        return studentMapper.insert(student);
    }
}
