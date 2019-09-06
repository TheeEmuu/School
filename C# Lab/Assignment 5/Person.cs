using System;
using System.Collections.Generic;

delegate Boolean Filter(Person x);

class Person{
    String name;
    int age;

    public Person(String x, int y){
        Name = x;
        Age = y;
    }

    public String Name{
        get{ return name; }
        set{ name = value; }
    }
    public int Age{
        get{ return age; }
        set{ age = value; }
    }

    public static Boolean isChild(Person x){
        if(x.Age < 18)
            return true;

        return false;
    }

    public static Boolean NameStartsWithA(Person x){
        if(x.Name[0].CompareTo('A') == 0)
            return true;
        return false;
    }

    public static List<Person> DisplayPeople(List<Person> list, Filter filter){
        List<Person> matches = new List<Person>();

        foreach(Person x in list){
            if(filter(x))
                matches.Add(x);
        }


        return matches;
    }

    static void Main(string[] args){
     Filter filterChild = isChild;
     Filter filterName = NameStartsWithA;

        List<Person> list = new List<Person>() {
            new Person("Albert", 13),
            new Person("Rob", 22),
            new Person("Nick", 30),
            new Person("Andy", 26),
            new Person("Amy", 11)
        };

        foreach(Person x in DisplayPeople(list, filterChild)){
            Console.WriteLine(x.Name);
        }

        Console.WriteLine("\n\n");

        foreach(Person x in DisplayPeople(list, filterName)){
            Console.WriteLine(x.Name);
        }
    }
}