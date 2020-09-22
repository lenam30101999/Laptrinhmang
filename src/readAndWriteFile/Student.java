package readAndWriteFile;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -8501383434011302991L;
    private String id;
    private String name;
    private int groupId;

    public Student() {
    }

    public Student(String id, String name, int groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "id= " + id + ", name= " + name + ", groupId= " + groupId ;
    }
}
