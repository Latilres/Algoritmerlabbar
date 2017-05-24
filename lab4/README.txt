Fire ID: Group 41
 	Fressia Merino (espinosa@student.chalmers.se)
	Therese Tengdahl (theten@student.chalmers.se)

	
Uppgift 1
Med tanke på att alla algoritmer hade 0 µs för N=10 så stämde det inte så bra till N=100.
För N=100 till N=1000 stämmer det ganska bra (man får avrunda ganska grovt) för alla utom algoritm 2 som går från 9 till 572 µs, men det är gissningsvis också relativt rätt fast det inte avrundas lika bra. Rent allmänt på algoritmerna så stämmer den förväntade ökningen i beräkningstid bättre ju större N blir.
Även med ett lite hårdare belastat system har algoritm 2 inte en förväntad ökning mellan N=100 och N=1000 (13-696µs), men därefter har den en förväntad ökning.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Uppgift 2 - 4 (dock med saker igång på datorn, men inget överdrivet krävande)
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
En sak som kan vara kul att hålla koll på är att linjärsökningen tar samma tid oavsett om dictionary är ordnad eller inte, medans binärsökningen inte funkar.

Det uppdaterade nu är taget från solvePuzzle() och solveDirection.
N är kvadratiskt eftersom stränglängden inte ger ett ökande bidrag efter ett tag (det längsta ordet är omkring 30), hade man inte haft det borde vi haft N^3 istället.

Linjärsökning:
	O(M*N^2) 

Binärsökning:
Den är logaritmisk => O(log M)
	O(log M*N^2)

2.
Då de första värdena (innan tiden kommer upp i 0.1) är väldigt osäkra kollar vi på värdena efter.
~~~~~~
Linjärsökning:
	Medelkvoten = 8.5
	Därför bör nästa storlek ta ca 7108,6s
~~~~~~
Binärsökning:
	Medelkvoten = 4.2
	Därför bör nästa storlek ta ca 416,18s
~~~~~~
Binärsökning och prefixtestning:
	Medelkvoten = 3.9
	Därför bör nästa storlek ta ca 704,3s
	Detta gick inte att testa i BlueJ då den fick slut på minne, 
	men i IntelliJ fick vi: 431.5s..
	Så därför testade vi även 4096.txt i IntelliJ och fick 102.5s (till skillnad från 180.6s)
	Dessa värden har en kvot på 4.2, vilket ligger strax över intervallet för de ifrån BlueJ
	(som gått upp till 4.1), så det känns som ett väldigt rimligt resultat








~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Resultat från uppgift 1:
	Så lite igång som möjligt och nystartad dator
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

	Eve, PS, GW2, Discord, Chrome och lite annat bös igång samtidigt
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
