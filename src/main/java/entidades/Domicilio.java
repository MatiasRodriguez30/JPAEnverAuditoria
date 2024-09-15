package entidades;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name="domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Domicilio implements Serializable {
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCalle;
    private int numero;
    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;
    public Domicilio(String nombreCalle, int numero){
        this.nombreCalle=nombreCalle;
        this.numero=numero;
    }
}
