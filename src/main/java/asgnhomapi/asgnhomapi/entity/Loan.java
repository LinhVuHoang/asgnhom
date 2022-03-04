package asgnhomapi.asgnhomapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "So_tien_vay")
    private double loanamount;
    @Column(name="So_ngay_gui")
    private int perioddate;
    @Column(name="So_thang_gui")
    private int periodmonth;
    @Column(name="Ty_le_lai_suat")
    private float rate;
    @Column(name="Trang_thai")
    private int status;
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Person person;
}
