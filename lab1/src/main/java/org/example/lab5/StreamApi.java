package org.example.lab5;

import org.example.lab3.nameCorparator;
import org.example.lab1.people;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class StreamApi {

    public static void main(String[] args) {
        Stream<people> Ps = Stream.of(new people.Builder("Tom").build(),
                new people.Builder("jim", 23566, 84, 878784).build(),
                new people.Builder("Sergey", 236, 102, 878).build(),
                new people.Builder("Sergey", 2376, 12, 8758).build(),
                new people.Builder("Andri", 11236, 132, 8078).build());
        //System.out.println(Ps.filter(element->element.GetName().equals("Sergey")).collect(Collectors.toList()));
        //змінні з мал букви


//        Add(stringList);
//        System.out.println("Every worker In list\n");
        //       SeeAll(stream);

        //     System.out.println("Every worker In list(Sort for exp)\n");
        //     Collections.sort(stringList);
        //    SeeAll(stringList);
        //
        System.out.println("Every worker In list(Sort for lengh name)\n");
        Ps.sorted(new nameCorparator())
                .forEach(p->System.out.printf("Info{ " +
                        "Name - " + p.getName()+ " |" +
                        "CodeP - " + p.getCodeP() + " |" +
                        "Phone Number +" + p.getPhoneNumber() + " |" +
                        "Exp " + p.getExp() + "mounth |" +
                        "}\n"));


                //SeeAll(Ps);
//        Ps.forEach(p1->System.out.printf("Info{ " +
//                "Name - " + p1.GetName()+ " |" +
//                "CodeP - " + p1.GetCodeP() + " |" +
//                "Phone Number +" + p1.GetCodeP() + " |" +
//                "Exp " + p1.GetExp() + "mounth |" +
//                '}'));
           System.out.println("Found sergey`s\n");
        Ps.filter(s1 -> s1.GetName()=="Sergey")
                .forEach(s1->System.out.printf("Info{ " +
                        "Name - " + s1.getName()+ " |" +
                        "CodeP - " + s1.getCodeP() + " |" +
                        "Exp " + s1.getExp() + "mounth |" +
                        "Lease Term " + s1.getExp() + "mounth |" +
                        "}\n"));
        //  System.out.println("Delete all\n");
        //    for(int i=stringList.size()-1; i>=0; i--) {
        //         DeleteLast(stringList);
        //     }
        //     check(stringList);

    }


    private static void SeeAll(Stream<people> stream) {
            stream.forEach(p->System.out.printf("Info{ " +
                    "Name - " + p.getName()+ " |" +
                    "CodeP - " + p.getCodeP() + " |" +
                    "Phone Number +" + p.getCodeP() + " |" +
                    "Lease Term " + p.getExp() + "mounth |" +
                    '}'));
        }


    private static void DeleteLast(List<people> stringList) {
        stringList.remove(stringList.size() - 1);
    }

    private static void Add(List<people> stringList) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input name\n");
        String Name = "Sergey";// in.nextLine();
        System.out.println("Input number\n");
        int Number = in.nextInt();
        System.out.println("Input exp\n");
        int LeaseTerm = in.nextInt();
        System.out.println("Input Code of pasport\n");
        int CodeP = in.nextInt();

        stringList.add(new people.Builder(Name, Number, LeaseTerm, CodeP).build());
    }

    private static void Found(List<people> stringList) {
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).name == "Sergey") {
              //  System.out.println((stringList.get(i)).toString());
            }
        }
    }

    private static void check(List<people> stringList) {
        System.out.println("list empty - " + stringList.isEmpty());
    }


};