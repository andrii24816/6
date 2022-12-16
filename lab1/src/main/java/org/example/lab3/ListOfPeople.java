package org.example.lab3;

import org.example.lab1.people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class ListOfPeople{

    public static void main(String[] args) {
        List<people> stringList = new ArrayList<>();
        stringList.add(new people.Builder("Tom").build());//добавление элементов
        stringList.add(new people.Builder("jim", 23566, 84, 878784).build());
        stringList.add(new people.Builder("Sergey", 236, 102, 878).build());
        stringList.add(new people.Builder("Sergey", 2376, 12, 8758).build());
        stringList.add(new people.Builder("Andri", 11236, 132, 8078).build());

        System.out.println("add worker\n");
        Add(stringList);
        System.out.println("Every worker In list\n");
        SeeAll(stringList);

        System.out.println("Every worker In list(Sort for exp)\n");
        Collections.sort(stringList);
        SeeAll(stringList);

        System.out.println("Every worker In list(Sort for lengh name)\n");
        nameCorparator corp = new nameCorparator();
        stringList.sort(corp);
        SeeAll(stringList);

        System.out.println("Found sergey`s\n");
        Found(stringList);
        System.out.println("Delete all\n");
        for(int i=stringList.size()-1; i>=0; i--) {
            DeleteLast(stringList);
        }
        check(stringList);

    }

    private static void DeleteLast(List<people> stringList) {
        stringList.remove(stringList.size() - 1);
    }

    private static void Add(List<people> stringList) {
        Scanner in = new Scanner(System.in);



        System.out.println("Input name\n");
        String name = "Sergey";// in.nextLine();

        int number = 0, leaseTerm = 0, codeP=0;
        String i1="Input number\n";
        String i2="Input exp\n";
        String i3="Input Code of pasport\n";

        boolean bError = true;
        while (bError) {
            System.out.println(i1);
            if (in.hasNextInt() &&  in.nextInt()>10000000 &&  in.nextInt()<100000000)
                number = in.nextInt();
            else {
                i1="Input correct number\n";
                System.out.println(i1);
                in.next();
                continue;
            }
            System.out.println(i2);
            if (in.hasNextInt() &&  in.nextInt()>=0)
                leaseTerm = in.nextInt();
            else {
                i2="Input correct exp\n";
                System.out.println(i2);
                in.next();
                continue;
            }

            System.out.println(i3);
            if (in.hasNextInt() &&  in.nextInt()>100000 &&  in.nextInt()<1000000)
                codeP = in.nextInt();
            else {
                i3="Input corect Code of pasport\n";
                System.out.println(i3);
                in.next();
                continue;
            }
            bError = false;
            stringList.add(new people.Builder(name, number, leaseTerm, codeP).build());
        }
    }


        private static void Found(List<people> stringList) {
        for(int i=0; i<stringList.size(); i++) {
            if (stringList.get(i).name=="Sergey") {
                System.out.println((stringList.get(i)).toString());
            }
        }
    }

    private static void check(List<people> stringList) {
        System.out.println("list empty - "+ stringList.isEmpty());
    }

    private static void SeeAll(List<people> stringList) {
        for(int i=0; i<stringList.size(); i++) {
            System.out.println((stringList.get(i)).toString());
        }
    };
};