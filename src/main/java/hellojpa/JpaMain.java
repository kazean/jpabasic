package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        transaction 단위
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
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
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
