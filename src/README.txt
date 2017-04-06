Fire ID: Group 41
 	Fressia Merino (espinosa@student.chalmers.se)
	Therese Tengdahl (theten@student.chalmers.se)

	
public static String toString(ListNode l)
	Vi skapade en tom sträng för att minst ha den att skicka tillbaka, ifall den givna ListNode:n inte innehåller några element.
	
public static boolean contains(ListNode l,char c)
	För att inte mutera l kopierar vi den till en annna ListNode. Sen kollar vi varje element som är char:s, för att kunna jämföra med den givna char:en.
	
public static ListNode copyUpperCase(ListNode l)
	bigCopy används för att hålla koll på starten av den nya listan, medans ptr1 används för att lägga till nya element när sådana hittas. ptr2 används för att inte mutera head.

public static ListNode addFirst(ListNode l,char c)
	Först skapar vi en ListNode och lägger till det givna elementet, sen lägger vi till den gamla ListNode:n efter det, pekar vi om till första elementet och skickar tillbaka den muterade ListNode:n.

private static ListNode getLastNode(ListNode l)
	Den stegar bara igenom ListNode:n, genom en kopia för att inte mutera, och skickar tillbaka en referens till sista noden.

public static ListNode addLast(ListNode l,char c)
	Använder getLastNode för det är väldigt smidigt. 

public static ListNode concat(ListNode l1,ListNode l2)
	Använder också getLastNode, för det är smidigt här också.

public static ListNode addAll(ListNode l1,ListNode l2)
	Den är nästan precis som concat fast den kopierar l2 istället, och tar inte bort elementen i l2.

public static ListNode reverse(ListNode l)
	Den kopierar, startar om och skriver till reverse varje loop för att lägga till elementen först i listan.