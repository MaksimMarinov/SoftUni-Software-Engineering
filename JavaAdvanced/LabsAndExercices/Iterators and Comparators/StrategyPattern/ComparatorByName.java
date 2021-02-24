package StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int res = o1.getName().length()-o2.getName().length();
        if(res==0){
            char p1FirstLetter = o1.getName().toLowerCase().charAt(0);
            char p2FirstLetter = o2.getName().toLowerCase().charAt(0);
            res = p1FirstLetter-p2FirstLetter;
        }
        return res;
    }
}
