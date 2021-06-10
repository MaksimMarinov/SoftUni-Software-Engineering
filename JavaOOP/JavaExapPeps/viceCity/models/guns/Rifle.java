package viceCity.models.guns;

public class Rifle extends BaseGun{
    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        if(this.getBulletsPerBarrel()==0&&this.getTotalBullets()>=50){
            this.setTotalBullets(this.getTotalBullets()-50);
            this.setBulletsPerBarrel(45);
            return 5;
        }else if(this.getTotalBullets()==0&&this.getBulletsPerBarrel()==0){

            return 0;
        }else{
            this.setBulletsPerBarrel(this.getBulletsPerBarrel()-5);
            return 5;
        }
    }
}
