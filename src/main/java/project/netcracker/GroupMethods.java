package project.netcracker;

import project.netcracker.model.Group;

public interface GroupMethods {

    void createGroup();

    void updateGroup();

    void deleteGroup();

    Group getGroupByNumber(int ID);

}
