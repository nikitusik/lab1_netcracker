package project.netcracker.dao;

import project.netcracker.model.Group;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupDao {
    void create(Group group);
    void delete(String number);
    void edit(int index, Group group);
    Group getById(int id);
    Group getByNumber(String number);
    List<Group> getAll();
}
