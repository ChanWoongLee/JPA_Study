package helloJPA;

import helloJPA.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class JPAMain3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 로딩지점에 딱하나만 만들어야한다! 데이터 베이스 커넥션을 받았다고 생각하면 편하다.
        EntityManager em = emf.createEntityManager();
        // jpa의 모든 데이터 변경은 트랜잭션안에서 실행해야한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {



        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
