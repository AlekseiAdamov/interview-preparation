package ru.alexeiadamov.hibernate;

import java.util.Date;

public class HibernateDemo {
    public static void main(String[] args) {
        final Storage storage = Storage.createStorage();
        for (int i = 1; i <= 10; i++) {
            final Student student = new Student();
            storage.create(student);

            student.setName("student" + i);
            student.setBirthDate(new Date());
            storage.update(student);

            final Student storedStudent = (Student) storage.find(Student.class, i);
            if (storedStudent != null) {
                System.out.printf("%d: %s\n", i, storedStudent);
            }
        }
    }
}
