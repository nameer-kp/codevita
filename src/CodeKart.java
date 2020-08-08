import java.util.Scanner;


public class CodeKart {
    private static int priceOfShoe;
    private static int priceOfShirt;
    private static int noOfShoesInInventory;
    private static int noOfShirtsInInventory;
    private static int noOfShoesInCart;
    private static int noOfShirtsInCart;


    //this function for starting commandline
    public static void commandLine(int testCases) throws Exception {


        for (int i = 0; i < testCases; i++) {
            Scanner scanner = new Scanner(System.in);
            noOfShirtsInCart =0;
            noOfShirtsInInventory=0;
            noOfShoesInCart=0;
            noOfShoesInInventory=0;
            String command = scanner.next();
            //this loop for each command
            while (!command.equals("END")) {

                //if (command.equals("END")) break;
                // if first word is CMD then only we need Proceed
                if (command.equals("CMD")) {
                    System.out.println();
                        command=scanner.next(); //this command holds 2 word (SM /S)
                    if (command.equals("SM")){
                        command=scanner.next(); //this holds (ADD/REMOVE/GET_QTY/INCR/DCR/SET_COST)
                        switch (command){//this switch is used for above commands

                            case "ADD" :
                                //System.out.println("ADD -SM");
                                String arg1 =scanner.next(); //arg1 is for item
                                String arg2 =scanner.next(); //arg2 is for qty/cost
                                addSm(arg1,arg2);
                                //System.out.println(arg1+" "+arg2);


                                break;
                            case "REMOVE" :
                                arg1 =scanner.next();
                                removeSm(arg1);
                                //System.out.println("REMOVE -SM"+" "+arg1);
                                break;
                            case "GET_QTY" :
                                arg1 =scanner.next();
                                getQtySm(arg1);
                                //System.out.println("GET_QTY -SM");
                                break;
                            case "INCR" :
                                arg1 =scanner.next();
                                arg2 =scanner.next();
                                incrSm(arg1,arg2);
                                //System.out.println("INCR -SM");
                                break;
                            case "DCR" :
                                arg1 =scanner.next();
                                arg2 =scanner.next();
                                dcrSm(arg1,arg2);
                                //System.out.println("DCR -SM");
                                break;
                            case "SET_COST" :
                                arg1 =scanner.next();
                                arg2 =scanner.next();
                                setCostSm(arg1,arg2);
                                //System.out.println("SET_COST -SM");
                                break;
                            default:
                                throw new Exception("INVALID COMMAND");



                        }





                    }
                    else if (command.equals("S")){

                        command=scanner.next(); //this holds (ADD/REMOVE/INCR/DCR/GET_ORDER_AMOUNT
                        switch (command){//this switch is used for above commands

                            case "ADD" :
                                //System.out.println("ADD -S");
                                String arg1 =scanner.next(); //arg1 is for item
                                String arg2 =scanner.next();
                                addS(arg1,arg2);
                                break;
                            case "REMOVE" :
                                arg1 =scanner.next(); //arg1 is for item
                                removeS(arg1);
                                //System.out.println("REMOVE -S");
                                break;
                            case "GET_ORDER_AMOUNT" :
                               // System.out.println("GET_ORDER_AMOUNT -S");
                                orderAmountS();
                                break;
                            case "INCR" :
                                arg1 =scanner.next(); //arg1 is for item
                                arg2 =scanner.next();
                                incrS(arg1,arg2);
                                //System.out.println("INCR -S");
                                break;
                            case "DCR" :
                                arg1 =scanner.next(); //arg1 is for item
                                arg2 =scanner.next();
                                dcrS(arg1,arg2);
                                //System.out.println("DCR -S");
                                break;
                            default:
                                throw new Exception("INVALID COMMAND");



                        }

                    }





                } else {
                    throw new Exception("invalid command");
                }

                scanner.nextLine();
                command= scanner.next();
            }

        }
    }

    private static void orderAmountS() {
        double total=(noOfShoesInCart*priceOfShoe)+(noOfShirtsInCart*priceOfShirt);

        System.out.println(Math.round(total * 100.0) / 100.0);
    }

    private static void dcrS(String arg1, String arg2) {
        switch (arg1){
            case "SHOE":
             if (noOfShoesInCart>0&&Integer.parseInt(arg2)>0) {
                    noOfShoesInCart = noOfShoesInCart - Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
             else {System.out.println(-1); break;}
            case "SHIRT":
                if(noOfShirtsInCart>0&&Integer.parseInt(arg2)>0) {
                    noOfShirtsInCart = noOfShirtsInCart - Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
                else {System.out.println(-1); break;}
            default:
                System.out.println(-1);
        }
    }

    private static void incrS(String arg1, String arg2) {
        switch (arg1){
            case "SHOE":
                if(noOfShoesInCart>0&&Integer.parseInt(arg2)>0) {
                    noOfShoesInCart = noOfShoesInCart + Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
                else {System.out.println(-1); break;}
            case "SHIRT":
                if(noOfShirtsInCart>0&&Integer.parseInt(arg2)>0) {
                    noOfShirtsInCart = noOfShirtsInCart + Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
                else {System.out.println(-1); break;}
            default:
                System.out.println(-1);
        }
    }

    private static void removeS(String arg1) {
        switch (arg1) {
            case "SHOE":
                noOfShoesInCart = 0;
                System.out.println(1);

            case "SHIRT":
                System.out.println(1);
                noOfShirtsInCart = 0;

        default :
            System.out.println(-1);
        }
    }

    private static void addS(String arg1, String arg2) {
        switch (arg1){
            case "SHOE":
                if(noOfShoesInCart==0) {
                    noOfShoesInCart = noOfShoesInCart + Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
                else {System.out.println(-1); break;}
            case "SHIRT":
                if (noOfShirtsInCart==0) {
                    noOfShirtsInCart = noOfShirtsInCart + Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
                else {System.out.println(-1); break;}
            default:
                System.out.println(-1);
        }

    }

    private static void setCostSm(String arg1, String arg2) {
        switch (arg1){
            case "SHOE":
                priceOfShoe=Integer.parseInt(arg2);
                System.out.println(Double.parseDouble(arg2));
                break;
            case "SHIRT":
                priceOfShirt=Integer.parseInt(arg2);
                System.out.println( Double.parseDouble(arg2));
                break;
            default:
                System.out.println(-1);
        }
    }

    private static void dcrSm(String arg1, String arg2) {
        switch (arg1){
            case "SHOE":
                if(noOfShoesInInventory>0&&Integer.parseInt(arg2)>0) {
                    noOfShoesInInventory = noOfShoesInInventory - Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
                else {System.out.println(-1); break;}
            case "SHIRT":
                if(noOfShirtsInInventory>0&&Integer.parseInt(arg2)>0) {
                    noOfShirtsInInventory = noOfShirtsInInventory - Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
                else {System.out.println(-1); break;}
            default:
                System.out.println(-1);
        }
    }

    private static void incrSm(String arg1, String arg2) {
        switch (arg1){
            case "SHOE":
                if(noOfShoesInInventory>0&&Integer.parseInt(arg2)>0) {
                    noOfShoesInInventory = noOfShoesInInventory + Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
                else {System.out.println(-1); break;}
            case "SHIRT":
                if(noOfShirtsInInventory>0&&Integer.parseInt(arg2)>0) {
                    noOfShirtsInInventory = noOfShirtsInInventory + Integer.parseInt(arg2);
                    System.out.println(arg2);
                    break;
                }
                else {System.out.println(-1); break;}
            default:
                System.out.println(-1);
        }
    }

    private static void getQtySm(String arg1) {
        switch (arg1){
            case "SHOE":
                System.out.println(noOfShoesInInventory);
                break;
            case "SHIRT":
                System.out.println(noOfShirtsInInventory);
                break;
            default:
                System.out.println(0);
        }

    }

    private static void removeSm(String arg1) {
        switch (arg1){
            case "SHOE":
                noOfShoesInInventory=0;
                System.out.println(1);
                break;
            case "SHIRT":
                noOfShirtsInInventory=0;
                System.out.println(1);
                break;
            default:
                System.out.println(-1);
        }
    }

    private static void addSm(String arg1, String arg2) {
       switch (arg1){
           case "SHOE":
               if(noOfShoesInInventory==0) {
                   noOfShoesInInventory = noOfShoesInInventory + Integer.parseInt(arg2);
                   System.out.println(arg2);
                   break;
               }
               else {System.out.println(-1); break;}
           case "SHIRT":
               if (noOfShirtsInInventory==0) {
                   noOfShirtsInInventory = noOfShirtsInInventory + Integer.parseInt(arg2);
                   System.out.println(arg2);
                   break;
               }
               else {System.out.println(-1); break;}
           default:
               System.out.println(-1);
       }

    }


    public static void main(String[] args)  {

        try {
                Scanner scanner = new Scanner(System.in);
                int testCases=scanner.nextInt();
                commandLine(testCases);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}



