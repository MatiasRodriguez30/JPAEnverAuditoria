package entidades;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="factura")
@NoArgsConstructor
@Audited
public class Factura implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private int numero;
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)//Se usa persist para que cuando se borre una factura no se lleve al cliente
    @JoinColumn(name="fk_cliente")
    private Cliente cliente;

    //Para una relacion Unidireccional
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<DetalleFac> detallesfac = new ArrayList<DetalleFac>();
    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFac> detallesfac = new ArrayList<DetalleFac>();
    public Factura(String fecha, int numero, int total){
        this.fecha=fecha;
        this.numero=numero;
        this.total=total;
    }
}
