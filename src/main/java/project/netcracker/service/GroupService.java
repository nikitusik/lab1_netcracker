package project.netcracker.service;

import project.netcracker.model.Group;

import java.util.List;

public interface GroupService {
    void create(Group group);
    void delete(String number);
    void edit(int index, Group group);
    Group getById(int id);
    List<Group> getAll();
}
