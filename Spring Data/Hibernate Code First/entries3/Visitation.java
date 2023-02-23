package entries3;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private Date date;
    private String comment;
}
