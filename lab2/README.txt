Fire ID: Group 41
 	Fressia Merino (espinosa@student.chalmers.se)
	Therese Tengdahl (theten@student.chalmers.se)

	
	Lite tankar om de olika klasserna:
SingleBuffer:
Vi b�rjade med att den hanterade String och sen gjorde vi den mer generell s� att den nu tar det argumentet man skickar in.

Main:
Det enda vi egentligen gjorde var lamda-uttrycket. D�r gjorde vi mest som det stod i labpm fast vi har "(person p)" ist�llet f�r "x". Annars utgick vi fr�n en for each loop med if i och konverterade det till lambda-uttryck.

StringComparator:
Fick vi fr�n labpm.

IntegerComparator:
Vi utgick fr�n StringComparator och gjorde om f�r int.

collection package:
Allt blev mycket snyggare och smidigare med den (koden hintade om att vi skulle anv�nda den ocks�).

CollectionOps:
F�r "print" s� itererar vi igenom alla element i v�ran collection och skriver ut dem, sen skriver vi bara ut "," om det finns fler element.
I "less" hade vi lite problem med strukturen p� anropet, men sen klurade vi ut det och d� fungerade det och vi suckade lite.
Till "filter" var det v�ldigt mycket ctrl+c -> ctrl+v med sm� modificationer (som att ta bort R i <T,R> fr�n "map", vi anv�nde ocks� Predicate ist�llet f�r Function), enda problemet vi hade d�r var att innan vi hade klassen i ett eget paket s� hade vi problem med att anv�nda den, men de bara f�rsvann i och med paketet.


