
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testDeckIsReturned() {
        String[] suit={"Hearts","Spades","Clubs","Diamonds"};
        String[] rank={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        
        String[] deck=new String[52];
        //creating a pack of cards
        for(int i=0;i<52;i++){
            deck[i]=rank[i%13]+suit[i/13];
        }
        
        cards classUnderTest = new cards();
        assertNotNull("deck(stack) should be returned", classUnderTest.shuffleEntire(deck));
    }
}
