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
@Table(name = "Persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="So_tai_khoan")
    private int id;
    private String name;
    private String address;
    private int mobilephone;
    private String cmnd;
    private double budget;
}
