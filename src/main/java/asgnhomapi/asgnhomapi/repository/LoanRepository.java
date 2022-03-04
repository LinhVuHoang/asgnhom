package asgnhomapi.asgnhomapi.repository;

import asgnhomapi.asgnhomapi.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Integer> {
    List<Loan> findAllByPersonId(int id);
}
