package project.netcracker.service;

import project.netcracker.model.Group;

import java.io.IOException;
import java.util.List;

public interface GroupService {
    void create(Group group) throws IOException;
    void delete(Group group) throws IOException;
    void edit(int index, Group group) throws IOException;
    Group getById(int id);
    List<Group> getAll() throws IOException;
}
