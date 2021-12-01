package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain05 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        transaction 단위
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            memberRelatedTeam(em, tx);
            findTeamMemebers(em, tx);
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

    public static void findTeamMemebers(EntityManager em, EntityTransaction tx){
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);
        Member member1 = new Member(1L, "A1",teamA);
        Member member2 = new Member(2L, "A2",teamA);
        Member member3 = new Member(3L, "B1",teamB);
        teamA.getMembers().add(member1);
        teamA.getMembers().add(member2);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);


        em.flush();
        em.clear();

        Team findTeam1 = em.find(Team.class, 1L);
        System.out.println("# "+findTeam1.getId() +":"+findTeam1.getName());
        List<Member> findMembers = findTeam1.getMembers();
        for(Member m : findMembers){
            System.out.println(m.getId()+": "+m.getName());
        }

        tx.commit();
    }

    public static void memberRelatedTeam(EntityManager em, EntityTransaction tx){
        Team teamA = new Team("teamA");
        Member member = new Member(1L,"A1", teamA);
        em.persist(teamA);
        em.persist(member);

        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, 1L);
        System.out.println(findMember.getTeam().getName());

        tx.commit();
    }
}
