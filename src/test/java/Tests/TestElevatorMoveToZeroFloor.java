package Tests;

import elevator.ElevatorFloors;
import models.Elevator.Elevator;
import org.junit.Assert;
import org.junit.Test;

public class TestElevatorMoveToZeroFloor {
    @Test
    public void testElevatorMoveToZeroFloor() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 5);
        Elevator elevator = new Elevator(1, elevatorFloors, true);
        elevator.moveElevatorToTheFloor(0);
        int expectedResult = 1;
        int actualResult = elevator.getCurrentFloor();
        Assert.assertEquals("ехать на 0 этаж невозможно", expectedResult, actualResult);
    }
}
