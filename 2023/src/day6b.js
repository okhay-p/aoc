let ans = 1;

const fs = require('fs')
const data = fs.readFileSync('./day6.txt', 'utf8').split('\n')


let time = data[0].trim().replace(/\s+/g, "").split(':')
let dist = data[1].trim().replace(/\s+/g, "").split(':')

let race = {
    time: parseInt(time[1]),
    dist: parseInt(dist[1])
}
let numOfWays = 0;
    for (let i = 1; i < Math.ceil(race.time/2); i++) {
        let distTravelled = i*(race.time-i)
        if (distTravelled > race.dist)
        {
            // console.log(i)
            numOfWays++;
        }
    }
    if(race.time%2==0) {
        numOfWays = numOfWays * 2 + 1
    } else {
        numOfWays *= 2
    }



console.log(numOfWays)