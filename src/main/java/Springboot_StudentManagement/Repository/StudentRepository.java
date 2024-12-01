package Springboot_StudentManagement.Repository;

import Springboot_StudentManagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
    List<Student> findByexamrollno(long examrollno);

    @Query("from student s where s.fname=?1 and s.lname=?2")
    List<Student> getByFnameAndLname(String fname, String lname);

    @Query("from student s where s.phoneno=?1")
    List<Student> getByPhoneno(String phoneno);
}
