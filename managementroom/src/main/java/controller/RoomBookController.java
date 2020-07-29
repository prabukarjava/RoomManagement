package controller;

import entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.RoomService;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
public class RoomBookController {


    @Autowired
      private RoomService roomService;

    @RequestMapping(value="/rooms")
    public List<Room>getRooms(@RequestParam(value="ids",required = false) Set<Integer> rid,
                              @RequestParam(value = "firstname",required = false)String firstname){
        return roomService.getRooms(rid,firstname);
    }
    @RequestMapping(value = "/rooms",method = RequestMethod.POST)
    public Room createRoom(Room room){
     return roomService.createRoom(room);
    }
    @RequestMapping(value="rooms/{id}")
    public Room getBookById(@PathVariable("id") Integer roomId){
        return roomService.getRoomById(roomId);
    }
    @RequestMapping(value = "/rooms",method = RequestMethod.PUT)
    public Room updateRoom(@RequestBody Room incomingRoom){
    return roomService.updateRoom(incomingRoom);
    }

    @RequestMapping(value="room/{roomId}",method = RequestMethod.DELETE)
    public String deleteRoomById(Integer roomId){
        return roomService.deleteById(roomId);
    }

}
