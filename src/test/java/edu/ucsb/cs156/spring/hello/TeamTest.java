package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    //need a test for 
    // 1) same object
    // 2) different class 
    // 3) two parts to the &&, so we may need to cover these possibilities: {names are equal, members are equal}, {names are equal, members are not equal}, {names are not equal, members are equal}, {names are not equal, members are not equal}
    @Test
    public void boolean_returns_correct_boolean_one() {
        Team t = new Team("test-team");
        assert(t.equals(t));

    }

    @Test
    public void boolean_returns_correct_boolean_two() {
        Team t = new Team("test-team");
        assert(!t.equals("something that is not a team")); 
    }

    @Test
    public void boolean_returns_correct_boolean_three_one() {
        Team t1 = new Team("test-team");
        Team t2 = new Team("test-team");
        t1.addMember("member1");
        t2.addMember("member1");
        assert(t1.equals(t2));
    }

    @Test
    public void boolean_returns_correct_boolean_three_two() {
        Team t1 = new Team("test-team");
        Team t2 = new Team("test-team");
        t1.addMember("member1");
        t2.addMember("member2");
        assert(!t1.equals(t2));         //assert false because members are not equal, even though names are equal
    }

    @Test
    public void boolean_returns_correct_boolean_three_three() {
        Team t1 = new Team("test-team");
        Team t2 = new Team("different-name");        //short circuit, doesn't matter if members are equal
        assert(!t1.equals(t2));
    }


    //testing hashCode --> if 2 vals have the same contentm they should have the same hashcode
    @Test void hashCode_returns_correct_hashcCode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test void secondHashTest() {
        Team t1 = new Team();
        int result = t1.hashCode();
        int expectedResult = 1;         //hardcoded
        assertEquals(expectedResult, result);       //changing after failure; expected val is 1
    }


}
