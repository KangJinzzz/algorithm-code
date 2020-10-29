package kang.service;

import kang.mapper.StudentMapper;
import kang.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    public int deleteByPrimaryKey(int id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    public Student selectByPrimaryKey(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }
}
