package org.src.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.src.entity.Student;

@Repository
public interface UserRepository extends JpaRepository<Student, Long> {

}
