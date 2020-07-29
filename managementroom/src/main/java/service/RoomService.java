package service;


import entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.RoomRepositor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RoomService {

    @Autowired
    private RoomRepositor roomRepositor;
   //get
   public List<Room> getRooms(Set<Integer> rid,String firstname){

       List<Room>roomList=new ArrayList<>();
       if(rid==null) {
           roomRepositor.findAll().forEach(room -> roomList.add(room));
       }else {
           roomRepositor.findAllByroomidInAndFirstname(rid,firstname);
       }
       return roomList;
       }

    //create
    public Room createRoom(Room room) {
       return roomRepositor.save(room);
    }
    //single resource
    public Room getRoomById(Integer roomId) {
      return roomRepositor.findOne(roomId);
    }
    //update
    public Room updateRoom(Room incomingRoom) {
       return roomRepositor.save(incomingRoom);
    }
   //delete
    public String deleteById(Integer roomId) {
       roomRepositor.delete(roomId);
       return "Deleted successfully";
    }
}
