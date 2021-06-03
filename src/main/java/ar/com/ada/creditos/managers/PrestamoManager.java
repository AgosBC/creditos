package ar.com.ada.creditos.managers;
import ar.com.ada.creditos.entities.*;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.Query;

public class PrestamoManager {

    protected SessionFactory sessionFactory; //buscar funcion de esto

    public void setup() {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings  from hibernate.cfg.xml
                                                                                                 
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw ex;
        }

    }

    public void exit() {
        sessionFactory.close();
    }

    // cargar un prestamo a un cliente existente 
    // opcion listar prestamos 
    
    public void create(Prestamo prestamo) {

        Session session = sessionFactory.openSession(); 
        session.beginTransaction();

        session.save(prestamo); 


        session.getTransaction().commit(); 
        session.close(); 
    }

    public Prestamo read(int prestamoId) { 

        Session session = sessionFactory.openSession();

        Prestamo prestamo = session.get(Prestamo.class, prestamoId);

        session.close();

        return prestamo;
    }

    
    /*public Cliente readByCliente(int dni) { que prermita buscar los prestamos que tiene un cliente deberia agregar en cliente o usar el de Id
        //estaria aca, en cliente manager o en creditos?  - CREDITOS - RECORDATORIO, CAMBIAR
        Session session = sessionFactory.openSession();

        Cliente cliente = session.byNaturalId(Cliente.class).using("dni", dni).load();

        session.close();

        return prestamo;
    }*/

    public void update(Prestamo prestamo) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(prestamo);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Prestamo prestamo) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(prestamo);

        session.getTransaction().commit();
        session.close();
    }

    

    public List<Prestamo> buscarPrestamos() { // uitar mas adelante 

        Session session = sessionFactory.openSession();

        Query query = session.createNativeQuery("SELECT * FROM prestamo", Prestamo.class);
        //query = session.createQuery("From Obse")
        List<Prestamo> todos = query.getResultList();

        return todos;

    }

        //sumar todos los prestamos de un cliente

    public BigDecimal totalPrestamoCliente (int clienteId){

        Session session = sessionFactory.openSession();

        Query query = session.createNativeQuery("SELECT SUM(importe) FROM prestamo WHERE cliente_id= ?", Prestamo.class);
        query.setParameter(1, clienteId);

        double total = ((Number)query.getSingleResult()).doubleValue();
        BigDecimal totalPrestamo = new BigDecimal(total);

        return totalPrestamo;
        
       
    }



    
    

       
}
