package dao;

import model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GroupDaoImpl implements GroupDao{
    private static final List<Group> groups = new ArrayList<>();
    public void create(Group group) {
        groups.add(group);
    }

    public void delete(Group group) {
        groups.remove(group.getId());
    }

    public void edit(Group group) {
        groups.add(group.getId(), group);
    }

    public Group getById(int id) {
        return groups.get(id);
    }

    public List<Group> getAll() {
        return groups;
    }
}
