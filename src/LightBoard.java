import java.util.Arrays;
import java.util.Random;

public class LightBoard {

    private boolean[][] lights;

    public LightBoard(int numRows, int numCols) {

        lights = new boolean[numRows][numCols];

        for (int i = 0; i < lights.length; i++) {

            for (int j = 0; j < lights[i].length; j++) {

                double flag = Math.random();

                lights[i][j] = flag < 0.4; // Directly assign the boolean value
            }
        }

    }

    public boolean evaluateLight(int row, int col) {

        boolean lightStatus = lights[row][col];

        int lightOnCount = 0;

        for(int i = 0; i < lights.length; i++){

            if(lights[i][col]){

                lightOnCount++;

            }

        }

        if(lightStatus){ // If the light is on, return false if the number of lights in its column that are on is even, including the current light

            if(lightOnCount % 2 == 0){

                return false;

            }

        } else { // If the light is off, return true if the number of lights in its column that are on is divisible by three.

            if (lightOnCount % 3 == 0) {

                return true;


            }
        }

        return lightStatus;
    }

    public void setLights(boolean[][] lights){

        this.lights = lights;

    }

    public boolean[][] getLights() {

        return lights;

    }

}
