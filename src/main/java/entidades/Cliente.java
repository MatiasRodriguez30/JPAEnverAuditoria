package entidades;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="cliente")
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Cliente implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Si quiero un nombre para personalizado para cada atributo @Column(name = "nombre")
    private String nombre;
    //Si quiero un nombre para personalizado para cada atributo @Column(name = "apellido")
    private String apellido;
    @Column(unique = true)
    private int dni;

    //Para crear la relacion ONE TO ONE
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    //Para la relacion One to many
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas = new ArrayList<Factura>();

    public Cliente(String nombre, String apellido, int dni){
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
    }

}
