package shop;

import shop.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMainShop {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{

            Member member1 = new Member("memberA", "seoul", "35-10", "A01");
            em.persist(member1);
            Order orderMem1 = new Order();
            orderMem1.changeMember(member1);
            orderMem1.setOrderDate(LocalDateTime.now());
            orderMem1.setStatus(OrderStatus.ORDER);
            em.persist(orderMem1);

            /*Item pen = new Item("PEN", 2000, 5);
            Item eraser = new Item("ERASER", 1000, 1);
            Item white = new Item("WHITE", 2500, 1);
            Item postIt = new Item("POST_IT", 500, 1);
            em.persist(pen);
            em.persist(eraser);
            em.persist(white);
            em.persist(postIt);*/
            Album album = new Album();
            album.setName("Album1");
            album.setPrice(2000);
            album.setStockQuantity(200);
            album.setArtist("artist1");
            album.setEtc("etc1");
            em.persist(album);

            Movie movie = new Movie();
            movie.setName("movie1");
            movie.setActor("Actor1");
            movie.setDirector("director");
            em.persist(movie);

            OrderItem orderItemMem1_01 = new OrderItem(4000, 2);
            OrderItem orderItemMem1_02 = new OrderItem(2000, 2);
            orderItemMem1_01.setItem(album);
            orderItemMem1_02.setItem(movie);
            orderMem1.addOrderItems(orderItemMem1_01);
            orderMem1.addOrderItems(orderItemMem1_02);
            em.persist(orderItemMem1_01);
            em.persist(orderItemMem1_02);

            Order order = em.find(Order.class, 2L);
            Member member = order.getMember();
            System.out.println("#### >> " + member.getId()+":"+member.getName());
            OrderItem findOrderItem = order.getOrderItems().get(0);
            Item item = findOrderItem.getItem();
            System.out.println("#### >> " + item.getId() +":"+ item.getName());
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
