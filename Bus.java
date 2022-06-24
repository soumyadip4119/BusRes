import java.io.*;
class Bus
{
    BufferedReader xy=new BufferedReader(new InputStreamReader(System.in));
    String name;
    String sloc;
    String eloc;
    String passenger[][];
    String sex[][];
    String age[][];
    String stops[];
    String dest[][];
    int m,noseat,nostop;
    String seat[][];
    String tt[];
    String dd[];
    String km[];
    String fare[];
    Bus(String n,String stopage[],String time[],String date[],String dist[],String fph[])throws IOException
    {
        name=n;
        m=6;
        noseat=m*m;
        nostop=stopage.length;
        dest=new String[m][m];
        seat=new String[m][m];
        passenger=new String[m][m];
        sex=new String[m][m];
        age=new String[m][m];
        stops=stopage;
        tt=time;
        dd=date;
        km=dist;
        sloc=stopage[0];
        eloc=stopage[nostop-1];
        fare=fph;
        //stops=new String[stop];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                seat[i][j]="\u25A1";
                passenger[i][j]="";
                sex[i][j]="";
                age[i][j]="";
                dest[i][j]="";
            }
        }
        /*System.out.println("Enter stop names");
        for(int i=0;i<stop;i++)
        {
        stops[i]=xy.readLine();
        if(i==0)
        sloc=stops[i];
        else if(i==(stop-1))
        eloc=stops[i];
        }*/
    }

    void seats()throws IOException
    {
        System.out.println("");
        System.out.println("\t[NOTE: "+"\u25A1"+" shows seat is empty. "+"\u2713"+" shows seat is booked.]");
        System.out.print("  ");
        for(int k=0;k<m;k++)
        {   
            if(k==(m/2))
                System.out.print("    "+k);
            else 
                System.out.print(" "+k);
        }
        System.out.println("");
        for(int i=0;i<m;i++)
        {
            System.out.print(i+" ");
            for(int j=0;j<m;j++)
            {
                if(j==(m/2))
                    System.out.print("    "+seat[i][j]);
                else 
                    System.out.print(" "+seat[i][j]);
            }
            System.out.println();
        }
        if(noseat==0)
            System.out.println("!!BUS FULL!!");
    }

    void bookseats()throws IOException
    {
        String dt,nm,ag,sx;
        boolean valid=false;
        ag="";
        seats();
        if(noseat==0)
            System.out.println("!!BUS FULL!!");
        else
        {
            System.out.println("");
            System.out.println("Enter how many seats you want to book");
            int no=Integer.parseInt(xy.readLine());
            if(no!=0)
            {
                if(no<=noseat)
                {
                    int tick[][]=new int[no][2];
                    do{
                        System.out.println("Enter destination");
                        dt=xy.readLine();
                        if(dt.equals("EXIT"))
                        {
                            return;
                        }
                        else
                        {
                            for(int i=1;i<nostop;i++)
                            {
                                if(stops[i].equalsIgnoreCase(dt))
                                {
                                    valid=true;
                                    break;
                                }
                                else if(i==nostop-1)
                                    System.out.println("PLEASE ENTER CORRECT DESTINATION.");
                            }
                        }
                    }while(valid!=true);
                    int r=0,c=0;
                    String id="";
                    for(int i=1;i<=no;i++)
                    {
                        boolean sid=false;
                        System.out.println("Enter Passenger"+i+"'s name, age, sex:");
                        nm=xy.readLine();
                        //System.out.println("Enter Passenger's age");
                        boolean ageint=true;
                        int agint=0;
                        do{
                            try{
                                ag=xy.readLine();
                                agint=Integer.parseInt(ag);
                                ageint=true;
                            }catch(Exception e)
                            {
                                ageint=false;
                                System.out.println("Age must be an integer");
                            }
                        }while(ageint!=true);
                        //System.out.println("Enter Passenger's sex");
                        sx=xy.readLine();
                        System.out.println("Choose your seats:");
                        do{
                            try{
                                System.out.println("Enter row number");
                                r=Integer.parseInt(xy.readLine());
                                System.out.println("Enter column number");
                                c=Integer.parseInt(xy.readLine());
                            }
                            catch(Exception e)
                            {
                                r=9999;
                                c=9999;
                            }
                            if(r<m&&c<m)
                            {
                                if(seat[r][c].equals("\u25A1"))
                                {
                                    seat[r][c]="\u2713";
                                    id=Integer.toString(r)+"*"+Integer.toString(c);
                                    System.out.println("Seat booked. Seat id: "+id);
                                    passenger[r][c]=nm;
                                    age[r][c]=ag;
                                    sex[r][c]=sx;
                                    dest[r][c]=dt;
                                    tick[i-1][0]=r;
                                    tick[i-1][1]=c;
                                    --noseat;
                                    sid=true;
                                }
                                else
                                {
                                    System.out.println("Seat is already booked.Try another seat.");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid seat number.Try another time.");
                            }
                        }
                        while(sid!=true);
                        /*System.out.println("Enter row number");
                        r=Integer.parseInt(xy.readLine());
                        System.out.println("Enter column number");
                        c=Integer.parseInt(xy.readLine());
                        if(r<m&&c<m)
                        {
                        if(seat[r][c].equals("\u25A1"))
                        {
                        seat[r][c]="\u2713";
                        id=Integer.toString(r)+"*"+Integer.toString(c);
                        System.out.println("Seat booked. Seat id: "+id);
                        passenger[r][c]=nm;
                        age[r][c]=ag;
                        sex[r][c]=sx;
                        dest[r][c]=dt;
                        tick[i-1][0]=r;
                        tick[i-1][1]=c;
                        --noseat;
                        }
                        else
                        {
                        System.out.println("Seat is already booked.Try another seat.");
                        i--;
                        }
                        }
                        else
                        {
                        System.out.println("Invalid seat number.Try another time.");
                        i--;
                        }*/
                    }
                    System.out.println("Congratulations! Your seats were booked.");
                    System.out.println("Your ticket has been generated:-");
                    for(double i=1.0;i<999999999.0;i++)
                    {
                    }
                    System.out.println("\f");
                    ticket(no,dt,tick);
                }
                else
                    System.out.println(no+" seats are unavailable.Sorry!");
            }
            else
                System.out.println("Seats were not booked");
        }
    }

    String getname()throws IOException
    {
        return name;
    }

    String getstime()throws IOException
    {
        return sloc;
    }

    String getetime()throws IOException
    {
        return eloc;
    }

    /*void remove()throws IOException
    {
    name="";
    m=10;
    noseat=m*m;
    seat=new String[m][m];
    for(int i=0;i<m;i++)
    {
    for(int j=0;j<m;j++)
    {
    seat[i][j]="#";
    }
    }
    }*/
    void editseat(int r,int c)throws IOException
    {
        seat[r][c]="\u25A1";
        System.out.println("Seat reservation cancelled");
    }

    int getseats()throws IOException
    {
        return (m*m-noseat);
    }

    boolean fill(int r,int c)throws IOException
    {
        if(seat[r][c].equals("\u2713"))
            return true;
        else
            return false;
    }

    void everything()throws IOException
    {
        System.out.print(name);
        System.out.println("\t");
        System.out.println("\tStart location: "+sloc+"\t End location: "+eloc);
        System.out.println("\tTotal number of stops: "+nostop);
        for(int i=0;i<nostop;i++)
        {
            if(i>0)
                System.out.print("\t"+stops[i]+"[Rs."+fare[i]+"/person]");
            else
                System.out.print("\t"+stops[i]);
        }
        System.out.println();
        System.out.println("\tTime of departure: "+tt[0]);
        System.out.println("\tDate of departure: "+dd[0]);
    }

    void ticket(int len, String upto, int ar[][])throws IOException
    {
        int adult=0,child=0;
        int r=0,c=0,z=0;
        String distance="";
        for(int i=0;i<len;i++)
        {
            r=ar[i][0];
            c=ar[i][1];
            if(Integer.parseInt(age[r][c])<18)
                ++child;
            else
                ++adult;
        }
        for(z=0;z<nostop;z++)
        {
            if(stops[z].equalsIgnoreCase(upto))
            {
                distance=km[z];
                break;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("____________________________________________________________________________");
        System.out.println();
        System.out.println("\t                HAPPY JOURNEY");
        System.out.println();
        System.out.println("\tBUS NAME"+"\tDATE"+"\tKM"+"\tADULT"+"\tCHILD");
        System.out.println("\t"+name+"\t"+dd[0]+"\t"+distance+"\t"+adult+"\t"+child);
        System.out.println();
        System.out.println("\t\t\t\t\tJOURNEY CUM RESERVATION TICKET");
        System.out.println("\t"+(sloc.toUpperCase())+"\t\t"+(upto.toUpperCase()));
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("\tSEAT"+"\tSEX"+"\tAGE"+"\t\t"+"|"+"\tTOTAL CASH");
        System.out.println("----------------------------------------------------------------------------");
        for(int i=0;i<len;i++)
        {
            r=ar[i][0];
            c=ar[i][1];
            System.out.println("\t"+r+"*"+c+"\t"+sex[r][c]+"\t"+age[r][c]+"\t\t|");
        }
        int cash=len*(Integer.parseInt(fare[z]));
        System.out.println("\t\t\t\t\t|"+"\t"+cash);
        System.out.println("\t\t\t\t\t|"+"\t"+numberToWord(cash));
        System.out.println();
        System.out.println("\tBRD: "+(sloc.toUpperCase())+"   SCH DEP:"+dd[0]+" "+tt[0]+"   ARR:"+dd[z]+" "+tt[z]);
        System.out.println("____________________________________________________________________________");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    String numberToWord(int number) {
        String words = "";
        String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", 
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", 
                "eighteen", "nineteen" };
        String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty","sixty", "seventy", "eighty", "ninety" };
        if (number == 0) {
            return "zero";
        }
        if (number < 0) { // convert the number to a string 
            String numberStr = "" + number; 
            numberStr = numberStr.substring(1); 
            return "minus " + numberToWord(Integer.parseInt(numberStr));
        } 
        if ((number / 1000000) > 0) {
            words += numberToWord(number / 1000000) + " million ";
            number %= 1000000;
        }
        if ((number / 1000) > 0) {
            words += numberToWord(number / 1000) + " thousand ";
            number %= 1000;
        }
        if ((number / 100) > 0) {
            words += numberToWord(number / 100) + " hundred ";
            number %= 100;
        }
        if (number > 0) {
            if (number < 20) { 
                words += unitsArray[number];
            } else { 
                words += tensArray[number / 10]; 
                if ((number % 10) > 0) {
                    words += "-" + unitsArray[number % 10];
                }  
            }
        }
        return words;
    }
    /*void ticket(int len, String upto, int ar[][])
    {
    System.out.println();
    System.out.println("--------------------------------------------------------------------------");
    System.out.println("                HAPPY JOURNEY");
    System.out.println("BUS NUMBER: "+name);
    System.out.println("TOTAL NUMBER OF PASSENGERS: "+len);
    System.out.println("NAME"+"\t"+"\tAGE"+"\t"+"\tSEX"+"\t"+"\tADULT/CHILD");
    for(int i=0;i<len;i++)
    {
    int r=ar[i][0];
    int c=ar[i][1];
    System.out.print(passenger[r][c]+"\t");
    System.out.print(age[r][c]+"\t");
    System.out.print(sex[r][c]+"\t");
    if(Integer.parseInt(age[r][c])<18)
    System.out.print("CHILD"+"\t");
    else
    System.out.print("ADULT"+"\t");
    System.out.println();
    }
    System.out.println("BOARDING FROM:"+sloc);
    System.out.println("DISTINATION UPTO: "+upto);
    System.out.println("KILOMETERS: ");
    System.out.println("FARE PER HEAD: ");
    System.out.println("TOTAL FARE: ");
    System.out.println("WISH YOU A HAPPY JOURNEY!!!");
    System.out.println("--------------------------------------------------------------------------");
    }*/
}