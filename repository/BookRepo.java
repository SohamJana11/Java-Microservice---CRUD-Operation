package cts.pepsico.Microservice_demo_GET.repository;

import cts.pepsico.Microservice_demo_GET.model.Book; //imports book entity class from model package
import org.springframework.data.jpa.repository.JpaRepository; //it provides CRUD operation
import org.springframework.stereotype.Repository; //indicates that the interface is a Spring data Repository

@Repository //This BookRepo interface will handle database operations & makes it a spring bean
public interface BookRepo extends JpaRepository<Book, Long> { //Book -> the entity type, Long -> type of entity's p key


}
