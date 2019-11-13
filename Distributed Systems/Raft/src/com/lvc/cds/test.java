package com.lvc.cds;

import com.lvc.cds.AddressBookProtos.AddressBook;
import com.lvc.cds.AddressBookProtos.Person;

public class test {
    public static void main(String[] args){
        Person.Builder rob = Person.newBuilder();
        rob.setId(7);
        rob.setName("Rob");
        rob.setEmail("yes@yes.yes");
        rob.addPhones(
                Person.PhoneNumber.newBuilder()
                        .setNumber("111-1111")
                        .setType(Person.PhoneType.HOME));
        rob.build();

        System.out.println(rob.getEmail());
    }
}
