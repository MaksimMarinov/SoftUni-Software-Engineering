function createAssemblyLine() {

    return {
        hasClima: (car) => {
            car.temp= 21;
            car.tempSettings=21;
            car.adjustTemp=()=>{
                car.temp<car.tempSettings?car.temp++:car.temp--
            };
                },
        hasAudio: (car)=>{
            car.currentTrack={
                name: '',
                artist: ''
            };
            car.nowPlaying=()=>{
                if(car.currentTrack!=null){
                    console.log(`Now playing '${car.currentTrack.name}' by ${car.currentTrack.artist}`);
                }

            }
        },
        hasParktronic: (car)=>{
            car.checkDistance=(distance)=>{
                if(distance<0.1){
                    console.log('Beep! Beep! Beep');
                }else if(distance<0.25){
                    console.log('Beep! Beep!');;
                }else if(distance<0.5){
                    console.log('Beep');;
                }
            }
        }

    };

}

const assemblyLine = createAssemblyLine();

const myCar = {
    make: 'Toyota',
    model: 'Avensis'
};




assemblyLine.hasAudio(myCar);
myCar.currentTrack = {
    name: 'Never Gonna Give You Up',
    artist: 'Rick Astley'
};
myCar.nowPlaying();

assemblyLine.hasParktronic(myCar);
myCar.checkDistance(0.4);
myCar.checkDistance(0.2);
