import java.io.*;
class Ticket
{
    public static void main(String args[])throws IOException
    {
        Booking ob=new Booking();
        System.out.println("*Welcome*");
        boolean exit=false;
        String pass="buses";
        int c1=0,c2=0;
        do
        {
            System.out.println();
            System.out.println("Enter choice");
            System.out.println("1: Administrative Functions");
            System.out.println("2: Bookings");
            System.out.println("3: Exit");
            BufferedReader xy=new BufferedReader(new InputStreamReader(System.in));
            int ch=0;
            try{
                ch=Integer.parseInt(xy.readLine());
            }catch(Exception exp)
            {System.out.println(exp);}
            switch(ch)
            {
                case 1:
                /*System.out.println("Enter password");
                String pass1=xy.next();*/
                String pass1=pass;
                if(pass1.equals(pass))
                {
                    int ex1=0;
                    do{
                        System.out.println();
                        System.out.println("Enter your choice");
                        //System.out.println("1: Edit buses");
                        System.out.println("1: Check bookings");
                        System.out.println("2: Delete seats");
                        System.out.println("3: Main menu");
                        try{
                            c1=Integer.parseInt(xy.readLine());
                        }catch(Exception exp){
                            System.out.println(exp);
                            c1=4;
                        }
                        switch(c1)
                        {
                            /*case 1:
                            ob.edit();
                            break;*/
                            case 1:
                            ob.booking();
                            break;
                            case 2:
                            ob.seat();
                            break;
                            case 3:
                            ex1=1;
                            break;
                            default:
                            System.out.println("Invalid Input");
                        }
                    }while(ex1!=1);
                }
                else
                    System.out.println("Wrong password");
                break;
                case 2:
                int ex2=0;
                do{
                    System.out.println();
                    System.out.println("Enter your choice");
                    System.out.println("1: Check buses");
                    System.out.println("2: Book tickets");
                    System.out.println("3: Main menu");
                    try{
                        c2=Integer.parseInt(xy.readLine());
                    }catch(Exception exp){
                        System.out.println(exp);
                        c2=3;
                    }
                    switch(c2)
                    {
                        case 1:
                        ob.show();
                        break;
                        case 2:
                        ob.book();
                        break;
                        case 3:
                        ex2=1;
                        break;
                        default:
                        System.out.println("Invalid Input");
                    }
                }while(ex2!=1);
                break;
                case 3:
                exit=true;
                System.out.println("THANK YOU");
                break;
                default:
                System.out.println("Invalid Input");
            }
        }while(exit!=true);
    }
}