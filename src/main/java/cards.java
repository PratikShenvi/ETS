


import java.util.Scanner;
import java.util.Stack;

public class cards {
    
    //this shuffles the entire pack of cards
    public static Stack shuffleEntire(String[] deck){
        
        for(int i=0;i<deck.length;i++)
        {
            int index=(int) (Math.random()*13);
            String temp=deck[i];
            deck[i]=deck[index];
            deck[index]=temp;
        }
        Stack deckToDeal=new Stack();
        for(int i=0;i<deck.length;i++)
        {
            deckToDeal.push(deck[i]);
        }
        return deckToDeal;
    }
    
    //this shuffles the deck which is being dealt viz. the remaining cards in the deck
    public static void shuffle(Stack deckToDeal)
    {
        if(deckToDeal.size()>1){
            
            String[] remaining=new String[deckToDeal.size()];
            int j=0;
            while(!deckToDeal.isEmpty()){
                remaining[j]=(String) deckToDeal.pop();
                j++;
            }
            for(int i=0;i<remaining.length;i++)
            {
                int index=(int) (Math.random()*13);
                String temp=remaining[i];
                remaining[i]=remaining[index];
                remaining[index]=temp;
            }
            for(int i=0;i<remaining.length;i++)
            {
                deckToDeal.push(remaining[i]);
            }
            
        }
    }
    
    // returns one(top one) card from the deck which is being dealt
    public static String dealOneCard(Stack deckToDeal){
        if(!deckToDeal.isEmpty()){
            String card=(String) deckToDeal.pop();
            return card;
        }
        return "none left";  //returns this when no card is left in the deck
    }
    
    public static void main(String[] args) {
        
        String[] suit={"Hearts","Spades","Clubs","Diamonds"};
        String[] rank={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        
        String[] deck=new String[52];
        //creating a pack of cards
        for(int i=0;i<52;i++){
            deck[i]=rank[i%13]+suit[i/13];
        }
        Stack deckToDeal=shuffleEntire(deck);
        
        System.out.println("Enter 1 to shuffle entire set of cards");
        System.out.println("Enter 2 to shuffle the deck being dealt");
        System.out.println("Enter 3 to draw a card from the deck being dealt");
        System.out.println("Enter 4 to draw all remaining cards from the deck being dealt");
        System.out.println("Enter 0 to quit");
        int input;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.print("Enter : ");
            input=sc.nextInt();
            switch(input){
                case 1:
                    deckToDeal=shuffleEntire(deck);
                    break;
                case 2:
                    shuffle(deckToDeal);
                    break;
                case 3:
                    String card=dealOneCard(deckToDeal);
                    System.out.println(card);
                    break;
                case 4:
                    if(!deckToDeal.isEmpty()){
                        String cards=dealOneCard(deckToDeal);
                        while(!cards.equals("none left")){
                            System.out.println(cards);
                            cards=dealOneCard(deckToDeal);
                        }
                    }
                    else{
                        System.out.println("none left");
                    }
                    break;
                case 0:
                    break;
                    
            }
            
        }while(input!=0);
        
        System.out.println("End");
        
        
    }
    
}
