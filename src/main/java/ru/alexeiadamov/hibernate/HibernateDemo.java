package ru.alexeiadamov.hibernate;

import java.util.Date;

public class HibernateDemo {
    public static void main(String[] args) {
        final Storage storage = Storage.createStorage();
        for (int i = 1; i <= 1000; i++) {
            final Student student = new Student("student" + i);
            storage.create(student);

            student.setBirthDate(new Date());
            storage.update(student);

            final Student storedStudent = (Student) storage.find(Student.class, i);
            if (storedStudent != null) {
                System.out.printf("%d: %s\n", i, storedStudent);
            }
        }
        storage.findAll(Student.class).forEach(System.out::println);
        storage.close();
    }
}
