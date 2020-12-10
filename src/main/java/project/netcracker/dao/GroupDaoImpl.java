package project.netcracker.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.netcracker.model.Group;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDaoImpl implements GroupDao {
    private final ObservableList<Group> groups = FXCollections.observableArrayList();

    //private final List<Group> groups = new ArrayList<>();

    @Override
    public void create(Group group) {
        boolean isExist = false;
        for (Group i : groups) {
            if (i.getNumber().equals(group.getNumber())) {
                isExist = true;
                break;
            }
        }
        if (!isExist)
            groups.add(group);
    }

    @Override
    public void delete(String number) {
        groups.removeIf(group -> group.getNumber().equals(number));
    }

    @Override
    public void edit(int index, Group group) {
        groups.set(index, group);
    }

    @Override
    public Group getById(int id) {
        return groups.get(id);
    }

    @Override
    public Group getByNumber(String number) {
        for (Group group : groups) {
            if (group.getNumber().equals(number))
                return group;
        }
        return null;
    }

    @Override
    public List<Group> getAll() {
        return groups;
    }
}
