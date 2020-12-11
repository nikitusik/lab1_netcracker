package project.netcracker.dao;

import project.netcracker.model.Group;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface GroupDao {
    void create(Group group) throws IOException;
    void delete(Group group) throws IOException;
    void edit(int index, Group group) throws IOException;
    Group getById(int id);
    Group getByNumber(String number);
    List<Group> getAll() throws IOException;
}
