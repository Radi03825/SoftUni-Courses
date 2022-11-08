function calculateTime (steps, foot, speed) {
    let breaks = Math.floor(steps * foot / 500) * 60;
    let speedSeconds = speed * 1000 / 3600;
    let totaltime = steps * foot / speedSeconds + breaks;
    let secs = totaltime % 60;
    let mins = Math.floor(totaltime / 60);
    let hours = 0
    if (mins > 59){
        hours  = Math.floor(mins / 60);
        mins = mins % 60
    }
    secs = Math.round(secs)
    mins = ('0' + mins.toString()).slice(-2)
    hours = ('0' + hours.toString()).slice(-2)
    console.log(`${hours}:${mins}:${secs}`);
}

calculateTime(    5000, 0.60, 5);