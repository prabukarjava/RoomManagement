package repo;


import entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoomRepositor extends CrudRepository<Room,Integer> {

    List<Room> findAllByroomidInAndFirstname(Set<Integer> rid, String firstname);
}
