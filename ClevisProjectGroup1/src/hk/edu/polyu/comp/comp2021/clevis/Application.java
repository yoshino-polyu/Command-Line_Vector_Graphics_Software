package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Clevis;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Application{

    public static void main(String[] args) throws Exception {
        Clevis clevis = new Clevis();
        System.out.println("Welcome to use our graphics function");
        Random rand = new Random();
        int nameRand = rand.nextInt(100);
        File writeF = new File("record"+nameRand+".txt");
        writeF.createNewFile();
        BufferedWriter out=new BufferedWriter(new FileWriter(writeF));
        File readF = new File("record"+nameRand+".txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(readF));
        BufferedReader br = new BufferedReader(reader);
        System.out.println("Input record store in the \"record"+nameRand+".txt\"");
        while (true) {
            System.out.println("Please type your code:");
            Scanner scanner = new Scanner(System.in);
            int times = 0;
            out.write(scanner.nextLine()+"\n");
            out.flush();
            String line = br.readLine();
            for(int i = 0;i<times;i++)  {
                line = br.readLine();
            }
            times++;
            Scanner scan = new Scanner(line);
            if (scan.hasNext()) {
                String str = scan.next();
                /** [Rectangle]*/
                if (str.equals("rectangle")) {
                    String name = scan.next();
                    Double inX = Double.parseDouble(scan.next());
                    Double inY = Double.parseDouble(scan.next());
                    Double inW = Double.parseDouble(scan.next());
                    Double inH = Double.parseDouble(scan.next());
                    try{
                        clevis.drawRectangle(name,inX,inY,inW,inH);
                    }catch(IllegalArgumentException e){
                        System.out.println("Error for: "+e);
                    }
                    System.out.println("Successfully add new "+str+" called " + name+ ", whose top-left corner is at location (" + inX+ "," + inY+ "), and the width and height are " + inW + " and " + inH);
                }

                /** [Line]*/
                else if (str.equals("line")) {
                    String name = scan.next();
                    Double X1 = Double.parseDouble(scan.next());
                    Double Y1 = Double.parseDouble(scan.next());
                    Double X2 = Double.parseDouble(scan.next());
                    Double Y2 = Double.parseDouble(scan.next());
                    try{
                        clevis.drawLine(name,X1,Y1,X2,Y2);
                        System.out.println("Successfully add new "+str+" called " + name + ", whose two ends are at locations (" + X1 + "," + Y1 + "), and (" + X2 + "," + Y2+")");
                    }catch(IllegalArgumentException e){
                        System.out.println("Error for: "+e);
                    }
                }

                /** [Circle]*/
                else if (str.equals("circle")) {
                    String name = scan.next();
                    Double inX = Double.parseDouble(scan.next());
                    Double inY = Double.parseDouble(scan.next());
                    Double inR = Double.parseDouble(scan.next());
                    try{
                        clevis.drawCircle(name,inX,inY,inR);
                        System.out.println("Successfully add new "+str+" called " + name + ", whose center is at location (" + inX + "," + inY + "), and whose radius is " + inR);
                    }catch(IllegalArgumentException e){
                        System.out.println("Error for: "+e);
                    }
                }

                /** [Square]*/
                else if (str.equals("square")) {
                    String name = scan.next();
                    Double inX = Double.parseDouble(scan.next());
                    Double inY = Double.parseDouble(scan.next());
                    Double inL = Double.parseDouble(scan.next());
                    try{
                        clevis.drawSquare(name,inX,inY,inL);
                        System.out.println("Successfully add new "+str+" called " + name + ", whose top-left corner is at location (" + inX + "," + inY + "), and whose side length is " + inL);
                    }catch(IllegalArgumentException e){
                        System.out.println("Error for: "+e);
                    }
                }

                /** [Group]*/
                else if (str.equals("group")) {
                    String name = scan.next();
                    String[] strList = scan.nextLine().trim().split(" ");
                    StringBuilder sb = new StringBuilder();
                    for (String s : strList) {
                        sb.append(s + " ");
                    }
                        try {
                            clevis.createGroup(name, strList);
                            System.out.println("Successfully create a new group called " + name + " which contains " + sb);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error for " + e);
                        }
                }

                /** [Ungroup]*/
                else if (str.equals("ungroup")){
                    String name = scan.next();
                    try{
                        clevis.unGroup(name);
                        System.out.println("Successfully ungroup the "+name);
                    }catch(IllegalArgumentException e){
                        System.out.println("Unsuccessfully ungroup "+name+" because can't find the name in storage!");
                    }
                }

                /** [Delete]*/
                else if (str.equals("delete")){
                    String name = scan.next();
                    try{
                        clevis.deleteShapeWithName(name);
                        System.out.println("Successfully delete the shape called "+name);
                    }catch(IllegalArgumentException e){
                        System.out.println("Unsuccessfully delete because can't find the name in storage!");
                    }
                }

                /** [boudningbox]*/
                else if (str.equals("boundingbox")){
                    String name = scan.next();
                    try{
                        System.out.println(clevis.createBoundingBox(name));
                    }
                    catch(IllegalArgumentException e){
                        System.out.println("Error for: "+e);
                    }
                    System.out.println("Successfully create boundingbox of "+name+"!");
                }

                /** [move]*/
                else if (str.equals("move")){
                    String name = scan.next();
                    double inX = Double.parseDouble(scan.next());
                    double inY = Double.parseDouble(scan.next());
                    System.out.println(inX);
                    System.out.println(inY);
                    try{
                        clevis.moveShape(name,inX,inY);
                        System.out.println(inX);
                        System.out.println(inY);
                        System.out.println("Successfully move to point ("+inX+","+inY+")");
                    }
                    catch(IllegalArgumentException e){
                        System.out.println("Error for: "+e);
                    }
                }

                /** [pick-and-move]*/
                else if (str.equals("pick-and-move")){
                    double inX = Double.parseDouble(scan.next());
                    double inY = Double.parseDouble(scan.next());
                    double inDx = Double.parseDouble(scan.next());
                    double inDy = Double.parseDouble(scan.next());
                    try{
                        clevis.pickAndMoveShape(inX,inY,inDx,inDy);
                        System.out.println("Successfully pick and move point ("+inX+","+inY+") to point ("+inDx+","+inDy+")");
                    }catch(IllegalArgumentException e){
                        System.out.println("Error for: "+e);
                    }
                }

                /** [intersect]*/
                else if (str.equals("intersect")){
                    String shape1 = scan.next();
                    String shape2 = scan.next();
                    try{
                        clevis.isIntersected(shape1,shape2);
                        if (clevis.isIntersected(shape1,shape2)==true){
                            System.out.println("They are intersected!");
                        }
                        else{
                            System.out.println("They are not intersected");
                        }
                    }
                    catch(IllegalArgumentException e){
                        System.out.println("Error for: "+e);
                    }

                }

                /** [List]*/
                else if (str.equals("list")){
                    String name = scan.next();
                    try{
                        System.out.println();
                        System.out.println("Here is the information about "+clevis.listShape(name));
                    }catch(IllegalArgumentException e){
                        System.out.println("Unsuccessfully list "+name+" because can't find the name in storage!");
                    }
                }

                /** [ListAll]*/
                else if (str.equalsIgnoreCase("listAll")){
                    try{
                        System.out.println(clevis.listAllShape());
                    }catch(IllegalArgumentException e){
                        System.out.println("Unsuccessfully listAll because can't find the name in storage!");
                    }
                }

                /** [Undo]*/
                else if(str.equals("undo")){
                    try{
//                        LineNumberReader lineNumberR = new LineNumberReader(in);
//                        int lineNumber = 0;
//                        int totalLine = 0;
//                        String targetLine = "";
//                        while (line!=null){
//                            totalLine++;
//                            line = lineNumberR.readLine();
//                        }
//                        while (line!=null){
//                            if (lineNumber==totalLine-1){
//                                targetLine = lineNumberR.readLine();
//                            }
//                        }
                        System.out.println("Already undo!");
                        clevis.UndoControl();
                    }catch (IllegalArgumentException e){
                        System.out.println("No operation for undo！");
                    }
                }

                /** [Redo]*/
                else if (str.equals("redo")){
                    try{
                        clevis.RedoControl();
                        System.out.println("Already redo!");
                    }catch (IllegalArgumentException e){
                        System.out.println("No operation for undo！");
                    }
                }

                else if (str.equalsIgnoreCase("quit")){
                    break;
                }
            }
        }
    }
}
/*        int quit = 0;
        int i = 0;
        System.out.println("Function List:\n1.Add graphics\n2.Delete graphics\n3.Graphics group\n4.Graphics boundary\n5.Move graphics\n6.Graphics intersection\n7.Graphics information\n8.Quit");
        Scanner scan = new Scanner(System.in);
            while (scan.hasNextInt()) {
                while (quit==0) {
                    if (i !=0){
                        System.out.println("Function List:\n1.Add graphics\n2.Delete graphics\n3.Graphics group\n4.Graphics boundary\n5.Move graphics\n6.Graphics intersection\n7.Graphics information\n8.Quit");
                    }
                    i++;
                    int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Please input the graphic that you want to add: ");
                        break;
                    case 2:
                        System.out.println("Please input the graphic that you want to delete: ");
                        break;
                    case 3:
                        System.out.println("Do you want to group or ungroup, Please input 1 or 2: ");
                        choice = scan.nextInt();
                        if (choice == 1) {
                            System.out.println("Please input graphics that you want to group together: ");
                            break;

                        } else if (choice == 2) {
                            System.out.println("Please input graphics that you want to ungroup: ");
                            break;
                        } else {
                            System.out.println("please choose the correct choice");
                            break;
                        }

                    case 4:
                        System.out.println("Please input the graphics boundary that you want to calculate: ");
                        break;

                    case 5:
                        System.out.println("Do you want to move the shape or the shape contains target point, Please input 1 or 2: ");
                        choice = scan.nextInt();
                        if (choice == 1) {
                            System.out.println("Please input the shape that you want to move: ");
                            break;
                        } else if (choice == 2) {
                            System.out.println("Please input the shape that contains the point that you want pick and move: ");
                            break;
                        } else {
                            System.out.println("please choose the correct choice");
                            break;
                        }

                    case 6:
                        System.out.println("Please input two shapes for judging intersection: ");
                        break;

                    case 7:
                        System.out.println("Do you want to print all information or a shape information, Please input 1 or 2: ");
                        choice = scan.nextInt();
                        if (choice == 1) {
                                System.out.println("Layout of all current graphics information: ");
                                break;
                            }   else if (choice == 2) {
                                System.out.println("Layout of target shape's information: ");
                                break;
                            }   else {
                                System.out.println("please choose the correct choice");
                                break;
                        }

                    case 8:
                        System.out.println("Thanks for your using!");
                        quit=1;
                        break;

                }
            }
                break;
            }
    }
}

 */