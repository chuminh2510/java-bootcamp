package com.minhcv.stream_ex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApp {
    public static void main(String[] args) throws Exception {
        Group gp = new Group();
        Student studentA = new Student("StudentA", 10);
        Student studentB = new Student("StudentB", 20);
        gp.students.add(studentA);
        gp.students.add(studentB);

        //https://www.baeldung.com/object-to-byte-array
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(studentA);
            byte[] data = bos.toByteArray();

            try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                Student deserializedStudent = (Student) ois.readObject();
                System.out.println("StreamApp.main:: " + deserializedStudent);
            }
        }

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(gp);
            byte[] data = bos.toByteArray();

            try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                Group deserializedGroup = (Group) ois.readObject();
                System.out.println("StreamApp.main:: " + deserializedGroup);
            }
        }
    }

    public static class Group implements Serializable {
        public List<Student> students = new ArrayList<Student>();

        @Override
        public String toString() {
            return students.stream().map(Student::toString).collect(Collectors.joining(","));
        }
    }

    public static class Student implements Serializable {
        public String name;
        public int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{name=" + name + "}";
        }
    }

}
