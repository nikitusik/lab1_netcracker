package service;

import dao.GroupDao;
import model.Group;

import java.util.List;

public class GroupServiceImpl implements GroupService{
    private GroupDao groupDao;

    @Override
    public void create(Group group) {
        groupDao.create(group);
    }

    @Override
    public void delete(Group group) {
        groupDao.delete(group);
    }

    @Override
    public void edit(Group group) {
        groupDao.edit(group);
    }

    @Override
    public Group getById(int id) {
        return groupDao.getById(id);
    }

    @Override
    public List<Group> getAll() {
        return groupDao.getAll();
    }
}
