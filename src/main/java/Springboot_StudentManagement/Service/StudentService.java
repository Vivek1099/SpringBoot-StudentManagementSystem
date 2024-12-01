package Springboot_StudentManagement.Service;

import Springboot_StudentManagement.Entity.Student;
import Springboot_StudentManagement.Exception.ExamRollNotFoundException;
import Springboot_StudentManagement.Exception.IdNotFoundException;
import Springboot_StudentManagement.Exception.NameNotFoundException;
import Springboot_StudentManagement.Exception.PhoneNumberNotFoundException;
import Springboot_StudentManagement.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper mapper;

    public String getTest()
    {
        return "Student Management test";
    }

    public Student InsertStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> GetAllStudents()
    {
        return studentRepository.findAll();
    }

    public Optional<Student> GetStudentbyId(@PathVariable int sid) throws Exception
    {
        Optional<Student> s = studentRepository.findById(sid);
        if(s.isEmpty())
        {
            throw new IdNotFoundException();
        }
        return s;
    }

    public String DeleteStudent(@PathVariable int sid)
    {
        studentRepository.deleteById(sid);
        return "Student data deleted";
    }

    public Student UpdateStudentbyId(@RequestBody Student student, @PathVariable int sid)
    {
        Student s = studentRepository.findById(sid).get();
        s.setFname(student.getFname());
        s.setLname(student.getLname());
        s.setAddress(student.getAddress());
        s.setCourse(student.getCourse());
        s.setEmail(student.getEmail());
        s.setDateofbirth(student.getDateofbirth());
        s.setExamrollno(student.getExamrollno());
        s.setPhoneno(student.getPhoneno());
        mapper.map(s,student);
        return student;
    }

    public List<Student> getStudentByExamRoll(@PathVariable long examrollno) throws Exception
    {
        List<Student> s = studentRepository.findByexamrollno(examrollno);
        if(s.isEmpty())
        {
            throw new ExamRollNotFoundException();
        }
        return s;
    }

    public List<Student> getStudentByfnameAndlname(@PathVariable String fname, @PathVariable String lname) throws Exception
    {
        List<Student> s = studentRepository.getByFnameAndLname(fname, lname);
        if(s.isEmpty())
        {
            throw new NameNotFoundException();
        }
        return s;
    }

    public List<Student> getByStudentPhoneno(@PathVariable String phoneno) throws Exception
    {
        List<Student> s = studentRepository.getByPhoneno(phoneno);
        if(s.isEmpty())
        {
            throw new PhoneNumberNotFoundException();
        }
        return s;
    }
}
