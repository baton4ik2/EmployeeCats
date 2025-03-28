package ru.akbirov.employeecats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.akbirov.employeecats.entity.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
