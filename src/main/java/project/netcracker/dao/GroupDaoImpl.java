package project.netcracker.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.netcracker.model.Group;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class GroupDaoImpl implements GroupDao {

    private final static String groupFile = "group.json";

    private final ObservableList<Group> groups = FXCollections.observableArrayList();

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Group>>(){});
    private final ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());


    public GroupDaoImpl() throws IOException {
    }


    @Override
    public void create(Group group) throws IOException {
        groups.add(group);
        saveGroup();
    }

    @Override
    public void delete(Group group) throws IOException {
        groups.remove(group);
        saveGroup();
    }

    @Override
    public void edit(int index, Group group) throws IOException {
        groups.set(index, group);
        saveGroup();
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
    public List<Group> getAll() throws IOException {
        loadGroup();
        return groups;
    }

    public void loadGroup() throws IOException {
        List<Group> tempList = objectReader.readValue(new File(groupFile));
        groups.setAll(tempList);
    }

    public void saveGroup() throws IOException {
        objectWriter.writeValue(new File(groupFile), groups);
    }
}
