/**
 * A collection of utility functions for C style primitive list handling.
 *
 * @author(s)
 * @version 2016-04-19
 */
public class Lists {

    // Create an empty list (a null terminated list head).
    public static ListNode mkEmpty() {
        return toList("");
    }

    // Returns true if l refers to a null terminated list head, false ow.
    public static boolean isEmpty(ListNode l) {
        if ( l == null )
            throw new ListsException("Lists: null passed to isEmpty");
        return l.next == null;
    }

    // Two lists are equal if both are empty, or if they have equal lengths
    // and contain pairwise equal elements at the same positions.
    public static boolean equals(ListNode l1,ListNode l2) {
        if ( l1 == null || l2 == null )
            throw new ListsException("null passed to equals");
        if ( isEmpty(l1) && isEmpty(l2) )
            return true;
        else if ( isEmpty(l1) || isEmpty(l2) )
            return false;
        else { // both lists are non-empty
            ListNode p1 = l1.next, p2 = l2.next;
            while ( p1 != null && p2 != null ) {
                char c1 = p1.element, c2 = p2.element;
                if ( p1.element != p2.element )
                    return false;
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1 == null && p2 == null;
        }
    }

    // Se f�rel. OH
    public static ListNode toList(String chars) {
        ListNode head, ptr1;     // head pekar alltid p� listans huvud
        head = new ListNode();   // Listans huvud (inneh�ller ej data)
        head.next = null;
        ptr1 = head;             // ptr pekar p� sista noden

        // Bygg en lista av tecken
        for ( int i = 0; i < chars.length(); i++ ) {
            ptr1.next = new ListNode();          // Addera en ny nod sist
            ptr1 = ptr1.next;                    // Flytta fram till den nya noden
            ptr1.element = chars.charAt(i);      // S�tt in tecknet
            ptr1.next = null;                    // Avsluta listan
        } 
        return head;
    }

    // Se f�rel. OH
    public static ListNode copy(ListNode l) {
        if ( l == null )
            throw new ListsException("Lists: null passed to copy");
        ListNode head,ptr1,ptr2;
        head = new ListNode();             // Kopian
        head.next = null;
        ptr1 = head;

        ptr2 = l.next;  // f�rsta listelementet i originallistan
        while ( ptr2 != null ) {
            ptr1.next = new ListNode();    // Ny nod i kopian
            ptr1 = ptr1.next;              // Flytta fram
            ptr1.element = ptr2.element;   // Kopiera tecknet
            ptr1.next = null;              // Avsluta
            ptr2 = ptr2.next;              // Flytta fram i originallistan
        }
        return head;
    }

    // Se f�rel. OH
    public static ListNode removeAll(ListNode l,char c) {
        if ( l == null )
            throw new ListsException("Lists: null passed to removeAll");
        ListNode p = l;
        while ( p.next != null ) {
            ListNode temp = p.next;      // Handtag p� n�sta nod
            if ( temp.element == c )     // Skall den tas bort?
                p.next = temp.next;      // L�nka frbi
            else
                p = p.next;              // Nej, g� vidare *
        }
        // * p f�r ej flyttas om den efterf�ljande noden togs bort!
        return l;
    }

    // ---------------- Uppgifter ----------------- 

    // Testmetod: JunitListTest.testToString()
    public static String toString(ListNode l) {

        String theString = "";

        while (l.element != null) {
            theString.concat(l.element);
            l = l.next;
        }
        return theString;
    }
    // Returnerar en sträng med tecknen i l. Metoden muterar ej l.

    // Testmetod: JunitListTest.testContains()
    public static boolean contains(ListNode head,char c) {
        return false;
    }
    // Returnerar true om l innehåller c, false annars. Metoden muterar ej l.

    // Testmetod: JunitListTest.testCopyUpperCase()
    public static ListNode copyUpperCase(ListNode head) {
        return null;
    }
    // Returnerar en ny lista med alla tecken i l som är stora bokstäver (A-Z).
    // Metoden muterar ej l.

    // Testmetod: JunitListTest.testAddFirst()
    public static ListNode addFirst(ListNode l,char c) {  
        return null;
    }
    // Adderar c först i l. Metoden muterar l och returnerar en referens till l.

    // This is a private utility method.
    private static ListNode getLastNode(ListNode head) {
        return null;
    }
    // Returnerar en referens till den sista noden i l (listhuvudet om l refererar till en tom lista.)
    // Metoden muterar ej l

    // Testmetod: JunitListTest.testAddLast()
    public static ListNode addLast(ListNode l,char c) {  
        return null;
    }
    // Adderar c sist i l. Metoden muterar l och returnerar en referens till l.

    // Testmetod: JunitListTest.testConcat()
    public static ListNode concat(ListNode l1,ListNode l2) {  
        return null;
    }
    // Sätter samman l1 med l2 så att alla noderna i l2 kommer efter noderna i l1.
    // Efter operationen refererar l2 till en tom lista. Metoden muterar både l1 och l2,
    // och returnerar en referens till l1.
    //Exempel:
    //    före                               efter
    // l1 = [a,b,c] l2 = [d,e]            l1 = [a,b,c,d,e] l2 = []

    // Testmetod: JunitListTest.testAddAll()
    public static ListNode addAll(ListNode l1,ListNode l2) { 
        return null;
    }
    // Adderar alla elementen i l2 till slutet av l1. Metoden muterar l1 men ej l2,
    // och returnerar en referens till l1.
    //Exempel:
    // före                           efter
    // l1 = [a,b,c] l2 = [d,e]        l1 = [a,b,c,d,e] l2 = [d,e]

    // Testmetod: JunitListTest.testReverse()
    public static ListNode reverse(ListNode head) {  
        return null;
    }
    // Returnerar en ny lista med elementen i l i omvänd ordning.
    // Metoden skall ej mutera l.
}
