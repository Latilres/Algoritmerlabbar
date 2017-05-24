Fire ID: Group 41
 	Fressia Merino (espinosa@student.chalmers.se)
	Therese Tengdahl (theten@student.chalmers.se)

	
Uppgift 1
Med tanke p� att alla algoritmer hade 0 �s f�r N=10 s� st�mde det inte s� bra till N=100.
F�r N=100 till N=1000 st�mmer det ganska bra (man f�r avrunda ganska grovt) f�r alla utom algoritm 2 som g�r fr�n 9 till 572 �s, men det �r gissningsvis ocks� relativt r�tt fast det inte avrundas lika bra. Rent allm�nt p� algoritmerna s� st�mmer den f�rv�ntade �kningen i ber�kningstid b�ttre ju st�rre N blir.
�ven med ett lite h�rdare belastat system har algoritm 2 inte en f�rv�ntad �kning mellan N=100 och N=1000 (13-696�s), men d�refter har den en f�rv�ntad �kning.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Uppgift 2 - 4 (dock med saker ig�ng p� datorn, men inget �verdrivet kr�vande)
	Bad ger upp vid: (2550 ms vid Size = 64)
		Size = 128
		EvenBetter: 3039
		Even better time = 73 ms
		Better: 3039
		Better time = 4534 ms
		Bad: 3039
		Bad time = 150474 ms
	Better ger upp vid: (4534 ms vid Size = 128)
		Size = 256
		EvenBetter: 4428
		Even better time = 1186 ms
		Better: 4428
		Better time = 149641 ms
	EvenBetter get upp vid: (30757 ms vid Size = 512)
		Size = 1024
		EvenBetter: 9274
		Even better time = 1026527 ms


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Uppgift 5
1.
En sak som kan vara kul att h�lla koll p� �r att linj�rs�kningen tar samma tid oavsett om dictionary �r ordnad eller inte, medans bin�rs�kningen inte funkar.

Det uppdaterade nu �r taget fr�n solvePuzzle() och solveDirection.
N �r kvadratiskt eftersom str�ngl�ngden inte ger ett �kande bidrag efter ett tag (det l�ngsta ordet �r omkring 30), hade man inte haft det borde vi haft N^3 ist�llet.

Linj�rs�kning:
	O(M*N^2) 

Bin�rs�kning:
Den �r logaritmisk => O(log M)
	O(log M*N^2)

2.
D� de f�rsta v�rdena (innan tiden kommer upp i 0.1) �r v�ldigt os�kra kollar vi p� v�rdena efter.
~~~~~~
Linj�rs�kning:
	Medelkvoten = 8.5
	D�rf�r b�r n�sta storlek ta ca 7108,6s
~~~~~~
Bin�rs�kning:
	Medelkvoten = 4.2
	D�rf�r b�r n�sta storlek ta ca 416,18s
~~~~~~
Bin�rs�kning och prefixtestning:
	Medelkvoten = 3.9
	D�rf�r b�r n�sta storlek ta ca 704,3s
	Detta gick inte att testa i BlueJ d� den fick slut p� minne, 
	men i IntelliJ fick vi: 431.5s..
	S� d�rf�r testade vi �ven 4096.txt i IntelliJ och fick 102.5s (till skillnad fr�n 180.6s)
	Dessa v�rden har en kvot p� 4.2, vilket ligger strax �ver intervallet f�r de ifr�n BlueJ
	(som g�tt upp till 4.1), s� det k�nns som ett v�ldigt rimligt resultat








~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Resultat fr�n uppgift 1:
	S� lite ig�ng som m�jligt och nystartad dator
Max sum is 11; it goes from 0 to 6
Max sum is 11; it goes from 0 to 6
Max sum is 11; it goes from 0 to 6
Max sum is 11
Algorithm #3	N = 10, time = 0 microsec
Algorithm #4	N = 10, time = 0 microsec
Algorithm #2	N = 10, time = 0 microsec
Algorithm #1	N = 10, time = 0 microsec

Algorithm #3	N = 100, time = 2 microsec
Algorithm #4	N = 100, time = 8 microsec
Algorithm #2	N = 100, time = 9 microsec
Algorithm #1	N = 100, time = 210 microsec

Algorithm #3	N = 1000, time = 26 microsec
Algorithm #4	N = 1000, time = 87 microsec
Algorithm #2	N = 1000, time = 572 microsec
Algorithm #1	N = 1000, time = 181826 microsec

Algorithm #3	N = 10000, time = 258 microsec
Algorithm #4	N = 10000, time = 961 microsec
Algorithm #2	N = 10000, time = 54202 microsec
Algorithm #1	N = 10000, time = 178674000 microsec

Algorithm #3	N = 100000, time = 2568 microsec
Algorithm #4	N = 100000, time = 9688 microsec
Algorithm #2	N = 100000, time = 5507000 microsec

Algorithm #3	N = 1000000, time = 39712 microsec
Algorithm #4	N = 1000000, time = 100650 microsec
Algorithm #2	N = 1000000, time = 554150000 microsec

	Eve, PS, GW2, Discord, Chrome och lite annat b�s ig�ng samtidigt
Max sum is 11; it goes from 0 to 6
Max sum is 11; it goes from 0 to 6
Max sum is 11; it goes from 0 to 6
Max sum is 11
Algorithm #3	N = 10, time = 0 microsec
Algorithm #4	N = 10, time = 0 microsec
Algorithm #2	N = 10, time = 0 microsec
Algorithm #1	N = 10, time = 1 microsec

Algorithm #3	N = 100, time = 4 microsec
Algorithm #4	N = 100, time = 10 microsec
Algorithm #2	N = 100, time = 13 microsec
Algorithm #1	N = 100, time = 286 microsec

Algorithm #3	N = 1000, time = 37 microsec
Algorithm #4	N = 1000, time = 112 microsec
Algorithm #2	N = 1000, time = 696 microsec
Algorithm #1	N = 1000, time = 240647 microsec

Algorithm #3	N = 10000, time = 312 microsec
Algorithm #4	N = 10000, time = 1084 microsec
Algorithm #2	N = 10000, time = 63730 microsec
Algorithm #1	N = 10000, time = 226828000 microsec

Algorithm #3	N = 100000, time = 3209 microsec
Algorithm #4	N = 100000, time = 12057 microsec
Algorithm #2	N = 100000, time = 7726000 microsec

Algorithm #3	N = 1000000, time = 35495 microsec
Algorithm #4	N = 1000000, time = 130225 microsec
Algorithm #2	N = 1000000, time = 765889000 microsec
