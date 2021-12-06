import com.sun.org.apache.xpath.internal.operations.Or;
import entity.*;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain08 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
//            proxyPractice(em);
//            lazyEagerLoading(em);
            cascadePersistence(em);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }

    public static void cascadePersistence(EntityManager em){
        Parent parent = new Parent();
        Child child1 = new Child();
        Child child2 = new Child();
        child1.setParent(parent);
        child2.setParent(parent);
        parent.getChildList().add(child1);
        parent.getChildList().add(child2);
        em.persist(parent);

//        em.remove(parent);
        em.flush();
        em.clear();
        em.find(Parent.class, parent.getId()).getChildList().remove(0);
//        em.find(Parent.class, parent.getId()).getChildList().remove(child1);
    }

    public static void lazyEagerLoading(EntityManager em){
        Team teamA = new Team();
        teamA.setName("teamA");
        em.persist(teamA);

        Member m1 = new Member();
        m1.setName("member1");
        m1.setTeam(teamA);
        em.persist(m1);

        Product p1 = new Product();
        p1.setName("pen");
        em.persist(p1);
        Order orderM1 = new Order();
        orderM1.setCreateDateTime(LocalDateTime.now());
        orderM1.changeMember(m1);
        orderM1.changeProduct(p1);

        em.persist(orderM1);

        em.flush();
        em.clear();
        Member findM1 = em.find(Member.class, m1.getId());
        System.out.println("# findMember >> " +findM1.getName());
        System.out.println("# " + findM1.getTeam().getName());
        List<Order> order = findM1.getOrders();
        for (Order order1 : order) {
            System.out.println("iter > " + order1.getId());
            System.out.println("iter > " + order1.getProduct().getName());
        }


    }

    public static void proxyPractice(EntityManager em){
        Team teamA = new Team();
        teamA.setName("teamA");
        em.persist(teamA);

        Member m1 = new Member();
        m1.setName("member1");
        m1.setTeam(teamA);
        em.persist(m1);

        em.flush();
        em.clear();

        Member refMember = em.getReference(Member.class, m1.getId());

        System.out.println("# ref getName() >> " + refMember.getName());
//            System.out.println("# refMember >> " + refMember.getClass());
//            System.out.println("# refMember >> " + refMember.getClass().getName());
//            Hibernate.initialize(refMember);

    }
}
