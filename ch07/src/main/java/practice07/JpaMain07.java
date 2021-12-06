package practice07;

import practice07.entity.*;

import javax.persistence.*;

public class JpaMain07 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
//            extendMapping(em);
//            mappedSuerpClass(em);
//            idClass(em);
//            embeddedId(em);
//            complexKeyIdClass(em);
//            complexKeyEmbedded(em);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
    /*
    public static void complexKeyEmbedded(EntityManager em){
        Parent parent = new Parent();
        parent.setId("pid1");
        parent.setName("parent1");
        em.persist(parent);

        ChildId childId = new ChildId();
        childId.setParentId("pid1");
        childId.setChildId("cid1");
        Child child = new Child();
        child.setChildId(childId);
        child.setName("child1");
        child.setParent(parent);
        em.persist(child);

        GrandChildId grandChildId = new GrandChildId();
        grandChildId.setId("gcid1");
        grandChildId.setChildId(childId);
        GrandChild grandChild = new GrandChild();
        grandChild.setGrandChildId(grandChildId);
        grandChild.setChild(child);
        grandChild.setName("gchild1");
        em.persist(grandChild);
    }*/

    /*
    public static void complexKeyIdClass(EntityManager em){
        Parent parent = new Parent();
        parent.setId("pid1");
        parent.setName("parent1");
        em.persist(parent);

        Child child = new Child();
        child.setChildId("cid1");
        child.setName("child1");
        child.setParent(parent);
        em.persist(child);

        GrandChild grandChild = new GrandChild();
        grandChild.setId("gchid1");
        grandChild.setName("gchild1");
        grandChild.setChild(child);
        em.persist(grandChild);
    }*/

    /*
    public static void embeddedId(EntityManager em){
        Parent parent = new Parent();
        ParentId parentId = new ParentId("myId1","myId2");
        parent.setId(parentId);
        parent.setName("parent1");
        em.persist(parent);

        Child child = new Child();
        child.setParent(parent);
        child.setId("chId1");
        child.setName("child1");
        em.persist(child);
    }
*/
    /*
    public static void idClass(EntityManager em){
        Parent parent = new Parent();
        parent.setId1("id1");
        parent.setId2("id2");
        parent.setName("parent1");
        em.persist(parent);

        Child child = new Child();
        child.setParent(parent);
        child.setId("Cid1");
        em.persist(child);
    }
*/
    public static void mappedSuerpClass(EntityManager em){
        Member m1 = new Member();
        m1.setName("m1");
        m1.setEmail("m1@test.com");
        em.persist(m1);

        Seller s1 = new Seller();
        s1.setName("s1");
        s1.setShopName("shopname1");
        em.persist(s1);
    }

    public static void extendMapping(EntityManager em){
        Movie movie = new Movie();
        movie.setName("m1");
        movie.setPrice(1000);
        movie.setDirector("director1");
        movie.setActor("actor1");
        em.persist(movie);
        Album album = new Album();
        album.setName("a1");
        album.setArtist("artist1");
        em.persist(album);
    }
}
