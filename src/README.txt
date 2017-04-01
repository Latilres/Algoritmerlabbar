Fire ID: Group 41
 	Fressia Merino (espinosa@student.chalmers.se)
	Therese Tengdahl (theten@student.chalmers.se)

	
	Lite tankar om de olika klasserna:
SingleBuffer:
Vi började med att den hanterade String och sen gjorde vi den mer generell så att den nu tar det argumentet man skickar in.

Main:
Det enda vi egentligen gjorde var lamda-uttrycket. Där gjorde vi mest som det stod i labpm fast vi har "(person p)" istället för "x". Annars utgick vi från en for each loop med if i och konverterade det till lambda-uttryck.

StringComparator:
Fick vi från labpm.

IntegerComparator:
Vi utgick från StringComparator och gjorde om för int.

collection package:
Allt blev mycket snyggare och smidigare med den (koden hintade om att vi skulle använda den också).

CollectionOps:
För "print" så itererar vi igenom alla element i våran collection och skriver ut dem, sen skriver vi bara ut "," om det finns fler element.
I "less" hade vi lite problem med strukturen på anropet, men sen klurade vi ut det och då fungerade det och vi suckade lite.
Till "filter" var det väldigt mycket ctrl+c -> ctrl+v med små modificationer (som att ta bort R i <T,R> från "map", vi använde också Predicate istället för Function), enda problemet vi hade där var att innan vi hade klassen i ett eget paket så hade vi problem med att använda den, men de bara försvann i och med paketet.


