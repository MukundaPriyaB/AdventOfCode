package com.company;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.math.BigInteger;
import java.lang.Long;


public class Main<pubiic> {

    public static void main(String[] args) throws IOException {
        // write your code here
        //Main.sumOfTwoNumbers(); //advent of code day1 part 1
        //Main.sumOfTwoNumbersSort(); //advent of code day1 part 1 alternate method
        //Main.sumOfThreeNumbersSort(); //advent of code day1 part 2
        //Main.passwordVerification(); //advent of code day2 part 1
        //Main.passwordVerificationPosition(); //advent of code day2 part 2
        //Main.numberOfTrees(); //advent of code day3 part 1
        //Main.numberOfTreesInAllSlopes(); //advent of code day3 part 2
        //Main.numberOfTreesTest(); //advent of code day3 part 2 test
        //Main.passportValidation(); // advent of code day4 part 1 and part2
        //Main.boardingPassHighestAnsMissing();// advent of code Day 5 part 1 and 2
        //Main.CustomCustoms();// advent of Code day 6 part 1
        Main.CustomCustomsCommon();// advent of code Day 6 part 2

    }

    // advent of code Day 1 part 1
    public static void sumOfTwoNumbers() throws FileNotFoundException {
        List<Integer> inputArray = new ArrayList<Integer>();
        Scanner input = new Scanner(new File("input.txt"));

        while (input.hasNext()) {
            String answer = input.nextLine();
            int number = Integer.parseInt(answer);
            inputArray.add(number);
        }
        long start = System.nanoTime();
        int lengthRequired = inputArray.size();
        int jInput = 0;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < inputArray.size(); i++) {
            temp1 = inputArray.get(i);
            jInput++;
            for (int j = jInput; j < lengthRequired; j++) {
                temp2 = inputArray.get(j);
                if (temp1 + temp2 == 2020) {
                    System.out.println(temp1);
                    System.out.println(temp2);
                    System.out.println(temp1 * temp2);
                    break;
                }

            }

        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("time elapsed is" + timeElapsed);

    }

    // Advent of code day 1 part 1 alternate code
    public static void sumOfTwoNumbersSort() throws FileNotFoundException {
        List<Integer> inputArray = new ArrayList<Integer>();
        Scanner input = new Scanner(new File("input.txt"));

        while (input.hasNext()) {
            String answer = input.nextLine();
            int number = Integer.parseInt(answer);
            inputArray.add(number);
        }
        Collections.sort(inputArray);
        long start = System.nanoTime();
        int lengthRequired = inputArray.size();
        int jInput = 0;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < inputArray.size(); i++) {
            temp1 = inputArray.get(i);
            jInput++;
            for (int j = jInput; j < lengthRequired; j++) {
                temp2 = inputArray.get(j);
                if (temp1 + temp2 == 2020) {
                    System.out.println(temp1);
                    System.out.println(temp2);
                    System.out.println(temp1 * temp2);
                    break;
                }
                if (temp1 + temp2 > 2020) {
                    break;
                }

            }

        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("time elapsed is " + timeElapsed);

    }

    // advent of code day 1 part2
    public static void sumOfThreeNumbersSort() throws FileNotFoundException {
        List<Integer> inputArray = new ArrayList<Integer>();
        Scanner input = new Scanner(new File("input.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            int inputInt = Integer.parseInt(answer);
            inputArray.add(inputInt);

        }
       /* inputArray.add(1721);
        inputArray.add(979);
        inputArray.add(366);
        inputArray.add(299);
        inputArray.add(675);
        inputArray.add(1456);*/
        Collections.sort(inputArray);
        long start = System.nanoTime();
        int lengthRequired = inputArray.size();
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        for (int i = 0; i < inputArray.size(); i++) {
            temp1 = inputArray.get(i);

            for (int j = i + 1; j < lengthRequired; j++) {
                temp2 = inputArray.get(j);
                if (temp1 + temp2 > 2020) {
                    break;
                }
                for (int k = j + 1; k < lengthRequired; k++) {
                    temp3 = inputArray.get(k);
                    if (temp1 + temp2 + temp3 == 2020) {
                        System.out.println(temp1);
                        System.out.println(temp2);
                        System.out.println(temp3);
                        System.out.println(temp1 * temp2 * temp3);
                        break;
                    }
                    if (temp1 + temp2 + temp3 > 2020) {
                        break;
                    }
                }

            }

        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("time elapsed is " + timeElapsed);

    }

    //advent of code day 2 part 1
    public static void passwordVerification() throws FileNotFoundException {
        List<String> inputArray = new ArrayList<String>();
        //inputArray.add("1-3 a: abcde");
        //inputArray.add("1-3 b: cdefg");
        //inputArray.add("2-9 c: ccccccccc");
        Scanner input = new Scanner(new File("inputDay2.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            inputArray.add(answer);

        }

        int minNoOfTimes = 0;
        int maxNoOfTimes = 0;
        char letterInPassword = '\0';
        int countLetter = 0;
        int countPassword = 0;
        String inputPassword = "";
        String tempString = "";
        String part1 = "";
        String part2 = "";
        String part3 = "";
        for (int i = 0; i < inputArray.size(); i++) {
            tempString = inputArray.get(i);
            String[] parts = tempString.split("\\s+");
            part1 = parts[0];
            part2 = parts[1];
            part3 = parts[2];
            //System.out.println("part1 is "+part1+" part2 is  "+part2+ "part 3 is " +part3);
            String[] minMax = part1.split("-");
            minNoOfTimes = Integer.parseInt(minMax[0]);
            maxNoOfTimes = Integer.parseInt(minMax[1]);
            letterInPassword = part2.charAt(0);
            inputPassword = part3;
            countLetter = countChar(inputPassword, letterInPassword);
            if (countLetter >= minNoOfTimes && countLetter <= maxNoOfTimes) {
                countPassword++;
            }
        }
        System.out.println("The number of valid passwords are " + countPassword);

    }

    public static int countChar(String input, char c) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    // advent of code day 2 part 2
    public static void passwordVerificationPosition() throws FileNotFoundException {
        List<String> inputArray = new ArrayList<String>();
        //inputArray.add("1-3 a: abcde");
        //inputArray.add("1-3 b: cdefg");
        //inputArray.add("2-9 c: ccccccccc");
        Scanner input = new Scanner(new File("inputDay2.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            inputArray.add(answer);

        }

        int position1 = 0;
        int position2 = 0;
        char charRequired = '\0';
        int countPassword = 0;
        String inputPassword = "";
        String tempString = "";
        String part1 = "";
        String part2 = "";
        String part3 = "";
        for (int i = 0; i < inputArray.size(); i++) {
            tempString = inputArray.get(i);
            String[] parts = tempString.split("\\s+");
            part1 = parts[0];
            part2 = parts[1];
            part3 = parts[2];
            //System.out.println("part1 is " + part1 + " part2 is  " + part2 + "part 3 is " + part3);
            String[] minMax = part1.split("-");
            position1 = Integer.parseInt(minMax[0]) - 1;
            position2 = Integer.parseInt(minMax[1]) - 1;
            charRequired = part2.charAt(0);
            inputPassword = part3;
            if (inputPassword.charAt(position1) == charRequired && inputPassword.charAt(position2) != charRequired) {
                countPassword++;
            } else if (inputPassword.charAt(position1) != charRequired && inputPassword.charAt(position2) == charRequired) {
                countPassword++;
            }
        }
        System.out.println("The number of valid passwords are " + countPassword);
    }

    // advent of code day 3 part 1
    public static void numberOfTrees() throws FileNotFoundException {
        List<String> inputArray = new ArrayList<String>();
        /*inputArray.add("..##.......");
        inputArray.add("#...#...#..");
        inputArray.add(".#....#..#.");
        inputArray.add("..#.#...#.#");
        inputArray.add(".#...##..#.");
        inputArray.add("..#.##.....");
        inputArray.add(".#.#.#....#");
        inputArray.add(".#........#");
        inputArray.add("#.##...#...");
        inputArray.add("#...##....#");
        inputArray.add(".#..#...#.#");*/
        Scanner input = new Scanner(new File("inputDay3.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            inputArray.add(answer);

        }

        int numOfTrees = 0;
        String firstString = "";
        String secondString = "";
        int position = 1;
        int stringLength = 0;
        char treeSymbol = '#';
        stringLength = inputArray.get(0).length();
        for (int i = 0; i < inputArray.size() - 1; i++) {
            firstString = inputArray.get(i);
            secondString = inputArray.get(i + 1);
            position = position + 3;
            if (position > stringLength) {
                position = position - stringLength;
            }
            if (secondString.charAt(position - 1) == treeSymbol) {
                numOfTrees++;
            }
        }
        System.out.println("The number of trees in the path are " + numOfTrees);

    }

    // advent of code day 3 part 2
    public static void numberOfTreesInAllSlopes() throws FileNotFoundException {
        List<String> inputArray = new ArrayList<String>();
       /* inputArray.add("..##.......");
        inputArray.add("#...#...#..");
        inputArray.add(".#....#..#.");
        inputArray.add("..#.#...#.#");
        inputArray.add(".#...##..#.");
        inputArray.add("..#.##.....");
        inputArray.add(".#.#.#....#");
        inputArray.add(".#........#");
        inputArray.add("#.##...#...");
        inputArray.add("#...##....#");
        inputArray.add(".#..#...#.#");*/
        Scanner input = new Scanner(new File("inputDay3.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            inputArray.add(answer);

        }

        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        int fourthCount = 0;
        int fifthCount = 0;
        String secondString = "";
        //String thirdString = "";
        int firstPosition = 1;
        int secondPosition = 1;
        int thirdPosition = 1;
        int fourthPosition = 1;
        int fifthPosition = 1;
        int stringLength = 0;
        char treeSymbol = '#';
        stringLength = inputArray.get(0).length();
        //first slope rules: right 1, down 1
        for (int i = 0; i < inputArray.size() - 1; i++) {
            secondString = inputArray.get(i + 1);
            firstPosition = firstPosition + 1;
            if (firstPosition > stringLength) {
                firstPosition = firstPosition - stringLength;
            }
            if (secondString.charAt(firstPosition - 1) == treeSymbol) {
                firstCount++;
            }
        }
        //second slope rules: right 3, down 1
        for (int i = 0; i < inputArray.size() - 1; i++) {
            secondString = inputArray.get(i + 1);
            secondPosition = secondPosition + 3;
            if (secondPosition > stringLength) {
                secondPosition = secondPosition - stringLength;
            }
            if (secondString.charAt(secondPosition - 1) == treeSymbol) {
                secondCount++;
            }
        }
        //third slope rules: right 5, down 1
        for (int i = 0; i < inputArray.size() - 1; i++) {
            secondString = inputArray.get(i + 1);
            thirdPosition = thirdPosition + 5;
            if (thirdPosition > stringLength) {
                thirdPosition = thirdPosition - stringLength;
            }
            if (secondString.charAt(thirdPosition - 1) == treeSymbol) {
                thirdCount++;
            }
        }
        //fourth slope rules: right 7, down 1
        for (int i = 0; i < inputArray.size() - 1; i++) {
            secondString = inputArray.get(i + 1);
            fourthPosition = fourthPosition + 7;
            if (fourthPosition > stringLength) {
                fourthPosition = fourthPosition - stringLength;
            }
            if (secondString.charAt(fourthPosition - 1) == treeSymbol) {
                fourthCount++;
            }
        }
        //fifth slope rules: right 1, down 2
        int numOfTrees = 0;
        int position = 1;
        int dotCount = 0;
        for (int i = 2; i < inputArray.size(); i = i + 2) {
            String thirdString = inputArray.get(i);
            position = position + 1;
            if (position > stringLength) {
                position = position - stringLength;
            }
            if (thirdString.charAt(position - 1) == treeSymbol) {
                numOfTrees++;
            }
            if (thirdString.charAt(position - 1) == '.') {
                dotCount++;
            }
            System.out.println("i value is" + i);
        }
        System.out.println("The number of trees in the path are " + numOfTrees);
        System.out.println("The number of dots in the path are " + dotCount);
        System.out.println(firstCount);
        System.out.println(secondCount);
        System.out.println(thirdCount);
        System.out.println(fourthCount);
        System.out.println(numOfTrees);
        long firstHalfMultiplication = firstCount * secondCount * thirdCount;
        long secondHalfMultiplication = fourthCount * numOfTrees;
        BigInteger bigFirstHalf = toUnsignedBigInteger(firstHalfMultiplication);
        BigInteger bigSecondHalf = toUnsignedBigInteger(secondHalfMultiplication);
        BigInteger total = bigFirstHalf.multiply(bigSecondHalf);
        System.out.println("The multiplication of number of trees in all path are " + total);

    }

    private static BigInteger toUnsignedBigInteger(long i) {
        if (i >= 0L)
            return BigInteger.valueOf(i);
        else {
            int upper = (int) (i >>> 32);
            int lower = (int) i;

            // return (upper << 32) + lower
            return (BigInteger.valueOf(Integer.toUnsignedLong(upper))).shiftLeft(32).
                    add(BigInteger.valueOf(Integer.toUnsignedLong(lower)));
        }
    }

    // advent of code day 3 part 2 test
    public static void numberOfTreesTest() throws FileNotFoundException {
        List<String> inputArray = new ArrayList<String>();
        /*inputArray.add("..##.......");
        inputArray.add("#...#...#..");
        inputArray.add(".#....#..#.");
        inputArray.add("..#.#...#.#");
        inputArray.add(".#...##..#.");
        inputArray.add("..#.##.....");
        inputArray.add(".#.#.#....#");
        inputArray.add(".#........#");
        inputArray.add("#.##...#...");
        inputArray.add("#...##....#");
        inputArray.add(".#..#...#.#");*/
        Scanner input = new Scanner(new File("inputDay3.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            inputArray.add(answer);

        }

        int numOfTrees = 0;
        String firstString = "";
        String secondString = "";
        int position = 1;
        int stringLength = 0;
        char treeSymbol = '#';
        int dotCount = 0;
        stringLength = inputArray.get(0).length();
        for (int i = 2; i < inputArray.size(); i = i + 2) {
            String thirdString = inputArray.get(i);
            position = position + 1;
            if (position > stringLength) {
                position = position - stringLength;
            }
            if (thirdString.charAt(position - 1) == treeSymbol) {
                numOfTrees++;
            }
            if (thirdString.charAt(position - 1) == '.') {
                dotCount++;
            }
            System.out.println("i value is" + i);
        }
        System.out.println("The number of trees in the path are " + numOfTrees);
        System.out.println("The number of dots in the path are " + dotCount);

    }

    // advent of code day 4 part 1
    public static void passportValidation() throws FileNotFoundException {
        List<String> inputArray = new ArrayList<String>();
        /*inputArray.add("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd");
        inputArray.add("byr:1937 iyr:2017 cid:147 hgt:183cm");
        inputArray.add("");
        inputArray.add("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884");
        inputArray.add("hcl:#cfa07d byr:1929");
        inputArray.add("");
        inputArray.add("hcl:#ae17e1 iyr:2013");
        inputArray.add("eyr:2024");
        inputArray.add("ecl:brn pid:760753108 byr:1931");
        inputArray.add("hgt:179cm");
        inputArray.add("");
        inputArray.add("hcl:#cfa07d eyr:2025 pid:166559648");
        inputArray.add("iyr:2011 ecl:brn hgt:59in");*/
        Scanner input = new Scanner(new File("inputDay4.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            inputArray.add(answer);

        }
        String a = "foo";
        String b = "foo";
        a = a + " with addition sign";
        b = b.concat(" ").concat("with concat");
        System.out.println(a);
        System.out.println(b);
        List<String> passport = new ArrayList<String>();
        String passDetails = "";
        int countblankLines = 0;
        for (int i = 0; i < inputArray.size(); i++) {
            if (inputArray.get(i) == "") {
                passport.add(passDetails);
                passDetails = "";

            } else {
                if (passDetails == "") {
                    passDetails = passDetails.concat(inputArray.get(i));
                } else {
                    passDetails = passDetails.concat(" ").concat(inputArray.get(i));
                }
            }
        }
        int lastEntry = passport.size() - 1;
        if (passport.get(lastEntry) != passDetails) {
            passport.add(passDetails);
        }
        int validPassportCount = 0;
        String passportValue = "";
        for (int j = 0; j < passport.size(); j++) {
            passportValue = passport.get(j);
            if (passportValue.contains("byr:") && passportValue.contains("iyr:") && passportValue.contains("eyr:") && passportValue.contains("hgt:")) {
                if (passportValue.contains("hcl:") && passportValue.contains("ecl:") && passportValue.contains("pid:")) {
                    HashMap<String, String> passHMap = new HashMap<String, String>();
                    String[] parts = passportValue.split(" ");
                    for (int k = 0; k < parts.length; k++) {
                        String[] keyValue = parts[k].split(":");
                        passHMap.put(keyValue[0], keyValue[1]);
                    }
                    if (passportValidationOfAllFields(passHMap)) {
                        validPassportCount++;
                    }

                }
            }
        }
        System.out.println(validPassportCount);
    }

    public static boolean passportValidationOfAllFields(HashMap<String, String> passHMap) {
        //byr (Birth Year) - four digits; at least 1920 and at most 2002 #1
        String birthYear = passHMap.get("byr");
        int countAll = 0;
        if (birthYear.matches("\\d+")) {
            if (Integer.parseInt(birthYear) >= 1920 && Integer.parseInt(birthYear) <= 2002) {
                countAll++;
            } else
                return false;
        } else
            return false;
        //iyr (Issue Year) - four digits; at least 2010 and at most 2020. #2
        String issueYear = passHMap.get("iyr");
        if (issueYear.matches("\\d+")) {
            if (Integer.parseInt(issueYear) >= 2010 && Integer.parseInt(issueYear) <= 2020) {
                countAll++;
            } else
                return false;
        } else
            return false;
        //eyr (Expiration Year) - four digits; at least 2020 and at most 2030. #3
        String expirationYear = passHMap.get("eyr");
        if (expirationYear.matches("\\d+")) {
            if (Integer.parseInt(expirationYear) >= 2020 && Integer.parseInt(expirationYear) <= 2030) {
                countAll++;
            } else
                return false;
        } else
            return false;
        //hgt (Height) - a number followed by either cm or in: #4
        //If cm, the number must be at least 150 and at most 193.
        //If in, the number must be at least 59 and at most 76.
        String height = passHMap.get("hgt");
        if (height.matches("1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in")) {
            countAll++;
        } else
            return false;

        //hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f. #5
        String hairColor = passHMap.get("hcl");
        if (hairColor.matches("#[0-9a-f]{6}")) {
            countAll++;
        } else
            return false;
        //ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth. #6
        String eyeColor = passHMap.get("ecl");
        if (eyeColor.matches("amb|blu|brn|gry|grn|hzl|oth")) {
            countAll++;
        } else
            return false;


        //pid (Passport ID) - a nine-digit number, including leading zeroes. #7
        String passportID = passHMap.get("pid");
        if (passportID.matches("[0-9]{9}")) {
            countAll++;
        } else
            return false;

        if (countAll == 7) {
            return true;
        } else
            return false;
    }
// Day 5 part 1 and 2
    public static void boardingPassHighestAnsMissing() throws FileNotFoundException{
        List<String> inputArray = new ArrayList<String>();
        /*inputArray.add("FBFBBFFRLR");
        inputArray.add("BFFFBBFRRR");
        inputArray.add("FFFBBBFRRR");
        inputArray.add("BBFFBBFRLL");*/
        Scanner input = new Scanner(new File("inputDay5.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            inputArray.add(answer);

        }
        String inputSeat ="";
        int first = 0;
        int last = 127;
        int firstCol = 0;
        int lastCol = 7;
        int rowCount = 0;
        int colCount = 0;
        int missingID = 0;
        int[] data = new int[inputArray.size()];
        int seatID  = 0;
        for(int i=0;i< inputArray.size();i++){
            inputSeat = inputArray.get(i);
            for(int j=0; j< 7; j++){
                if(inputSeat.charAt(j)== 'F'){
                    last= (first+last-1)/2;
                }
                else if(inputSeat.charAt(j)== 'B'){
                    first = (first+last +1)/2;
                }

            }
            if(first == last){
                rowCount = last;
            }
            else{
                System.out.println("first is "+first + "last is "+last);
            }
            for(int k = 7; k<10; k++){
                if(inputSeat.charAt(k)== 'L'){
                    lastCol= (firstCol+lastCol-1)/2;
                }
                else if(inputSeat.charAt(k)== 'R'){
                    firstCol = (firstCol+lastCol +1)/2;
                }
            }
            if(firstCol == lastCol){
                colCount = lastCol;
            }
            else{
                System.out.println("first Col is "+firstCol + "last Col is "+lastCol);
            }
            seatID = (rowCount*8)+colCount;
            //System.out.println("seatID " + seatID+" inputSear " + inputSeat);
            data[i] = seatID;
            first =0;
            last = 127;
            firstCol = 0;
            lastCol = 7;
        }
        Arrays.sort(data);
        System.out.println("highest seat ID is "+ data[inputArray.size()-1]);
        //Day 5 part 2
        for(int i =0; i<inputArray.size(); i++){
            //System.out.println(data[i]);
            if(data[i] != data[inputArray.size()-1]){
            if(data[i] != data[i+1]-1){
                missingID = data[i] +1;
                System.out.println("missing seat ID is "+ missingID);
                break;
            }
            }
        }


    }
    // advent of code Day 6 part 1
    public static void CustomCustoms() throws FileNotFoundException{
        List<String> inputArray = new ArrayList<String>();
        /*inputArray.add("abc");
        inputArray.add("");
        inputArray.add("a");
        inputArray.add("b");
        inputArray.add("c");
        inputArray.add("");
        inputArray.add("ab");
        inputArray.add("ac");
        inputArray.add("");
        inputArray.add("a");
        inputArray.add("a");
        inputArray.add("a");
        inputArray.add("a");
        inputArray.add("");
        inputArray.add("b");*/
        Scanner input = new Scanner(new File("inputDay6.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            inputArray.add(answer);
        }
        List <String> inputArrayProcessed = new ArrayList<String>();
        List <Integer> inputArrayProcessedLength = new ArrayList<Integer>();
        String tempString = "";
        String inputString = "";
        int length = 0;
        int sumLength = 0;
        int arraySize = inputArray.size();
        for(int i=0; i<arraySize; i++){
            inputString = inputArray.get(i);
            if(inputString!= ""){
                tempString= tempString+ inputString;
            }
            else{
                StringBuilder sb = new StringBuilder();
                tempString.chars().distinct().forEach(c -> sb.append((char) c));
                System.out.println(tempString);
                System.out.println(sb);
                tempString= sb.toString();
                length = tempString.length();
                System.out.println(length);
                inputArrayProcessed.add(tempString);
                inputArrayProcessedLength.add(length);
                sumLength = sumLength + length;
                System.out.println(sumLength);
                length = 0;
                tempString = "";
            }
            if(i == arraySize-1){
                StringBuilder sb = new StringBuilder();
                tempString.chars().distinct().forEach(c -> sb.append((char) c));
                System.out.println(tempString);
                System.out.println(sb);
                tempString= sb.toString();
                length = tempString.length();
                System.out.println(length);
                inputArrayProcessed.add(tempString);
                inputArrayProcessedLength.add(length);
                sumLength = sumLength + length;
                System.out.println(sumLength);
                length = 0;
                tempString = "";
            }

        }

    }
    // advent of code Day 6 part 2
    public static void CustomCustomsCommon() throws FileNotFoundException{
        List<String> inputArray = new ArrayList<String>();
       /* inputArray.add("abc");
        inputArray.add("");
        inputArray.add("a");
        inputArray.add("b");
        inputArray.add("c");
        inputArray.add("");
        inputArray.add("ab");
        inputArray.add("ac");
        inputArray.add("");
        inputArray.add("a");
        inputArray.add("a");
        inputArray.add("a");
        inputArray.add("a");
        inputArray.add("");
        inputArray.add("b");
        inputArray.add("b");*/
        Scanner input = new Scanner(new File("inputDay6.txt"));
        while (input.hasNext()) {
            String answer = input.nextLine();
            inputArray.add(answer);
        }
        List <String> tempArrayListProcessed = new ArrayList<String>();
        String tempString = "";
        int totalCount = 0;
        int tempCount =0;
        int countNumOfMembersInAGroup = 0;
        for(int i =0; i<inputArray.size();i++) {

            if (inputArray.get(i) != "") {
                countNumOfMembersInAGroup++;
                tempArrayListProcessed.add(inputArray.get(i));
            } else {
                if (countNumOfMembersInAGroup == 1) {
                    totalCount += tempArrayListProcessed.get(0).length();
                    System.out.println(totalCount + " single member groups");
                    tempArrayListProcessed.clear();
                    countNumOfMembersInAGroup = 0;
                }
                else if (countNumOfMembersInAGroup > 1) {
                    tempString = tempArrayListProcessed.get(0);
                    //System.out.println(tempString);
                    for (int k = 0; k < tempString.length(); k++) {
                        for (int j = 1; j < tempArrayListProcessed.size(); j++) {
                            if (containsChar(tempString.charAt(k), tempArrayListProcessed.get(j))) {
                                tempCount++;
                            }
                        }
                        if (tempCount +1 == tempArrayListProcessed.size() ) {
                            totalCount++;
                            System.out.println(totalCount + " number of common ones in a group");
                        }
                        tempCount = 0;
                    }
                    tempString = "";
                    tempArrayListProcessed.clear();
                    countNumOfMembersInAGroup = 0;
                    System.out.println( " new group");
                }


            }

            if (inputArray.size() - 1 == i) {

                    if (countNumOfMembersInAGroup == 1) {
                        totalCount += tempArrayListProcessed.get(0).length();
                    }
                    else if (countNumOfMembersInAGroup > 1) {
                        tempString = tempArrayListProcessed.get(0);
                        for (int k = 0; k < tempString.length(); k++) {
                            for (int j = 1; j < tempArrayListProcessed.size(); j++) {
                                if (containsChar(tempString.charAt(k), tempArrayListProcessed.get(j))) {
                                    tempCount++;
                                }
                            }
                            if (tempCount+1 == tempArrayListProcessed.size()) {
                                totalCount++;
                                System.out.println(totalCount + " number of common ones in a group for group end");
                            }

                            tempCount = 0;
                        }
                        tempString = "";

                    }
                countNumOfMembersInAGroup = 0;
                tempArrayListProcessed.clear();
                }
            }
        System.out.println(totalCount);
        }


    // advent of code Day6 part 2 separate Function
    public static boolean containsChar(char k, String input){
        boolean result = false;
        for(int i =0; i<input.length(); i++){
            if(input.charAt(i)==k){
                result = true;
                break;
            }
        }
        return result;
    }

}
