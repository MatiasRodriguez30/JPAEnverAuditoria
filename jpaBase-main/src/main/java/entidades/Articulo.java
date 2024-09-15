package entidades;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name="articulo")
@NoArgsConstructor
@Audited
public class Articulo implements Serializable {
    private static final long seriaVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private String denominacion;
    private int precio;

    //Para la relacion One to many
    @OneToMany(mappedBy = "articulo")
    @NotAudited
    private List<DetalleFac> detallefac = new ArrayList<DetalleFac>();

    //Para Many to many
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="ArticuloCategoria"
            ,joinColumns= @JoinColumn(name = "articulo_id")
            , inverseJoinColumns = @JoinColumn(name="categoria_id"))
    private List<Categoria> categoria= new ArrayList<>();


    public Articulo(int cantidad, String denominacion, int precio){
        this.cantidad=cantidad;
        this.denominacion=denominacion;
        this.precio=precio;
    }
}
