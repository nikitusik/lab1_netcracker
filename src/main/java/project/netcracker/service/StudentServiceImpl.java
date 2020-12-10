package project.netcracker.service;

import project.netcracker.dao.StudentDao;
import project.netcracker.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void create(Student student) {
        studentDao.create(student);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Override
    public void edit(Student student) {
        studentDao.edit(student);
    }

    @Override
    public Student getById(int id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }
}
