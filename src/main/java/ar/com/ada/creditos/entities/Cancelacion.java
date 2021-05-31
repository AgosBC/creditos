package ar.com.ada.creditos.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "cancelacion") 
public class Cancelacion {

    @Id
    @Column(name = "cancelacion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cancelacionId;

    @Column(name = "fecha_cancelacion")
    private Date fecahaCancelacion;

    private BigDecimal importe;

    private int cuota;

    @JoinColumn(name = "prestamo_id", referencedColumnName = "prestamo_id")
    Prestamo prestamo;

    

    

    
}
