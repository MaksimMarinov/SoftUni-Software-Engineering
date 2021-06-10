package workingWithAbstraction.jediGalaxy;

public class StarsManipulator {
    private Galaxy galaxy;

    public StarsManipulator(Galaxy galaxy){
        this.galaxy=galaxy;
    }
    public void destroyStars(int[] enemyPositions){
        int enemyRow=enemyPositions[0];
        int enemyCol = enemyPositions[1];
        while (enemyRow>=0&&enemyCol>=0){
            if(isInRange(enemyRow, enemyCol)){
                this.galaxy.setStar(enemyRow, enemyCol, new Star(0));
            }
            enemyRow--;
            enemyCol--;
        }

    }

    private boolean isInRange(int enemyRow, int enemyCol) {
        return enemyRow>=0&&enemyCol>=0&&enemyRow<this.galaxy.getRows()&& enemyCol < this.galaxy.getColumns(enemyRow);
    }
    public long sumOfStars(int[] ivoPositions){
        long sum =0;
        int ivoRow = ivoPositions[0];
        int ivoCol =  ivoPositions[1];
        while (ivoRow>=0&&ivoCol<this.galaxy.getColumns(0)){
            if(isInRange(ivoRow, ivoCol)){
                sum+=this.galaxy.getStarValue(ivoRow,ivoCol);
            }
            ivoRow--;
            ivoCol++;
        }
        return sum;
    }
}
