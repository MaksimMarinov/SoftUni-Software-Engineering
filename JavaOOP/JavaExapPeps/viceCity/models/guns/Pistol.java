package viceCity.models.guns;

public class Pistol extends BaseGun{
    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public int fire() {
      if(this.getBulletsPerBarrel()==0&&this.getTotalBullets()>=10){
          this.setTotalBullets(this.getTotalBullets()-10);
          this.setBulletsPerBarrel(9);
          return 1;
      }else if(this.getTotalBullets()==0&&this.getBulletsPerBarrel()==0){

          return 0;
      }else{
          this.setBulletsPerBarrel(this.getBulletsPerBarrel()-1);
          return 1;
      }
    }
}
