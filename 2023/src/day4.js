const fs = require('fs')
const data = fs.readFileSync('./day4.txt', 'utf8').split('\n')

let ans = 0;

for (let line of data) {
    // console.log(line)
    let lineArr = line.split(':')
    let winningNums = lineArr[1].split('|')[0].trim().split(/\s+/g)
    let myNums = lineArr[1].split('|')[1].trim().split(/\s+/g)
    
    let power = 0;
    for (let item of myNums) {
        if (winningNums.includes(item)) {
            power++;
            // console.log(item)
        }
    }
    if (power > 0) ans += Math.pow(2, power - 1)
    // console.log()
}
console.log(ans)