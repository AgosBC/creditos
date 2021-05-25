package ar.com.ada.creditos.entities;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "prestamo")
public class Prestamo {

    // aqui debe estar la foreign key de id cliente?

    @Id
    @Column(name = "prestamo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prestamoId;

    private BigDecimal importe;
    private int cuotas;

    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;

    @Column(name = "fecha_alta")
    private Date fechaAlta; 

    @ManyToOne // este tiene una relacion many to one (muchos prestamos a un cliente) 
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id") // es un join columns va donde va la FK
    Cliente cliente; 

    public Date getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public int getPrestamoId() {
        return prestamoId;
    }
    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public BigDecimal getImporte() {
        return importe;
    }
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getCuotas() {
        return cuotas;
    }
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }



    
}
