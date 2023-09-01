package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.NULL_PERSON, result);
    }
    
    @Test
    public void validateIsDead(){

        Person person = new Person("Charola", 1000858015, 15, Gender.UNIDENTIFIED, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);

    }
    
    @Test
    public void validateIsUnderage(){

        Person person = new Person("Charola", 1000858015, 0, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);

    }

    @Test
    public void validateIsInvalidAge(){

        Person person = new Person("Charola", 1000858015, -15, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);

    }

    @Test
    public void validateisValid(){

        Person person = new Person("Charola", 1000858015, 21, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);

    }

    @Test
    public void validateisDuplicated(){

        Person person = new Person("Charola", 1000858015, 21, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);

        Person person2 = new Person("Andrea", 1000858015, 20, Gender.MALE, true);
        RegisterResult result2 = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.DUPLICATED, result2);

    }

}
