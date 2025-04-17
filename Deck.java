package com.lucag;
import java.util.Stack;
import java.util.Random;

public class Deck {
    private Stack<Card> deck;

    public Deck() {
        deck= new Stack<Card>();
        for(int s=0;s<4;s++) {
            String suit="";
            if(s==0) suit="H";
            if(s==1) suit="D";
            if(s==2) suit="C";
            if(s==3) suit="S";
            for(int v=1;v<=13;v++) {
                deck.push(new Card(v,suit));
            }
        }
    }

    public Card dealCard() {
        return deck.pop();
    }

    public void Shuffle() {
        Random rand=new Random();
        Stack<Card> l=new Stack<Card>();
        Stack<Card> r=new Stack<Card>();
        int half=deck.size()/2;
        for(int count=1;count<=1000;count++) {
            for (int i=0;i<half+rand.nextInt(9)-4;i++) {
                l.push(deck.pop());
            }
            while (!deck.isEmpty()) {
                r.push(deck.pop());
            }
            while (!l.isEmpty() || !r.isEmpty()) {
                int n = Math.min(l.size(), rand.nextInt(3) + 1);
                for (int i = 0; i < n; i++) {
                    deck.push(l.pop());
                }
                n = Math.min(r.size(), rand.nextInt(3) + 1);
                for (int i = 0; i < n; i++) {
                    deck.push(r.pop());
                }
            }
        }
    }

    public void Cut() {

    }
}
