package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain06 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        transaction 단위
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            System.out.println("ch06");
//            oneToManyOneD(em,tx);
            manyToManyOneD(em,tx);
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

    public static void manyToManyOneD(EntityManager em, EntityTransaction tx){
        Product productA = new Product();
        productA.setName("상품A");
        em.persist(productA);

        Member member1= new Member("회원1");
        member1.getProducts().add(productA);
        em.persist(member1);

        em.flush();
        em.clear();

        Member member = em.find(Member.class, 2L);
        List<Product> products = member.getProducts();
        for (Product product : products) {
            System.out.println("# >>> " + product.getName()+":"+product.getId());
        }

        tx.commit();
    }

    public static void oneToManyOneD(EntityManager em, EntityTransaction tx){
        Member member1= new Member("member1");
        Member member2= new Member("member2");
        Locker lockMem1 = new Locker();
        lockMem1.setName("LockByMem1");
        em.persist(lockMem1);
        member1.setLocker(lockMem1);
        em.persist(member1);
        em.persist(member2);

        Team teamA = new Team("teamA");
        teamA.getMembers().add(member1);
        teamA.getMembers().add(member2);
        em.persist(teamA);

//        em.flush();
//        em.clear();
//        member1 = em.find(Member.class, 1L);
        member1.setTeam(teamA);
        member2.setTeam(teamA);
        System.out.println("#### >> " + member1.getTeam().getName());


        tx.commit();
    }
}
