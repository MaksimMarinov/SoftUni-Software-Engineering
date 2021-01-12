function objConverter(arg1, arg2, arg3){
    let object = {
        name: arg1,
        lastName: arg2,
        hairColor: arg3
    }
    let json = JSON.stringify(object);

    console.log(json);
}objConverter('George',
'Jones',
'Brown'
)