package entidades;
import jdk.jfr.Enabled;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="categoria")
@NoArgsConstructor
@Audited
public class Categoria implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

    @ManyToMany(mappedBy = "categoria")
    private List<Articulo> articulo = new ArrayList<Articulo>();
    public Categoria(String denominacion){
        this.denominacion=denominacion;
    }
}
