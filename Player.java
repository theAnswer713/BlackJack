package com.lucag;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name=name;
        hand=new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public ArrayList getHand() {
        return hand;
    }

    public int blackjackValue() {
        int value=0;
        int aces=0;
        for(Card x:hand) {
            if(x.getValue()>=2&&x.getValue()<=10) value+=x.getValue();
            else if(x.getValue()>10) value+=10;
            else if(x.getValue()==1) {
                aces++;
                value++;
            }
        }
        while(aces!=0) {
            if(value<=11) value+=10;
            aces--;
        }
        return value;
    }

    @Override
    public String toString() {
        return name+": "+hand+" ("+blackjackValue()+")";
    }
}
