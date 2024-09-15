package entidades;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="detalleFac")
@Data
@NoArgsConstructor
@Audited

public class DetalleFac implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private int subtotal;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_factura")
    private Factura factura;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="fk_articulo")
    private Articulo articulo;

    public DetalleFac(int cantidad, int subtotal){
        this.cantidad=cantidad;
        this.subtotal=subtotal;
    }
}
