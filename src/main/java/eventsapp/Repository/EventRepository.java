package eventsapp.Repository;

import eventsapp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByTitleContainingOrDescriptionContaining(String text, String textAgain);

    @Query(value = "SELECT * FROM event WHERE event.title = 'Cooking'", nativeQuery = true)
            List<Event> findNewEvents();

    @Query(value = "SELECT * FROM event WHERE event.description LIKE %?1", nativeQuery = true)
    List<Event> findQueryWithParameter(String text);

    @Query(value = "SELECT id, title, description, category1, category2, category3, location, latitude, longitude, date," +
            " photoid, signup.signupid, signup.userid, signup.eventid FROM event INNER JOIN signup ON event.id = signup.eventid WHERE signup.userid = ?1", nativeQuery = true)
    List<Event> findEventByUserID(Integer text);

    @Query(value = "SELECT * FROM event", nativeQuery = true)
    List<Event> findAllEvents();




//
//    @Query(value = "SELECT * FROM event\n" +
//            "where event.id in (select EventID from signup where userID = ?1);", nativeQuery = true)
//    List<Event> findEventByUserID(Integer text);
//


//    Query for finding event by user ID
//    SELECT * FROM event
//    where event.id in (select EventID from signUp where userID = 1)


//    List<Event> findByTitleContaining(String text, String textAgain);

//    @Query(value = "SELECT * FROM event WHERE title = ?1", nativeQuery = true)
//    Event findByTitle (String text);

}


