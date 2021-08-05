package Tests;

import elevator.ElevatorFloors;
import models.Elevator.Elevator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testElevatorGetAvailableFloors {
    @Test
    public void testElevatorGetAvailableFloors() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(1, 5);
        Elevator elevator = new Elevator(1, elevatorFloors, true);
        elevator.moveElevatorToTheFloor(5);
        List<Integer> list = new ArrayList<>(5);

        int num = 0;
        while (list.size() != 5) {
            num++;
            list.add(num);
        }

        List<Integer> expectedResult = list;
        List<Integer> actualResult = elevator.getAvailableFloors();
        Assert.assertEquals("Кнопки для последнего этажа нет", expectedResult, actualResult);
    }
}
