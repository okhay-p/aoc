const fs = require('fs')

const data = fs.readFileSync('./day1.txt', 'utf8').split('\n')

let sum = 0

data.forEach(row => {
    let firstDigit, lastDigit;
    for(let i = 0; i < row.length; i++) {
        if(!isNaN(parseInt(row[i]))) {
            firstDigit = parseInt(row[i])
            break;
        }
    }

    for(let i = row.length - 1; i >= 0; i--) {
        if(!isNaN(parseInt(row[i]))) {
            lastDigit = parseInt(row[i])
            break;
        }
    }
    if(firstDigit || lastDigit)
        sum += firstDigit*10 + lastDigit
})

console.log(sum)