/*
author: Annika Mütze <muetze.annika@gmail.com>
date: 09.2012

Litmus-Test
*/

#define ADRESSE_X 1
#define ADRESSE_Y 2
#define BUFF_SIZE 5 	//size of Buffer
#define MEM_SIZE 5		//size of memory 
#include "x86_tso_buffer.pml"


/*Channel der die reads und writes verschickt (Type (also write,read); Adresse; Wert;... )*/
chan channelT1 = [0] of {mtype, short, short, short};
chan channelT2 = [0] of {mtype, short, short, short};
short r1 = 0;
short r2 = 0;


proctype process1(chan ch)
{
	write(ADRESSE_X, 1);
	write(ADRESSE_Y, 1);
}


proctype process2(chan ch)
{	
	read(ADRESSE_Y, r1);
	read(ADRESSE_X, r2);	
}

init
{
	atomic{
	run process1(channelT1);
	run process2(channelT2);
	run bufferProcess(channelT1);
	run bufferProcess(channelT2)
	}
}
	// r1 == 1  (r2 == 0)	-> not allowed (x muss schon geschrieben sein, wenn y = 1 gelesen wird
	// r1 == 1  (r2 == 1)	-> ok
	// r1 == 0  (r2 == 1)	-> ok
	// r1 == 0  (r2 == 0)	-> ok
	
ltl check_1{ [] (process1 @ end && process2 @ end -> ( ! (r1 == 1 && r2 == 0)))}
//ltl check_2{ [] (process1 @ end && process2 @ end -> ( r1 == 0 -> (r2 == 1 || r2 == 0)))}

//ltl check { [] (r1 == 1 -> r2 != 0)}; 