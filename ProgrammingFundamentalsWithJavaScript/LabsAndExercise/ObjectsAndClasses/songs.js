function solve(array) {
    let numberOfSongs = Number(array.shift());
    class Songs {
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }
    let arrayOfSongsInfo=[];
    let type = array.pop();
    for (let i = 0; i < numberOfSongs; i++) {
        let [type, name, time] = array[i].split('_');
        let song = new Songs(type, name, time);
        arrayOfSongsInfo.push(song)

    };
    if(type=='all'){
        arrayOfSongsInfo.forEach(e=>console.log(e.name));
    }else{
        arrayOfSongsInfo.filter((i)=>i.typeList===type).forEach(e=>console.log(e.name))
    }
    


}solve([3,
    'favourite_DownTown_3:14',
    'favourite_Kiss_4:16',
    'favourite_Smooth Criminal_4:01',
    'favourite']);
solve([4,
    'favourite_DownTown_3:14',
    'listenLater_Andalouse_3:24',
    'favourite_In To The Night_3:58',
    'favourite_Live It Up_3:48',
    'listenLater']);
solve([2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all']
)