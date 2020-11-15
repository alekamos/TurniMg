package it.costanza.dao;

import it.costanza.dao.Util.HibernateUtilH2;
import it.costanza.dao.Util.HibernateUtilMySql;
import it.costanza.entityDb.mysql.TurniGeneratiEntity;
import org.hibernate.Session;

public class TurnoDao implements Crud<TurniGeneratiEntity> {


    public long salva(TurniGeneratiEntity e) {


        Session session = HibernateUtilMySql.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();



        return e.getIdTurno();
    }


    public long salvaLocal(TurniGeneratiEntity e) {


        Session session = HibernateUtilH2.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();

        return e.getIdTurno();
    }

    public void svuotaLocal() {
        Session session = HibernateUtilH2.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("DELETE FROM TURNI_GENERATI").executeUpdate();
        session.getTransaction().commit();
        session.close();


    }



    @Override
    public long update(TurniGeneratiEntity e) {
        Session session = HibernateUtilMySql.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + e.toString());
        return e.getIdTurno();
    }


    @Override
    public Object getById(Long id) {
        return null;
    }
}
