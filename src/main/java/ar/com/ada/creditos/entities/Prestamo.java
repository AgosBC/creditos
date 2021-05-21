package ar.com.ada.creditos.entities;
import javax.persistence.*;
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

    private double importe;
    private int cuotas;

    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;

    @Column(name = "fecha_alta")
    private Date fechaAlta; // este va? -- en la BD es por defoult (no hago Get/Set por el momento)

    public int getPrestamoId() {
        return prestamoId;
    }
    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
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
