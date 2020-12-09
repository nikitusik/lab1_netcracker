package service;

import dao.GroupDao;
import model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }


    @Override
    public void create(Group group) {
        groupDao.create(group);
    }

    @Override
    public void delete(String number) {
        groupDao.delete(number);
    }

    @Override
    public void edit(int index, Group group) {
        groupDao.edit(index, group);
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
