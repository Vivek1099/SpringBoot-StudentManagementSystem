package Springboot_StudentManagement.Controller;

import Springboot_StudentManagement.Entity.Student;
import Springboot_StudentManagement.Repository.StudentRepository;
import Springboot_StudentManagement.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    StudentService studentService;

    @GetMapping("/test")
    public String test()
    {
        return studentService.getTest();
    }

    @PostMapping("/save")
    public String save(@Valid @RequestBody Student student)
    {
        studentService.InsertStudent(student);
        return "Student Data Saved";
    }

    @GetMapping("/all")
    public List<Student> showall()
    {
        return studentService.GetAllStudents();
    }

    @GetMapping("/byid/{sid}")
    public Optional<Student> ById(@PathVariable int sid) throws Exception {
        return studentService.GetStudentbyId(sid);
    }

    @PatchMapping("/update/{sid}")
    public Student Update(@RequestBody Student student, @PathVariable int sid)
    {
        return studentService.UpdateStudentbyId(student, sid);
    }

    @DeleteMapping("/delete/{sid}")
    public String delete(@PathVariable int sid)
    {
        return studentService.DeleteStudent(sid);
    }

    @GetMapping("/byexamroll/{examrollno}")
    public List<Student> ByExamrollno(@PathVariable long examrollno) throws Exception {
        return studentService.getStudentByExamRoll(examrollno);
    }

    @GetMapping("/byfnameandlname/{fname}/{lname}")
    public List<Student> ByFnameandLname(@PathVariable String fname, @PathVariable String lname) throws Exception {
        return studentService.getStudentByfnameAndlname(fname, lname);
    }

    @GetMapping("/byphoneno/{phoneno}")
    public List<Student> ByPhoneno(@PathVariable String phoneno) throws Exception {
        return studentService.getByStudentPhoneno(phoneno);
    }

}
