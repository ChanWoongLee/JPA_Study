package helloJPA;

import helloJPA.domain.Member;

import javax.persistence.*;
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
            Member member = new Member();
            member.setUserName("member1");
            em.persist(member);

            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
            //Query query2 = em.createQuery("select m.username from Member m", Member.class); // 반환 타입 불명확


            Member member1 = em.createQuery("select m from Member m where m.userName = :username", Member.class)
                    .setParameter("username" , "member1")
                    .getSingleResult();
            System.out.println(member.getUserName());

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
