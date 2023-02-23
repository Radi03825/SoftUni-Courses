package entries3;

import javax.persistence.*;
import javax.swing.*;
import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private String address;
    private String email;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    private ImageIcon picture;

    @Column(nullable = false, name = "medical_insurance")
    private boolean hasMedicalInsurance;
}
