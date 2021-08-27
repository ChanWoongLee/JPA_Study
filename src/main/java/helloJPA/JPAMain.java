package helloJPA;

import helloJPA.domain.Bird;
import helloJPA.domain.Member;
import helloJPA.domain.Order;
import helloJPA.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 로딩지점에 딱하나만 만들어야한다! 데이터 베이스 커넥션을 받았다고 생각하면 편하다.
        EntityManager em = emf.createEntityManager();
        // jpa의 모든 데이터 변경은 트랜잭션안에서 실행해야한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Bird bird = new Bird();
            bird.setHome("관악구");
            bird.setWings(4);
            bird.setAge(14);
            bird.setName("큰새");
            em.persist(bird);
//            Team team = new Team(); ff
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUserName("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            // jpa가 join쿼리르 날려서 member와 team을 가져왔다.
//            Member findMember = em.find(Member.class,member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//            Team findTeam = findMember.getTeam();
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
