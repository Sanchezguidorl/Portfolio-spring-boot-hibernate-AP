
package com.portfolio.GuidoSanchez.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
Clase para representar la Entidad Estudios la cual almacena los datos de cursos realizados por el dev
 */
@Getter @Setter
@Entity

public class Estudio {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre_institucion;
    private String nombre_curso;
    private String url_logo;
    private String fecha_inicio;
    private String estado_cursado;
}
