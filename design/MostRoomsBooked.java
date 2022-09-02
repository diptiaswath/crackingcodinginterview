package design;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/discuss/interview-question/421787/
public class MostRoomsBooked {

    public String mostRoomsBooked(String[] floors) {
        Map<String, Integer> floorCountMap = new HashMap<>();
        int max = 0;
        String currentMax = floors[0];

        for (int i = 0 ; i < floors.length; i++) {
            String currentRoom = floors[i];
            if (currentRoom.startsWith("-")) {
                continue;
            }
            int floorCount = floorCountMap.getOrDefault(currentRoom, 0) + 1;
            floorCountMap.put(currentRoom, floorCount);
            System.out.println("current room = " + currentRoom + " , count = " + floorCount);
            if (floorCount > max) {
                max = floorCount;
                currentMax = currentRoom;
            } else if (floorCount == max) {
                currentMax = currentMax.compareTo(currentRoom) < 0 ? currentMax : currentRoom;
            }
        }
        return currentMax.substring(1);
    }

    public static void main(String[] args) {
        MostRoomsBooked s = new MostRoomsBooked();
        String[] floors = new String[] {"+1A", "+3E", "-1A", "+4F", "+1A", "-3E", "+3E", "+1A", "+1A", "+4C", "+3E"};
        System.out.println(s.mostRoomsBooked(floors));
    }
}
