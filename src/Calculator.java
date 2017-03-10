import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Create	a	program	that	allows	users	to	enter	addition,	subtraction,	multiplication	and	division	operations.
For	example:
2+2=
4-7=
3*2=
3/4=
They should	also be	able to	type	in	the	names	of	objects:
2 dogs	+	3	dogs	=	5	dogs
3 cats+	4	dogs=7	cats	and	dogs
2 tables	+4	dogs+2	books=	8	tables,	dogs	and	books
2 tables*3	tables=6	tables
7 rabbits-3	rabbits=4	rabbits
Please	note	the	following:
1.  The	program	should	be	able	to	handle	different	spacing	for	input	(meaning	2+			3	=		should	work	just
like 2+3=)
2.  If	the	user	enters	objects	for	subtraction, make sure the	answer	does	not	become	negative.		For
example,	4-7=	is	fine,	but	4	dogs-7dogs	does	not	make sense since	the	answer	would	be	-3	dogs.
3.  Make	sure	division	can	return	decimal	values.		For	example, 7/2=	should	return	would	be	3.5	NOT	3.
4.  If	the	user	enters	objects	for	division,	make	sure	you	do	not	allow	division	on	objects	that	would	have	a
remainder.		For	example,		7/2=3.5	is	fine,	but	7	dogs/2	dogs does	not	make	sense	since	the	answer
would	be	3.5	dogs.
5.  The	only	operation that	have can different	types of objects	is	+ (addition).		For	/	(division),	*
(multiplication)	and	-	(subtraction), the	objects	MUST be	the	same. For	example,	the	user	CANNOT
enter 2 tables * 3 rabbits= 6 tables	and	rabbits.
 */
public class Calculator {
    static Calculator c;
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
     c=new Calculator();


        while(true){
            boolean wasSub=false,wasMul=false,wasDiv=false, differentSubjects=false;
         System.out.println("Enter your question or exit to exit the program:");
         String line=c.reader.readLine();

         if("exit".equals(line)){break;}

            double numericVal=0;
            String value="";
            String lastOperation="";
            String lastSubject="";
            ArrayList<String> subjects=new ArrayList<>();
         char[]chars=line.toCharArray();

         for(int i=0;i<chars.length;i++){
             char c=chars[i];
//             number
             if(c>=48 && c<=57){

                 value+=c;}
                 else
//          string
             if((c>=97 && c<=122)||(c>=65 && c<=90)){lastSubject+=c;}else
//          operation + - * /
             if(c==43||c==45||c==42||c==47){
//
                 if(!"".equals(lastSubject)){
                 if(!subjects.isEmpty() && !subjects.contains(lastSubject))differentSubjects=true;
                 if(!subjects.contains(lastSubject) )subjects.add(lastSubject);

                     lastSubject="";}
                switch (lastOperation){
                     case"":{numericVal=Double.parseDouble(value);value="";break;}
                     case"add":{numericVal+=Double.parseDouble(value);value="";break;}
                     case"sub":{numericVal-=Double.parseDouble(value);value="";wasSub=true;break;}
                     case"mul":{numericVal*=Double.parseDouble(value);value="";wasMul=true;break;}
                     case"div":{numericVal/=Double.parseDouble(value);value="";wasDiv=true;break;}
                 }
                 switch (c){
                     case 43:{lastOperation="add";break;}
                     case 45:{lastOperation="sub";break;}
                     case 42:{lastOperation="mul";break;}
                     case 47:{lastOperation="div";break;}
                 }
                    }else
              if(c==32){}else
              if(c==61){
                  if(!"".equals(lastSubject)){
                      if(!subjects.isEmpty() && !subjects.contains(lastSubject))differentSubjects=true;
                      if(!subjects.contains(lastSubject) )subjects.add(lastSubject);

                      }

                  switch (lastOperation){
                      case"":{numericVal=Double.parseDouble(value);break;}
                      case"add":{numericVal+=Double.parseDouble(value);break;}
                      case"sub":{numericVal-=Double.parseDouble(value);wasSub=true;break;}
                      case"mul":{numericVal*=Double.parseDouble(value);wasMul=true;break;}
                      case"div":{numericVal/=Double.parseDouble(value);wasDiv=true;break;}
                     }
                  break;
                    }
     }
     if(numericVal%1==0){}
     String result="Answer: "+line;
      if(numericVal%1==0){result+=(int)numericVal+" ";}else{
          result+=numericVal+" ";
      }
        if((differentSubjects &&(wasSub || wasDiv ||wasMul)
        ||
                (numericVal<0 && !subjects.isEmpty()))
        ||
                (numericVal%1!=0 &&!subjects.isEmpty())){
            System.out.println("INVALID INPUT. NO ANSWER.");
            continue;
      }else

        if(!subjects.isEmpty()){
            result+=subjects.get(0);
            for(int i=1;i<subjects.size();i++) result+=" and "+subjects.get(i);
        }
            System.out.println(result);
        }
        c.reader.close();
        System.out.println("Exiting…");
}

}
