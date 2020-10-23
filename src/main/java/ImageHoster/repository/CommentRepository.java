package ImageHoster.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    
    public boolean addComment(Image image,User user,Comment comment) {
    	
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            comment.setImage(image);
            comment.setUser(user);
            em.persist(comment);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        }
        
        return false;
    }
   

}
