package dao;

import model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GroupDaoImpl implements Dao<Group>{
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static final Map<Integer, Group> groups = new HashMap<>();
    public void create(Group group) {
        group.setId(AUTO_ID.getAndIncrement());
        groups.put(group.getId(), group);
    }

    public void delete(Group group) {
        groups.remove(group.getId());
    }

    public void edit(Group group) {
        groups.put(group.getId(), group);
    }

    public Group getById(int id) {
        return groups.get(id);
    }

    public List<Group> getAll() {
        return new ArrayList<>(groups.values());
    }
}
