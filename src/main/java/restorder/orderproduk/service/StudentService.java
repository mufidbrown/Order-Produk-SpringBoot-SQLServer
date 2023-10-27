package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import restorder.orderproduk.dto.StudentRequest;
import restorder.orderproduk.entity.Student;
import restorder.orderproduk.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<Student> saveStudent(StudentRequest studentRequest) {
        try {
            Student student1 = Student.build(0, studentRequest.getName(), studentRequest.getAge(),
                    studentRequest.getAddress(), studentRequest.getEmail());
            return new ResponseEntity<>(studentRepository.save(student1), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Student>> getAllstudents() {
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }




}
