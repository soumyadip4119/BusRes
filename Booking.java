import java.io.*;
class Booking
{
    BufferedReader xy=new BufferedReader(new InputStreamReader(System.in));
    Bus[] ob;
    int buses;
    Booking()throws IOException
    {
        ob=new Bus[6];
        buses=5;
        String b01[]={"Kolkata","Krishnanagar","Berhampore","Pakur","Malda","Kishanganj","Siliguri"};
        String b02[]={"7:30AM","11:12AM","12:59PM","2:30PM","3:57PM","7:30PM","9:29PM"};
        String b03[]={"2/10/19","2/10/19","2/10/19","2/10/19","2/10/19","2/10/19","2/10/19"};
        String b04[]={"0km","112.4km","199.3km","278.2km","326.8km","476.1km","558.1km"};
        String b05[]={"0","180","220","350","450","620","700"};
        Bus b0=new Bus("Royal cruiser",b01,b02,b03,b04,b05);
        ob[0]=b0;
        String b11[]={"Kolkata","Krishnanagar","Berhampore","Pakur","Malda","Kishanganj","Siliguri"};
        String b12[]={"8:30PM","12:12AM","1:59AM","3:30AM","4:38AM","8:04AM","10:05AM"};
        String b13[]={"2/10/19","3/10/19","3/10/19","3/10/19","3/10/19","3/10/19","3/10/19"};
        String b14[]={"0km","112.4km","199.3km","278.2km","326.8km","476.1km","558.1km"};
        String b15[]={"0","180","220","350","450","620","700"};
        Bus b1=new Bus("Greenline",b11,b12,b13,b14,b15);
        ob[1]=b1;
        String b21[]={"Kolkata","Kolaghat","Contai","Digha"};
        String b22[]={"8:00AM","9:49AM","11:28AM","12:21PM"};
        String b23[]={"2/10/19","2/10/19","2/10/19","2/10/19"};
        String b24[]={"0km","71.3km","148.0km","183km"};
        String b25[]={"0","64","124","240"};
        Bus b2=new Bus("Ashwamedha",b21,b22,b23,b24,b25);
        ob[2]=b2;
        String b31[]={"Siliguri","Kishanganj","Malda","Pakur","Berhampore","Krishnanagar","Kolkata"};
        String b32[]={"8:30PM","12:12AM","1:59AM","3:30AM","4:38AM","8:04AM","10:05AM"};
        String b33[]={"2/10/19","3/10/19","3/10/19","3/10/19","3/10/19","3/10/19","3/10/19"};
        String b34[]={"0km","112.4km","199.3km","278.2km","326.8km","476.1km","558.1km"};
        String b35[]={"0","180","220","350","450","620","700"};
        Bus b3=new Bus("Blueline",b31,b32,b33,b34,b35);
        ob[3]=b3;
        String b41[]={"Digha","Contai","Kolaghat","Kolkata"};
        String b42[]={"8:00AM","9:49AM","11:28AM","12:21PM"};
        String b43[]={"2/10/19","2/10/19","2/10/19","2/10/19"};
        String b44[]={"0km","71.3km","148.0km","183km"};
        String b45[]={"0","64","124","240"};
        Bus b4=new Bus("Locomotive",b41,b42,b43,b44,b45);
        ob[4]=b4;
    }

    void booking()throws IOException
    {
        show();
        System.out.println("Enter bus name");
        String n1=xy.readLine();
        try{
            for(int i=0;i<buses;i++)
            {
                if((ob[i].getname()).equalsIgnoreCase(n1))
                {
                    System.out.println("Seats booked: "+ob[i].getseats());
                    ob[i].seats();
                    System.out.println("");
                    break;
                }
                else if(i==buses-1)
                    System.out.println("Invalid Bus");
            }
        }catch(Exception exp){System.out.println(exp);}
        System.out.println("");
    }

    void seat()throws IOException
    {
        show();
        System.out.println("Enter bus name");
        String n1=xy.readLine();
        try{
            for(int i=0;i<buses;i++)
            {
                if((ob[i].getname()).equalsIgnoreCase(n1))
                {
                    int seatfull=ob[i].getseats();
                    ob[i].seats();
                    if(seatfull>0)
                    {
                        System.out.println("");
                        System.out.println("Enter number of seats whose reservation you want to cancel");
                        int nos=Integer.parseInt(xy.readLine());
                        if(nos==0)
                            System.out.println("No seats were cancelled");    
                        else if(seatfull>=nos)
                        {
                            System.out.println("Cancelation process started...");
                            for(int j=1;j<=nos;j++)
                            {
                                System.out.println("Enter seat id.");
                                String id=xy.readLine();
                                int ast=id.indexOf("*");
                                //System.out.println(ast);
                                int row=Integer.parseInt(id.substring(0,ast));
                                int col=Integer.parseInt(id.substring((ast+1),(id.length())));
                                //System.out.println(row+"  "+col);
                                if((row>=0)&&(row<=9)&&(col>=0)&&(col<=9))
                                {
                                    if(ob[i].fill(row,col))
                                    {
                                        ob[i].editseat(row,col);
                                        System.out.println("Cancellation successful");
                                        System.out.println("Seats after cancellation");
                                        ob[i].seats();
                                    }
                                    else
                                        System.out.println("Seat is already empty");
                                }
                                else
                                {
                                    System.out.println("Seat id did not match.");
                                    --j;
                                }
                                System.out.println("");
                            }
                            /*System.out.println("Cancellation successful");
                            System.out.println("Seats after cancellation");
                            ob[i].seats();*/
                        }
                        else
                            System.out.println("Number of seats did not match");
                        break;
                    }
                    else
                    {
                        System.out.println("Bus is vacant");
                        break;
                    }
                }
                else if(i==buses-1)
                    System.out.println("Invalid Bus");
            }
        }catch(Exception exp){System.out.println(exp);}
        System.out.println("");
    }

    void book()throws IOException
    {
        show();
        System.out.println("Enter bus name");
        String n1=xy.readLine();
        try{
            for(int i=0;i<buses;i++)
            {
                if((ob[i].getname()).equalsIgnoreCase(n1))
                {
                    ob[i].bookseats();
                    break;
                }
                else if(i==buses-1)
                    System.out.println("Invalid Bus");
            }
        }catch(Exception exp){System.out.println(exp);}
        System.out.println("");
    }

    void show()throws IOException
    {
        try{
            System.out.println("Buses available:");
            for(int i=0;i<buses;i++)
            {
                System.out.print((i+1)+":"+"\t");
                ob[i].everything();
                System.out.println();
            }
            System.out.println("");
        }catch(Exception exc)
        {
            System.out.println(exc);
        }
    }
    /*void edit()throws IOException
    {
    int ex=0,ch=0;
    do{
    System.out.println("Enter your choice");
    System.out.println("1: Add bus");
    System.out.println("2: Remove bus");
    System.out.println("3: Menu");
    try{
    ch=Integer.parseInt(xy.readLine());
    }catch(Exception exp)
    {System.out.println(exp);
    ch=3;
    }
    switch(ch)
    {
    case 1:
    try{
    if(buses<4)
    {
    System.out.println("Enter bus number");
    String n=xy.readLine();
    boolean unique=true;
    try{
    for(int i=0;i<buses;i++)
    {
    if((ob[i].getname()).equalsIgnoreCase(n))
    {
    unique=false;
    }
    }
    /-for(int i=0;i<buses;i++)
    {
    if((ob[i].getstime()).equalsIgnoreCase(stime))
    {
    unique=false;
    }
    }
    for(int i=0;i<buses;i++)
    {
    if((ob[i].getetime()).equalsIgnoreCase(etime))
    {
    unique=false;
    }
    }-/
    }catch(Exception exp){System.out.println(exp);}
    if(unique==true)
    {
    /-System.out.println("Enter start location");
    String sloc=xy.readLine();
    System.out.println("Enter end location");
    String eloc=xy.readLine();-/
    System.out.println("Enter number of stops");
    int stops=Integer.parseInt(xy.readLine());
    String stp[]=new String[stops];
    String dati[][]=new String[stops-1][2];
    System.out.println("Enter stop names");
    for(int i=0;i<stops;i++)
    {
    stp[i]=xy.nextLine();
    if(i!=0)
    {
    System.out.println("Enter date of arrival at- "+stp[i]);
    dati[i-1][0]=xy.readLine();
    System.out.println("Enter time of arrival at- "+stp[i]);
    dati[i-1][1]=xy.readLine();
    }
    }

    /-for(int i=0;i<stops-1;i++)
    {

    }-/
    Bus c=new Bus(n,stp,dati);
    ob[buses]=c;
    System.out.println("Bus added");
    ++buses;
    }
    else
    System.out.println("Bus with same number already exists.");
    }
    else
    System.out.println("No more bus can be added");
    }catch(Exception exp){System.out.println(exp);}
    System.out.println("");
    break;
    case 2:
    show();
    System.out.println("Enter bus name");
    String n1=xy.readLine();
    try{
    for(int i=0;i<buses;i++)
    {
    if((ob[i].getname()).equalsIgnoreCase(n1))
    {
    for(int j=i;j<buses-1;j++)
    {
    ob[j]=ob[j+1];
    }
    //ob[buses-1].remove();
    buses--;
    System.out.println("Bus removed successfully.");
    break;
    }
    else if(i==(buses-1))
    System.out.println("Name did not match.");
    }
    }catch(Exception exp){System.out.println(exp);}
    System.out.println("");
    break;
    case 3:
    ex=1;
    break;
    default:
    System.out.println("Invalid choice");
    }
    }while(ex!=1);
    }*/
}