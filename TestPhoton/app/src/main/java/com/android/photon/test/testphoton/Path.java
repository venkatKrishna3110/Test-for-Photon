package com.android.photon.test.testphoton;


import java.util.ArrayList;
import java.util.List;

public class Path {

    int matrix[][];
    int max_width, max_height, resultCost = Integer.MAX_VALUE;
    final int MAX_COST = 50;
    String msg = "";
    String resultPath = "";
    boolean conditonBreak = false;

    static int finalCost = 0;
    static String finalPath;
    static String isPath;
    String val = "";
    boolean nonNumeric;

    Path(int[][] a) {

        this.matrix = a;
        max_width = this.matrix[0].length;
        max_height = this.matrix.length;
        if ((max_height == 0) && (max_width == 0)) {
            List<String> trv = new ArrayList<>();
            trv.add("" + -1);
        }

    }

    public void start() {
        int j = 0;
        int loopController = 0;
        for (int i = 0; i < max_height; i++) {
            System.out.println("row " + (i + 1) + " col " + (j + 1));
            f(i, j, 0, "");
            loopController++;
            if (loopController > Math.pow(3, TheMatrix.col))
                break;
        }
        display();
    }

    private void display() {
        System.out.println("Final Out!!");
        if (conditonBreak) {
            System.out.println("No");
            isPath = "No";
        } else {
            System.out.println("Yes");
            isPath = "Yes";
        }
        if (Integer.MAX_VALUE == resultCost) resultCost = 0;
        System.out.println(resultCost);
        finalCost = resultCost;
        System.out.println("[" + resultPath.replaceAll(",", " ").trim() + "]");
        finalPath = "[" + resultPath.replaceAll(",", " ").trim() + "]";


    }

    public String matrixchk(final int[][] matrixTest) {
        val = "";
        if (matrixTest.length < 0) {
            return "invalid";
        } else {
            int row = matrixTest.length;
            int col = matrixTest[0].length;
            int loopController = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    nonNumeric = chkNonNumeric("" + matrixTest[i][j]);
                    if (nonNumeric == false) {
                        val = "invlalid";
                        break;
                    } else {
                        val = "valid";
                    }
                    loopController++;
                    if (loopController > Math.pow(3, TheMatrix.col))
                        break;
                }
            }
            return val;
        }
    }


    public List<String> traverse(final int[][] sample1) {
        final List<String> traverseList = new ArrayList<>();
        new Path(sample1).start();
        String validChk = matrixchk(sample1);
        if (validChk.equalsIgnoreCase("valid")) {
            System.out.println("TRAVERSE " + finalCost);
            String s = Integer.toString(finalCost);
            String cond;
            if (conditonBreak)
                cond = "No";
            else {
                cond = "Yes";
            }
            traverseList.add(s);
            traverseList.add(finalPath);
            traverseList.add(isPath);
        } else {
            traverseList.add("invalid Matrix");
            String val = Integer.toString(-1);
            traverseList.add(val);
        }
        return traverseList;
    }

    public void f(int row, int col, int currentCost, String currentPath) {
        List<Position> nextPosiList = null;
        boolean conditionMaxCost = false;
        if (matrix[row][col] + currentCost < MAX_COST) {
            currentPath += (row + 1) + ",";
            currentCost += matrix[row][col];
            nextPosiList = getAdjPosition(row, col);
        } else {
            conditionMaxCost = true;

        }
        if (nextPosiList != null) {// sort the position
            int loopController = 0;
            for (Position p : nextPosiList) {
                f(p.x, p.y, currentCost, currentPath);
                System.out.println(p + " " + currentPath);
                loopController++;
                if (loopController > Math.pow(3, TheMatrix.col))
                    break;
            }
        } else {
// current set Finished
            if (resultCost >= currentCost) {
                if (!conditionMaxCost) {
                    resultCost = currentCost;
                    resultPath = currentPath;
                    conditonBreak = false;
                    System.out.println("success currentPath " + resultPath + " cost " + resultCost);
                } else if (resultPath.length() < currentPath.length()) {
                    resultCost = currentCost;
                    resultPath = currentPath;
                    conditonBreak = true;
                    System.out.println("break currentPath " + resultPath + " cost " + resultCost);
                }

            } else if (currentPath.length() >= max_width * 2 && conditonBreak) {
                if (!conditionMaxCost) {
                    resultCost = currentCost;
                    resultPath = currentPath;
                    conditonBreak = false;
                    System.out.println("full success currentPath " + resultPath + " cost " + resultCost);
                } else {
                    resultCost = currentCost;
                    resultPath = currentPath;
                    conditonBreak = true;
                    System.out.println("full break currentPath " + resultPath + " cost " + resultCost);

                }
            } else if (resultPath.length() < currentPath.length() && (conditionMaxCost)) {
                resultCost = currentCost;
                resultPath = currentPath;
                conditonBreak = true;
            }

        }

    }

    public List<Position> getAdjPosition(int row, int col) {
        int nexCol = col + 1;
        List<Position> list = new ArrayList<>();
        if (matrix[row].length > nexCol) {// same row next column
            Position p = new Position(row, nexCol);
            list.add(p);
        } else {
            return null; // now nextCol then end of array.
        }

        if (max_height > row + 1) {
            Position p = new Position(row + 1, nexCol);
            list.add(p);
        } else {
            Position p = new Position(0, nexCol);
            list.add(p);
        }

        if (row - 1 >= 0) {
            Position p = new Position(row - 1, nexCol);
            list.add(p);
        } else {
            Position p = new Position(max_height - 1, nexCol);
            list.add(p);
        }

        return list;
    }

    private boolean chkNonNumeric(String num) {
        boolean isNumber = true;
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException ex) {
            isNumber = false;
        }
        return isNumber;
    }


}

class Position {
    int x;
    int y;

    public Position(int i, int j) {
        x = i;
        y = j;
    }

    @Override
    public String toString() {

        return "x->" + (x + 1) + " y->" + (y + 1);
    }

}
