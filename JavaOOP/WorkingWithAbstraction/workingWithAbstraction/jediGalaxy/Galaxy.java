package workingWithAbstraction.jediGalaxy;

public class Galaxy {
    private Star[][] stars;

    public Galaxy(int rows, int cols){
        this.stars=new Star[rows][cols];
        this.fillStars();
    }

    private void fillStars() {
        int startValue=0;
        for (int i = 0; i < this.stars.length; i++) {
            for (int j = 0; j < this.stars[i].length; j++) {
                this.stars[i][j]=new Star(startValue++);
            }   
        }
    }

    public void setStar(int row, int col, Star star) {
        if(isInRange(row, col)){
            this.stars[row][col] = star;
        }

    }
    public int getRows() {
        return this.stars.length;
    }

    public int getColumns(int row) {
        return this.stars[row].length;
    }

    private boolean isInRange(int row, int col) {
        return row>=0&&row<this.stars.length&&col>=0&&col<stars[row].length;
    }
    public int getStarValue(int row, int col){
        int value = 0;
        if(isInRange(row, col)){
            value=this.stars[row][col].getValue();
        }
        return value;
    }

}
