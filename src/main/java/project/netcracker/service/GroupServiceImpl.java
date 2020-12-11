package project.netcracker.service;

import project.netcracker.dao.GroupDao;
import project.netcracker.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }


    @Override
    public void create(Group group) throws IOException {
        groupDao.create(group);
    }

    @Override
    public void delete(Group group) throws IOException {
        groupDao.delete(group);
    }

    @Override
    public void edit(int index, Group group) throws IOException {
        groupDao.edit(index, group);
    }

    @Override
    public Group getById(int id) {
        return groupDao.getById(id);
    }

    @Override
    public List<Group> getAll() throws IOException {
        return groupDao.getAll();
    }
}
