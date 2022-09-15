package music_management.repository.impl;

import music_management.model.Music;
import music_management.repository.IMusicRepository;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Cache;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {

    @Override
    public List<Music> findAll() {
        Session session = null;
        List<Music> musicList = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            musicList = session.createQuery("FROM Music ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return musicList;


    }

    @Override
    public void save(Music music) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }


    @Override
    public Music findById(int id) {
        TypedQuery<Music> query = ConnectionUtil.entityManager.createQuery("select p from Music as p where p.id = : id", Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Music music) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(music);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        TypedQuery<Music> query = ConnectionUtil.entityManager.createQuery("SELECT c FROM Music AS c WHERE c.id = :id", Music.class);
        query.setParameter("id", id);
        Music music = query.getSingleResult();

        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
