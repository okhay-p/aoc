let ans = 1;

const fs = require('fs')
const data = fs.readFileSync('./day6.txt', 'utf8').split('\n')

let raceArray = []
let time = data[0].trim().replace(/\s+/g, ",").split(',')
let dist = data[1].trim().replace(/\s+/g, ",").split(',')
for (let i = 1; i < time.length && i < dist.length; i++) {
    let raceObj = {};
    raceObj.time = parseInt(time[i])
    raceObj.dist = parseInt(dist[i])
    raceArray.push(raceObj)
}

for (let race of raceArray) {
    console.log(race)
    let numOfWays = 0;
    for (let i = 1; i < Math.ceil(race.time/2); i++) {
        let distTravelled = i*(race.time-i)
        console.log(`At ${i}ms pressed: ${distTravelled}`)
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
    ans*=numOfWays
}

console.log(ans)