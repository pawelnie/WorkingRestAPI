package eventsapp.Repository;

import eventsapp.entity.Event;
import eventsapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(value = "select * from user where fireid = ?1", nativeQuery = true)
    List<User> finUserId(String text);


}
