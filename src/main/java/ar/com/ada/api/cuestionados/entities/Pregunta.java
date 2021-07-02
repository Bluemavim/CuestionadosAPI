package ar.com.ada.api.cuestionados.entities;
import java.util.*;

import javax.persistence.*;

@Entity
@Table (name= "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pregunta_id")
    private Integer preguntaId;

    @Column(name = "enunciado")
    private String enunciado;

    @ManyToOne //join columns van donde esta FK
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    private Categoria categoria;

    private List<Respuesta> opciones = new ArrayList<>();


}
