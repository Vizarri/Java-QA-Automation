package Tests;

import elevator.ElevatorFloors;
import elevator.exceptions.DoorsAreOpenException;
import elevator.exceptions.FloorOutOfBoundException;
import models.Elevator.Elevator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class TestElevator {
    @Test
    public void testElevatorAreTheDoorsOpen() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 5);
        Elevator elevator = new Elevator(1, elevatorFloors, true);
        try {
            elevator.moveElevatorToTheFloor(3);
            Assert.assertTrue(false);
        } catch (DoorsAreOpenException ex) {
            Assert.assertTrue(true);
        }
    }

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

        List<Integer> actualResult = elevator.getAvailableFloors();
        Assert.assertEquals("метод getAvailableFloors() выдает лист на один элемент меньше чем нужно", list, actualResult);
    }

    @Test
    public void testElevatorMoveToZeroFloor() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 5);
        Elevator elevator = new Elevator(1, elevatorFloors, true);
        elevator.moveElevatorToTheFloor(0);
        int expectedResult = 0;
        try {
            elevator.moveElevatorToTheFloor(expectedResult);
            Assert.assertTrue(false);
        } catch (FloorOutOfBoundException ex) {
            Assert.assertTrue(true);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3, 4, 5})
    public void testElevatorZeroFloor(int floor) {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 5);
        Elevator elevator = new Elevator(0, elevatorFloors, false);
        int expectedResult = floor;
        int actualResult = elevator.getCurrentFloor();
        Assert.assertEquals("0 этажа не может быть", expectedResult, actualResult);
    }
}
