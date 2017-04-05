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
        if ( l == null )
            throw new ListsException("Lists: null passed to toString");

        ListNode p = l;
        String theString = "";          // En tom sträng
        while (p.next != null) {        // Finns det fler element?
            p = p.next;                 // Hoppa över huvud/Gå vidare
            theString += p.element;     // Lägg till elementet till strängen
        }
        return theString;
    }

    // Testmetod: JunitListTest.testContains()
    public static boolean contains(ListNode l, char c) {
        if ( l == null )
            throw new ListsException("Lists: null passed to contains");

        ListNode p = l;
        while (p.next != null) {    // Finns det fler element?
            if (p.element == c)     // Är elementet lika med c?
                return true;        // Svar: ja
            else
                p = p.next;         // Annars gå vidare.
        }
        return false;
    }

    // Testmetod: JunitListTest.testCopyUpperCase()
    public static ListNode copyUpperCase(ListNode head) {
        if ( head == null )
            throw new ListsException("Lists: null passed to copyUpperCase");

        ListNode bigCopy,ptr1,ptr2;
        bigCopy = new ListNode();             // Kopian
        bigCopy.next = null;
        ptr1 = bigCopy;

        ptr2 = head.next;  // f�rsta listelementet i originallistan
        while ( ptr2 != null ) {
            if (Character.isUpperCase(ptr2.element)) {
                ptr1.next = new ListNode();    // Ny nod i kopian
                ptr1 = ptr1.next;              // Flytta fram
                ptr1.element = ptr2.element;   // Kopiera tecknet
                ptr1.next = null;              // Avsluta
            }
            ptr2 = ptr2.next;              // Flytta fram i originallistan
        }
        return bigCopy;
    }

    // Testmetod: JunitListTest.testAddFirst()
    public static ListNode addFirst(ListNode l,char c) { 
        if ( l == null )
            throw new ListsException("Lists: null passed to addFirst");

        ListNode k = new ListNode();
        k.element = c;						// k innehåller c
        k.next = l.next;					// pekar om till l
        l.next = k;							// muterar l
        return l;							// returnera l
    }

    // This is a private utility method.
    private static ListNode getLastNode(ListNode l) {
        if ( l == null )
             throw new ListsException("Lists: null passed to getLastNode");

        ListNode k = l;
        while (k.next != null) {
            k = k.next;
        }
        return k;
    }

    // Testmetod: JunitListTest.testAddLast()
    public static ListNode addLast(ListNode l,char c) {
        if ( l == null )
            throw new ListsException("Lists: null passed to addLast");

        ListNode k = l;
        while (l.next != null) {
            l = l.next;
        }
        l.element = c;						// muterar l
        l.next = null;
        return k;							// returnera l
    }

    // Testmetod: JunitListTest.testConcat()
    public static ListNode concat(ListNode l1,ListNode l2) {      	 
        if ( l1 == null || l2 == null )
             throw new ListsException("Lists: null passed to contact");

        getLastNode(l1).next = l2.next;
        l2.next = null;
        return l1;
    }

    // Testmetod: JunitListTest.testAddAll()
    public static ListNode addAll(ListNode l1,ListNode l2) { 
    	 if ( l1 == null || l2 == null )
             throw new ListsException("Lists: null passed to addAll");

    	 getLastNode(l1).next = l2.next;
        return l1;
        
    }

    // Testmetod: JunitListTest.testReverse()
    public static ListNode reverse(ListNode head) {  
    	 if ( head == null )
             throw new ListsException("Lists: null passed to reverse");

    	 ListNode l = head;
    	 ListNode buff = new ListNode();
    	 ListNode reverse = new ListNode();

    	 while (l.next != null){
    	     l = l.next;                    // Flytta fram
    	     reverse.element = l.element;   // Lägg nästa element i l längst fram i reverse
    	     buff = reverse;                // Kopiera reverse
    	     reverse = new ListNode();      // Starta om reverse
    	     reverse.next = buff;           // Lägg in kopian efter head till reverse
         }
    	 return reverse;
    }
}
