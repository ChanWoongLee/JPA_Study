package helloJPA;

import helloJPA.domain.Member;
import helloJPA.domain.MemberDTO;

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

            List resultList = em.createQuery("select m.username, m.age from Member m", Member.class).getResultList(); // 반환 타입 불명확
            // 1. Object 형으로 받기
            // 2. Object[] 타입으로 조회 List<Object>
            // 제일 깔끔한 마지막 3번째 DTO로 조회하기
            List<MemberDTO> resultList2 = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class).getResultList(); // 반환 타입 불명확
            MemberDTO memberDTO = resultList2.get(0);
            System.out.println(memberDTO.getUserName());

            Member member1 = em.createQuery("select m from Member m where m.userName = :username", Member.class)
                    .setParameter("username" , "member1")
                    .getSingleResult();
            System.out.println(member.getUserName());

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
