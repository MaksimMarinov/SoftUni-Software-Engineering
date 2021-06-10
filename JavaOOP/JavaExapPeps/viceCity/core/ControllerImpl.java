package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.*;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private List<Player> civilPlayers ;
    private GangNeighbourhood gangNeighbourhood;
    private MainPlayer mainPlayer;
    private ArrayDeque<Gun> guns;

    public ControllerImpl() {
        this.civilPlayers = new ArrayList<>();
        this.gangNeighbourhood = new GangNeighbourhood();
        this.mainPlayer= new MainPlayer();
        this.guns=new ArrayDeque<>();
    }

    @Override
    public String addPlayer(String name) {
        civilPlayers.add(new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        if(type.equals("Pistol")){
            gun = new Pistol(name);
        }else if(type.equals("Rifle")){
            gun=new Rifle(name);
        }else{
           return GUN_TYPE_INVALID;
        }
       guns.offer(gun);
        return String.format( GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if(guns.isEmpty()){
            return GUN_QUEUE_IS_EMPTY;
        }
        if(name.equals("Vercetti")){
            Gun gun = guns.poll();
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }
        Player civilPlayer = civilPlayers.stream().filter(player -> player.getName().equals(name)).findFirst().orElse(null);
        if(civilPlayer==null){
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        Gun gun = guns.poll();
        civilPlayer.getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civilPlayer.getName());
    }

    @Override
    public String fight() {
        if(mainPlayer.getGunRepository().getModels().isEmpty()
                &&civilPlayers.stream().filter(player -> player.getGunRepository().getModels().size()>0).count()<=0){
            return FIGHT_HOT_HAPPENED;
        }
        int startCurrentCivilPlayers = civilPlayers.size();
        gangNeighbourhood.action(mainPlayer, civilPlayers);
        long aliveCivilPlayers =civilPlayers.stream().filter(Player::isAlive).count();
        StringBuilder result = new StringBuilder();
        result.append(FIGHT_HAPPENED).append(System.lineSeparator());
        result.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
        result.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,startCurrentCivilPlayers- aliveCivilPlayers)).append(System.lineSeparator());
        result.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, aliveCivilPlayers));
        return result.toString();
    }
}
