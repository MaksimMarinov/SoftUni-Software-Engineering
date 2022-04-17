function attachEventsListeners() {

    const ratios = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400

    }
    const days = document.getElementById('days');
    const hours = document.getElementById('hours');
    const minutes = document.getElementById('minutes');
    const seconds = document.getElementById('seconds');
    document.getElementById('daysBtn').addEventListener('click', onConvert );
    document.getElementById('hoursBtn').addEventListener('click', onConvert );;
    document.getElementById('minutesBtn').addEventListener('click', onConvert );;
    document.getElementById('secondsBtn').addEventListener('click', onConvert );;

    function convert(value, unit){
        const days = value/ratios[unit];

        return {
            days: days,
            hours: days*ratios.hours,
            minutes: days*ratios.minutes,
            seconds: days*ratios.seconds
        }
    }
    function onConvert(ev){
        const input = ev.target.parentElement.querySelector('input[type="text"]');

        const time = convert(Number(input.value), input.id);
        days.value = time.days;
        hours.value = time.hours;
        minutes.value = time.minutes;
        seconds.value = time.seconds;

    }

}