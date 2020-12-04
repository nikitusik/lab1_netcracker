package service;

import dao.StudentDao;
import model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao;

    @Override
    public void create(Student student) {
        studentDao.create(student);
    }

    @Override
    public void delete(Student student) {
        studentDao.delete(student);
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
