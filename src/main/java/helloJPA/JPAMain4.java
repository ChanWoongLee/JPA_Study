package helloJPA;

import helloJPA.domain.Member;
import helloJPA.domain.Team;

import javax.persistence.*;
import java.util.List;

public class JPAMain4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 로딩지점에 딱하나만 만들어야한다! 데이터 베이스 커넥션을 받았다고 생각하면 편하다.
        EntityManager em = emf.createEntityManager();
        // jpa의 모든 데이터 변경은 트랜잭션안에서 실행해야한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUserName("회원1");
            member1.changeTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUserName("회원2");
            member2.changeTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUserName("회원3");
            member3.changeTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

            //String query = "select m From Member m";
            String query = "select m From Member m join fetch m.team";
            List<Member> result = em.createQuery(query,Member.class).getResultList();

            for (Member member : result) {
                System.out.println("member = "+ member.getUserName() + "," + member.getTeam().getName());
                //회원1, 팀A(SQL) 실행
                //회원2, 팀A(1차캐시) 실행
                //회원3, 팀B(SQL) 실행

                //join 은 최악 100명은 -> N+1 번의 실행이 된다!!  --> 패치조인을 해야한다.
                //fetch join 실제 엔티티를 들고 온거다 프록시 아님
            }

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
