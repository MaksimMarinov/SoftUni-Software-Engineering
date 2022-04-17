function ConstructionCrew(object){

        if(object['dizziness']) {
            object['levelOfHydrated']=object['levelOfHydrated'] + 0.1 * object['experience'] * object['weight'];
            object['dizziness']=false;
        }
        return object;
}

console.log(ConstructionCrew({
        weight: 80,
        experience: 1,
        levelOfHydrated: 0,
        dizziness: true
    }
));