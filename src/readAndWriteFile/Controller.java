package readAndWriteFile;

import java.io.*;
import java.util.*;

public class Controller {

    public void input() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter you ID:");
        String id = scanner.nextLine();

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your id group: ");
        int group = scanner.nextInt();

        Student student = new Student(id, name, group);

        if (checkFile()){
            List<Student> students = readFile();
            students.add(student);
            this.writeFile(students);
        }else {
            List<Student> students = new ArrayList<>();
            students.add(student);
            this.writeFile(students);
        }

    }

    public void output() throws IOException {
        for (Student student : readFile()){
            System.out.println(student.toString());
        }
    }

    private void writeFile(List<Student> students) throws IOException {
        FileOutputStream fos = new FileOutputStream("student.txt");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        for (Student student : students){
            out.writeObject(student);
        }
        out.flush();
        byte[] bytes = bos.toByteArray();
        fos.write(bytes);

        bos.close();
        System.out.println("Write successful");
    }

    private List<Student> readFile() throws IOException {
        List<Student> students = new ArrayList<>();
        FileInputStream fis = new FileInputStream("student.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        boolean cont = true;
        try {
            while (cont) {
                Object obj = ois.readObject();
                if (obj instanceof Student){
                    students.add((Student) obj);
                }
                else
                    cont = false;
            }
        } catch (Exception e) {
            //System.out.println(e.printStackTrace());
            ois.close();
        }
        return students;
    }

    private boolean checkFile(){
        File file = new File("student.txt");
        return !file.exists() || file.length() != 0;
    }
}
