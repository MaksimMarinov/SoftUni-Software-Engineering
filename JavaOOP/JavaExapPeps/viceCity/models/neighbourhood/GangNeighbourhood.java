package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood{
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> mainPlayerGuns = mainPlayer.getGunRepository().getModels();
        while ( mainPlayerGuns.stream().anyMatch(Gun::canFire)&&
        civilPlayers.stream().anyMatch(Player::isAlive)) {
            for (Gun mainPlayerGun : mainPlayerGuns) {
                for (Player civilPlayer : civilPlayers) {
                    while (mainPlayerGun.canFire() && civilPlayer.isAlive()) {
                        civilPlayer.takeLifePoints(mainPlayerGun.fire());
                    }
                    if (!mainPlayerGun.canFire()) {
                        break;
                    }
                }

            }
        }
        civilPlayers=civilPlayers.stream().filter(Player::isAlive).collect(Collectors.toList());

            for (Player civilPlayer : civilPlayers) {
               Collection<Gun> guns = civilPlayer.getGunRepository().getModels();
                for (Gun gun : guns) {
                    while (mainPlayer.isAlive()||gun.canFire()){
                        mainPlayer.takeLifePoints(gun.fire());
                    }
                    if(!mainPlayer.isAlive()){
                        break;
                    }
                }
                if(!mainPlayer.isAlive()){
                    break;
                }
            }

        }
    }

