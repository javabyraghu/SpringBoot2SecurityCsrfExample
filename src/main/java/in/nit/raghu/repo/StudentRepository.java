package in.nit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.raghu.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
