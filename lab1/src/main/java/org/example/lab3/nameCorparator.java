package org.example.lab3;

import org.example.lab1.people;

import java.util.*;

public class nameCorparator implements Comparator<people> {

    public int compare(people p1, people p2)
        {
            return p1.name.length()-p2.name.length();

    };

};