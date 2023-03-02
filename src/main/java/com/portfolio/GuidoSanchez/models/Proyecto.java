
package com.portfolio.GuidoSanchez.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
/**
Clase para representar la Entidad Prpyectos la cual almacena los datos de los proyectos realizados por el dev
 */
@Entity
@Getter
@Setter
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String url_proyecto;
    private String descripcion;
    private String url_miniatura;
    private String fecha_creacion;
}
