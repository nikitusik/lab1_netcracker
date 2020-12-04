package service;

import model.Group;

import java.util.List;

public interface GroupService {
    void create(Group group);
    void delete(int id);
    void edit(Group group);
    Group getById(int id);
    List<Group> getAll();
}
