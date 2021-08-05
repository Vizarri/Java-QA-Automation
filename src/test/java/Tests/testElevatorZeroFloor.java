package Tests;

import elevator.ElevatorFloors;
import models.Elevator.Elevator;
import org.junit.Assert;
import org.junit.Test;

public class testElevatorZeroFloor {
    @Test
    public void testElevatorZeroFloor() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 5);
        Elevator elevator = new Elevator(0, elevatorFloors, false);
        int expectedResult = 1;
        int actualResult = elevator.getCurrentFloor();
        Assert.assertEquals("0 этажа не может быть", expectedResult, actualResult);
    }
}
