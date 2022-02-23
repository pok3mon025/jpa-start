package jpabook.jpastart;

import jpabook.jpastart.entity.Delivery;
import jpabook.jpastart.entity.Member;
import jpabook.jpastart.entity.Order;
import jpabook.jpastart.entity.OrderItem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class JpaStartApplication {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            //TODO 비즈니스 로직
            Delivery delivery = new Delivery();
            OrderItem orderItem1 = new OrderItem();
            OrderItem orderItem2 = new OrderItem();

            Order order = new Order();
            order.setDelivery(delivery);
            order.addOrderItem(orderItem1);
            order.addOrderItem(orderItem2);

            em.persist(order);

            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

}
