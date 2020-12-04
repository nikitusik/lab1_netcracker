package dao;

import model.Group;

import java.util.List;

public interface GroupDao {
    void create(Group group);
    void delete(int id);
    void edit(Group group);
    Group getById(int id);
    List<Group> getAll();
}
