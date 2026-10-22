package model;

public class Student {
    private String name;
    private int rollNo;
    private String issueDate;

    public Student(String name, int rollNo, String issueDate) {
        this.name = name;
        this.rollNo = rollNo;
        this.issueDate = issueDate;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getIssueDate() {
        return issueDate;
    }

    @Override
    public String toString() {
        return name + " (Roll No: " + rollNo + ") on " + issueDate;
    }
}
