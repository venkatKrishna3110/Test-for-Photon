package com.android.photon.test.testphoton;


import java.util.List;

import static junit.framework.Assert.assertEquals;

public class PathTest {

    private List<String> objectAndArray(int sample[][]){
        Path pathTest = new Path(sample);
        List<String> pathOrder = pathTest.traverse(sample);

        return pathOrder;
    }

    public void traverse() {
        String cost;
        String path;
        String des;
        int sample[][] = {{3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}
        };

        List<String> pathOrder=objectAndArray(sample);

        int pathCost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(16, pathCost);
    }

    public void traverseSecond() {
        String cost;
        String path;
        String des;
        int sample[][] = {{19, 10, 19, 10, 19}, {21, 23, 20, 19, 12}, {20, 12, 20, 11, 10}};

        List<String> pathOrder=objectAndArray(sample);

        int trcost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(48, trcost);
    }

    public void traverseThird() {
        String cost;
        String path;
        String des;
        int sample[][] = {{5, 8, 5, 3, 5}};

        List<String> pathOrder=objectAndArray(sample);

        int trcost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(26, trcost);
    }

    public void traverseFour() {
        String cost;
        String path;
        String des;
        int sample[][] = {{5},
                {8},
                {5},
                {3},
                {5}};

        List<String> pathOrder=objectAndArray(sample);

        int trcost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(3, trcost);
    }

    public void traverseFive() {
        String cost;
        String path;
        String des;
        int sample[][] = {{69, 10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {60, 12, 20, 11, 10}};

        List<String> pathOrder=objectAndArray(sample);

        int trcost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(0, trcost);
    }

    public void traverseSix() {
        String cost;
        String path;
        String des;
        int sample[][] = {{60, 3, 3, 6},
                {6, 3, 7, 9},
                {5, 6, 8, 3}};

        List<String> pathOrder=objectAndArray(sample);

        int trcost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(14, trcost);
    }

    public void traverseSeven() {
        String cost;
        String path;
        String des;
        int sample[][] = {{6, 3, -5, 9},
                {-5, 2, 4, 10},
                {3, -2, 6, 10},
                {6, -1, -2, 10}};

        List<String> pathOrder=objectAndArray(sample);

        int trcost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(0, trcost);
    }

    public void traverseEight() {
        String cost;
        String path;
        String des;
        int sample[][] = {{51, 51},
                {0, 51},
                {51, 51},
                {5, 5}
        };

        List<String> pathOrder=objectAndArray(sample);

        int trcost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(10, trcost);
    }

    public void traversenine() {
        String cost;
        String path;
        String des;
        int sample[][] = {
                {51, 51, 51},
                {0, 51, 51},
                {51, 51, 51},
                {5, 5, 51}
        };

        List<String> pathOrder=objectAndArray(sample);

        int trcost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(10, trcost);
    }

    public void traversenten() {
        String cost;
        String path;
        String des;
        int sample[][] = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };

        List<String> pathOrder=objectAndArray(sample);

        int trcost = Integer.parseInt(pathOrder.get(0));
        path = pathOrder.get(1);
        des = pathOrder.get(2);
        assertEquals(20, trcost);

    }


    public void traverseValidChk() {
        int sample[][] = {{5, 6, 'M'}, {8, 3, 'N'}

        };

        List<String> pathOrder=objectAndArray(sample);

        int valitBit = Integer.parseInt(pathOrder.get(1));
        assertEquals(-1, valitBit);
    }

}
