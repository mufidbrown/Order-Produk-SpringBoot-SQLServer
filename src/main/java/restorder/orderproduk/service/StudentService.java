package restorder.orderproduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import restorder.orderproduk.dto.StudentRequest;
import restorder.orderproduk.exception.UserNotFoundException;
import restorder.orderproduk.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Student> getStudentById(int studentId) throws UserNotFoundException {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            return ResponseEntity.ok(student.get());
        }
        throw new UserNotFoundException("User not found with Id : "+ studentId);
    }

    public ResponseEntity<List<Student>> getStudentByName(String studentName) {
        try {
            List<Student> students = new ArrayList<Student>();

            if (studentName == null)
                students.addAll(studentRepository.findAll());
            else
                students.addAll(studentRepository.findByName(studentName));
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
