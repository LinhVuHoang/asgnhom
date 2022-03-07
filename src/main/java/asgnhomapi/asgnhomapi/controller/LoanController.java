package asgnhomapi.asgnhomapi.controller;

import asgnhomapi.asgnhomapi.entity.Loan;
import asgnhomapi.asgnhomapi.entity.Person;
import asgnhomapi.asgnhomapi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/loans")
public class LoanController {
    @Autowired
    LoanRepository loanRepository;
    //create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Loan loan){
        loanRepository.save(loan);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }
    //findall
    @RequestMapping(method = RequestMethod.GET)
    public  ResponseEntity<Object> getList(){
        ArrayList<Loan> response = new ArrayList<>();
        response.addAll(loanRepository.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    //findby so tai khoan
    @RequestMapping(method = RequestMethod.GET,path = "list/{id}")
    public  ResponseEntity<Object> getListbystk(@PathVariable int id){
        ArrayList<Loan> response = new ArrayList<>();
        response.addAll(loanRepository.findAllByPersonId(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//update
@RequestMapping(method = RequestMethod.PUT, path = "{id}")
public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Loan updateloan) {
    Optional<Loan> loan = loanRepository.findById(id);
    if (loan.isPresent()) {
        Loan loan1 = loan.get();
        loan1.setLoanamount(updateloan.getLoanamount());
        loan1.setPeriodmonth(updateloan.getPeriodmonth());
        loan1.setRate(updateloan.getRate());
        loan1.setStatus(updateloan.getStatus());
        loanRepository.save(loan1);
        return new ResponseEntity<>(loan1,HttpStatus.OK);
    } else {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
//delete
@RequestMapping(method = RequestMethod.DELETE  , path = "{id}")
public ResponseEntity<Object> delete(@PathVariable int id){
    Optional<Loan> loan = loanRepository.findById(id);
    if(loan.isPresent()){
        loanRepository.delete(loan.get());
        return new ResponseEntity<>(loan,HttpStatus.OK);
    }else {
        return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}

}
