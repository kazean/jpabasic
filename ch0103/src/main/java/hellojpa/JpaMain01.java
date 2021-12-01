package hellojpa;

import hellojpa.Member;

import javax.persistence.*;
import java.util.List;

public class JpaMain01 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        transaction 단위
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
//            jpaCRUD(em,tx);
//            persistenceContext(em, tx);
//            testDetached(em, tx);
            System.out.println("hello");
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

    public static void testDetached(EntityManager em, EntityTransaction tx){
        Member memfirst = em.find(Member.class, 201L);
//        em.detach(memfirst);
//        memfirst.setName("last");

        em.clear();
//        준영속상태
        memfirst.setName("last");
        tx.commit();
        em.close();

    }

    public static void persistenceContext(EntityManager em,EntityTransaction tx){
        /*
        Member memberA = new Member(100L, "memberA");
        Member memberB = new Member(101L, "memberB");
        em.persist(memberA);
        em.persist(memberB);
        */

//        변경감지 dirty checking snapshot
//        memberA.setName("hi");
//        em.update X
        /*
        Member memberBSelect = em.find(Member.class,101L);
        System.out.println("memberBSelect.id = " + memberBSelect.getId());
        System.out.println("memberBSelect.name = "  + memberBSelect.getName());
        em.remove(memberBSelect);
*/

        Member test = new Member(1000L, "test");
        em.persist(test);

//        flush
        TypedQuery<Member> typedQuery = em.createQuery("select m from Member m", Member.class);
        List<Member> resultMemberList = typedQuery.getResultList();
//        em.flush();
//        tx.commit();

//        커밋하는 시점에 INSERT 트랜잭션을 지원하는 쓰기 지연 transactional write-behind
        System.out.println("=== commit");
        tx.commit();
    }

    public static void jpaCRUD(EntityManager em, EntityTransaction tx){
        /*
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);
            Member member1 = new Member();
            member1.setId(2L);
            member1.setName("HelloB");
            em.persist(member1);

            em.remove(findMember);


            */
        Member findMember = em.find(Member.class,1L);
        System.out.println("findMember.id = "+ findMember.getId());
        System.out.println("findMember.name = "+ findMember.getName());
        findMember.setName("HelloJPA");
        List<Member> result = em.createQuery("select m from Member as m",Member.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();
        for(Member m : result){
            System.out.println("member.name = " + m.getName());
        }

        tx.commit();
    }
}
