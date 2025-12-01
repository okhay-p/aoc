const fs = require('fs')
const data = fs.readFileSync('./day5.txt', 'utf8').split('\r\n')


// seeds = []
// map = [[],[]]
let seeds = data[0].trim().split(/\s+/g)
data.shift()
seeds.shift()

console.log(seeds)

/* while (!data[0]) data.shift()

let seedToSoilMap = []
do {
    let mapper = data[0].trim().split(/\s+/g)
    seedToSoilMap.push(mapper)
    data.shift()
} while (data[0])
seedToSoilMap.shift()

while (!data[0]) data.shift()
let soilToFertilizerMap = []
do {
    let mapper = data[0].trim().split(/\s+/g)
    soilToFertilizerMap.push(mapper)
    data.shift()
} while (data[0])
soilToFertilizerMap.shift()

while (!data[0]) data.shift()
let fertilizerToWaterMap = []
do {
    let mapper = data[0].trim().split(/\s+/g)
    fertilizerToWaterMap.push(mapper)
    data.shift()
} while (data[0])
fertilizerToWaterMap.shift()

while (!data[0]) data.shift()
let waterToLightMap = []
do {
    let mapper = data[0].trim().split(/\s+/g)
    waterToLightMap.push(mapper)
    data.shift()
} while (data[0])
waterToLightMap.shift()

while (!data[0]) data.shift()
let lightToTemperatureMap = []
do {
    let mapper = data[0].trim().split(/\s+/g)
    lightToTemperatureMap.push(mapper)
    data.shift()
} while (data[0])
lightToTemperatureMap.shift()

while (!data[0]) data.shift()
let temperatureToHumidityMap = []
do {
    let mapper = data[0].trim().split(/\s+/g)
    temperatureToHumidityMap.push(mapper)
    data.shift()
} while (data[0])
temperatureToHumidityMap.shift()

while (!data[0]) data.shift()
let humidityToLocationMap = []
do {
    let mapper = data[0].trim().split(/\s+/g)
    humidityToLocationMap.push(mapper)
    data.shift()
} while (data[0])
humidityToLocationMap.shift()

function mapperFn(srcNum, destStart, srcStart, range) {
    srcNum = parseInt(srcNum)
    srcStart = parseInt(srcStart)
    destStart = parseInt(destStart)
    range = parseInt(range)


    if (srcNum < srcStart || srcNum > srcStart + range)
        return srcNum
    let offset = destStart - srcStart

    return srcNum + offset
}

let locations =[]

for (let i = 0; i < seeds.length; i++) {
    for (let mapRange of seedToSoilMap) {
        let mappedResult = mapperFn(seeds[i], mapRange[0], mapRange[1], mapRange[2])
        if (mappedResult != seeds[i]) {
            seeds[i] = mappedResult
            break
        }
    }
    
    for (let mapRange of soilToFertilizerMap) {
        let mappedResult = mapperFn(seeds[i], mapRange[0], mapRange[1], mapRange[2])
        if (mappedResult != seeds[i]) {
            seeds[i] = mappedResult
            break
        }
    }

    for (let mapRange of fertilizerToWaterMap) {
        let mappedResult = mapperFn(seeds[i], mapRange[0], mapRange[1], mapRange[2])
        if (mappedResult != seeds[i]) {
            seeds[i] = mappedResult
            break
        }
    }

    for (let mapRange of waterToLightMap) {
        let mappedResult = mapperFn(seeds[i], mapRange[0], mapRange[1], mapRange[2])
        if (mappedResult != seeds[i]) {
            seeds[i] = mappedResult
            break
        }
    }

    for (let mapRange of lightToTemperatureMap) {
        let mappedResult = mapperFn(seeds[i], mapRange[0], mapRange[1], mapRange[2])
        if (mappedResult != seeds[i]) {
            seeds[i] = mappedResult
            break
        }
    }

    for (let mapRange of temperatureToHumidityMap) {
        let mappedResult = mapperFn(seeds[i], mapRange[0], mapRange[1], mapRange[2])
        if (mappedResult != seeds[i]) {
            seeds[i] = mappedResult
            break
        }
    }

    for (let mapRange of humidityToLocationMap) {
        let mappedResult = mapperFn(seeds[i], mapRange[0], mapRange[1], mapRange[2])
        if (mappedResult != seeds[i]) {
            seeds[i] = mappedResult
            break
        }
    }
    locations.push(seeds[i])
}

locations.sort((a,b) => a-b)
console.log(locations[0]) */