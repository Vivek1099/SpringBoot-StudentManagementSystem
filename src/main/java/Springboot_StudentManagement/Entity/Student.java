package Springboot_StudentManagement.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student ID", unique = true, nullable = false)
    int sid;

    @Column(name = "Student_FirstName", nullable = false)
    @NotEmpty(message = "Please Enter Your First Name....cannot be empty")
    String fname;

    @Column(name = "Student_LastName", nullable = false)
    @NotEmpty(message = "Please Enter Your Last Name....cannot be empty")
    String lname;

    @Column(name = "Student_DateofBirth", nullable = false)
    @NotNull(message = "Please Enter Your Date of Birth (yyyy-mm-dd)")
    LocalDate dateofbirth;

    @Column(name = "Student_ExamRollNo", unique = true, nullable = false)
    @NotNull(message = "Please Enter your Exam Roll Number...")
    long examrollno;

    @Column(name = "Student_Address", nullable = false)
    @NotEmpty(message = "Please Enter Your Address...")
    String address;

    @Column(name = "Student_Course", nullable = false)
    @NotEmpty(message = "Please Enter Your Course...")
    String course;

    @Column(name = "Student_Email", nullable = false)
    @Email(message = "Please Enter Valid Email...." )
    String email;

    @Column(name = "Student_PhoneNo", unique = true, nullable = false)
    @NotNull(message = "Please Enter your Phone Number...")
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Please Enter Valid Phone Number")
    String phoneno;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public @NotEmpty(message = "Please Enter Your First Name....cannot be empty") String getFname() {
        return fname;
    }

    public void setFname(@NotEmpty(message = "Please Enter Your First Name....cannot be empty") String fname) {
        this.fname = fname;
    }

    public @NotEmpty(message = "Please Enter Your Last Name....cannot be empty") String getLname() {
        return lname;
    }

    public void setLname(@NotEmpty(message = "Please Enter Your Last Name....cannot be empty") String lname) {
        this.lname = lname;
    }

    public @NotNull(message = "Please Enter Your Date of Birth (yyyy-mm-dd)") LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(@NotNull(message = "Please Enter Your Date of Birth (yyyy-mm-dd)") LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    @NotNull(message = "Please Enter your Exam Roll Number...")
    public long getExamrollno() {
        return examrollno;
    }

    public void setExamrollno(@NotNull(message = "Please Enter your Exam Roll Number...") long examrollno) {
        this.examrollno = examrollno;
    }

    public @NotEmpty(message = "Please Enter Your Address...") String getAddress() {
        return address;
    }

    public void setAddress(@NotEmpty(message = "Please Enter Your Address...") String address) {
        this.address = address;
    }

    public @NotEmpty(message = "Please Enter Your Course...") String getCourse() {
        return course;
    }

    public void setCourse(@NotEmpty(message = "Please Enter Your Course...") String course) {
        this.course = course;
    }

    public @Email(message = "Please Enter Valid Email....") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Please Enter Valid Email....") String email) {
        this.email = email;
    }

    public @NotNull(message = "Please Enter your Phone Number...") @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Please Enter Valid Phone Number") String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(@NotNull(message = "Please Enter your Phone Number...") @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Please Enter Valid Phone Number") String phoneno) {
        this.phoneno = phoneno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", examrollno=" + examrollno +
                ", address='" + address + '\'' +
                ", course='" + course + '\'' +
                ", email='" + email + '\'' +
                ", phoneno='" + phoneno + '\'' +
                '}';
    }
}
