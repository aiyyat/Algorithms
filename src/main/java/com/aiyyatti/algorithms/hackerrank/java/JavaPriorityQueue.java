package com.aiyyatti.algorithms.hackerrank;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

public class JavaPriorityQueue {
    @Test
    public void test() {
        String str = "12\n" +
                "ENTER John 3.75 50\n" +
                "ENTER Mark 3.8 24\n" +
                "ENTER Shafaet 3.7 35\n" +
                "SERVED\n" +
                "SERVED\n" +
                "ENTER Samiha 3.85 36\n" +
                "SERVED\n" +
                "ENTER Ashley 3.9 42\n" +
                "ENTER Maria 3.6 46\n" +
                "ENTER Anik 3.95 49\n" +
                "ENTER Dan 3.95 50\n" +
                "SERVED";
        doJavaPriorityQueue(new ByteArrayInputStream(str.getBytes()));
    }

    private final static Priorities priorities = new Priorities();

    public void doJavaPriorityQueue(InputStream is) {
        Scanner scan = new Scanner(is);
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }

    static class Priorities {
        Queue<Student> students = new PriorityQueue<Student>();

        List<Student> getStudents(List<String> events) {
            for (String event : events) {
                if (event.equals("SERVED")) students.poll();
                else {
                    String[] parts = event.split(" ");
                    Student student = new Student(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]));
                    students.add(student);
                }
            }
            List<Student> list = new ArrayList<>();
            while (!students.isEmpty())
                list.add(students.poll());
            return list;
        }
    }

    static class Student implements Comparable<Student> {
        String name;
        Double mark;
        Integer roll;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", mark=" + mark +
                    ", roll=" + roll +
                    '}';
        }

        @Override
        public int compareTo(Student student) {
            int dmark = -1 * mark.compareTo(student.mark);
            if (0 != dmark) return dmark;
            int dname = this.name.compareTo(student.name);
            if (0 != dname) return dname;
            return roll.compareTo(student.roll);
        }

        public Student(String name, Double mark, Integer roll) {
            this.name = name;
            this.mark = mark;
            this.roll = roll;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
