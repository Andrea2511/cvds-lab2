package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    ArrayList<Integer> voters = new ArrayList<>();

    public RegisterResult registerVoter(Person p) {
        if(p.getName() == null && p.getGender() == null && p.getAge() == 0 && p.getId()==0 && p.isAlive() == false) {
            return RegisterResult.NULL_PERSON;
        }

        RegisterResult result = null;

        if(!p.isAlive()){
            result = RegisterResult.DEAD;
        }
        else{
            if(p.getAge() >= 0){
                if(p.getAge() >= 18){

                    if(!voters.contains(p.getId())){
                        result = RegisterResult.VALID;
                        voters.add(p.getId());
                    }
                    else{
                        result = RegisterResult.DUPLICATED;
                    }

                }
                else{
                    result = RegisterResult.UNDERAGE;
                }
            }
            else{
                result = RegisterResult.INVALID_AGE;
            }
        }

        return result;
    }
}
