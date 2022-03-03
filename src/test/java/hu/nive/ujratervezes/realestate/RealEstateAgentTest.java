package hu.nive.ujratervezes.realestate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RealEstateAgentTest {

    @Test
    void test_hasSmartMirror(){
        BathRoom bathRoomWithMirror = new BathRoom(10,true);
        BathRoom bathRoomWithoutMirror = new BathRoom(10,false);
        assertTrue(bathRoomWithMirror.hasSmartMirror() && !bathRoomWithoutMirror.hasSmartMirror());
    }

    @Test
    void test_bathRoomIsRoom(){
        BathRoom bathRoom = new BathRoom(15,false);
        assertTrue(bathRoom instanceof Room);
    }

    @Test
    void test_hasBigTV(){
        BedRoom bedRoomWithTV = new BedRoom(20, true);
        BedRoom bedRoomWithouthTV = new BedRoom(20, false);
        assertTrue(bedRoomWithTV.hasBigTV() && !bedRoomWithouthTV.hasBigTV());
    }

    @Test
    void test_bedRoomIsRoom(){
        BedRoom bedRoom = new BedRoom(30,false);
        assertTrue(bedRoom instanceof Room);
    }

    @Test
    void test_hasSmartFridge(){
        Kitchen kitchenWithFridge = new Kitchen(20,true);
        Kitchen kitchenWithouthFridge = new Kitchen(20,false);
        assertTrue(kitchenWithFridge.hasSmartFridge() && !kitchenWithouthFridge.hasSmartFridge());
    }

    @Test
    void test_kitchenIsRoom(){
        Kitchen kitchen = new Kitchen(20,false);
        assertTrue(kitchen instanceof Room);
    }

    @Test
    void test_getId(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
        }};
        RealEstate realEstate = new RealEstate(5,500000,rooms);
        assertEquals(5,realEstate.getId());
    }

    @Test
    void test_getPricePerSquareMeter(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
        }};
        RealEstate realEstate = new RealEstate(5,500000,rooms);
        assertEquals(500000,realEstate.getPricePerSquareMeter());
    }

    @Test
    void test_getRooms(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
        }};
        RealEstate realEstate = new RealEstate(5,500000,rooms);
        assertEquals(rooms,realEstate.getRooms());
    }

    @Test
    void test_sizeInSquareMeter(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BathRoom(10,true));
        }};
        RealEstate realEstate = new RealEstate(5,500000,rooms);
        assertEquals(60,realEstate.calculateSizeInSquareMeter());
    }

    @Test
    void test_price(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BathRoom(10,true));
        }};
        RealEstate realEstate = new RealEstate(5,500000,rooms);
        assertEquals(30000000,realEstate.calculatePrice());
    }

    @Test
    void test_getRealEstates(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BathRoom(10,true));
        }};

        List<RealEstate> realEstates = new ArrayList<RealEstate>(){{
            add(new RealEstate(5,500000,rooms));
        }};
        RealEstateAgent realEstateAgent = new RealEstateAgent(realEstates);
        assertEquals(realEstates, realEstateAgent.getRealEstates());
    }

    @Test
    void test_addRealEstate(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BathRoom(10,true));
        }};
        List<Room> roomsTwo = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BedRoom(30,false));
            add(new BathRoom(10,true));
        }};

        RealEstate realEstate = new RealEstate(1,500000,rooms);
        RealEstate realEstateTwo = new RealEstate(2,500000,roomsTwo);

        List<RealEstate> realEstates = new ArrayList<RealEstate>(){{
            add(realEstate);
        }};

        List<RealEstate> expected = new ArrayList<RealEstate>(){{
            add(realEstate);
            add(realEstateTwo);
        }};

        RealEstateAgent realEstateAgent = new RealEstateAgent(realEstates);
        realEstateAgent.addRealEstate(realEstateTwo);
        assertThat(realEstateAgent.getRealEstates()).hasSameElementsAs(expected);
    }

    @Test
    void test_removeRealEstateById(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BathRoom(10,true));
        }};
        List<Room> roomsTwo = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BedRoom(30,false));
            add(new BathRoom(10,true));
        }};

        RealEstate realEstate = new RealEstate(1,500000,rooms);
        RealEstate realEstateTwo = new RealEstate(2,500000,roomsTwo);

        List<RealEstate> realEstates = new ArrayList<RealEstate>(){{
            add(realEstate);
            add(realEstateTwo);
        }};

        List<RealEstate> expected = new ArrayList<RealEstate>(){{
            add(realEstate);
        }};
        RealEstateAgent realEstateAgent = new RealEstateAgent(realEstates);
        realEstateAgent.removeRealEstateById(2);
        assertThat(realEstateAgent.getRealEstates()).hasSameElementsAs(expected);
    }

    @Test
    void test_findLargestRealEstate(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BathRoom(10,true));
        }};
        List<Room> roomsTwo = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BedRoom(30,false));
            add(new BathRoom(10,true));
        }};

        RealEstate realEstate = new RealEstate(1,400000,rooms);
        RealEstate realEstateTwo = new RealEstate(2,500000,roomsTwo);

        List<RealEstate> realEstates = new ArrayList<RealEstate>(){{
            add(realEstate);
            add(realEstateTwo);
        }};
        RealEstateAgent realEstateAgent = new RealEstateAgent(realEstates);
        assertEquals(realEstateTwo,realEstateAgent.findLargestRealEstate());
    }

    @Test
    void test_findCheapestBySquareMeterRealEstate(){
        List<Room> rooms = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BathRoom(10,true));
        }};
        List<Room> roomsTwo = new ArrayList<Room>(){{
            add(new Kitchen(20,true));
            add(new BedRoom(30,true));
            add(new BedRoom(30,false));
            add(new BathRoom(10,true));
        }};

        RealEstate realEstate = new RealEstate(1,400000,rooms);
        RealEstate realEstateTwo = new RealEstate(2,500000,roomsTwo);

        List<RealEstate> realEstates = new ArrayList<RealEstate>(){{
            add(realEstate);
            add(realEstateTwo);
        }};
        RealEstateAgent realEstateAgent = new RealEstateAgent(realEstates);
        assertEquals(realEstate,realEstateAgent.findCheapestBySquareMeterRealEstate());
    }
}