const number = {
    one: 1,
    two: 2,
    three: 3,
    four: 4,
    five: 5,
    six: 6,
    seven: 7,
    eight: 8,
    nine: 9,
    twone: 21,
    eightwo: 82,
    eighthree: 83,
    oneight: 18,
    threeight: 38,
    fiveight: 58,
    nineight: 98,
    sevenine: 79,
}

const pattern1 = /(twone|eightwo|eighthree|oneight|threeight|fiveight|nineight|sevenine)/g;
const pattern2 = /(one|two|three|four|five|six|seven|eight|nine)/g;

function convertNumbers(text, p) {

    return text.replace(p, (match) => {
        if (number[match])
            return number[match].toString();
    });
}

const fs = require('fs')

const data = fs.readFileSync('./day1.txt', 'utf8').split('\n')

let sum = 0

data.forEach(row => {
    let firstDigit, lastDigit;
    row = convertNumbers(row, pattern1)
    row = convertNumbers(row, pattern2)
    console.log(row)
    for (let i = 0; i < row.length; i++) {
        if (!isNaN(parseInt(row[i]))) {
            firstDigit = parseInt(row[i])
            break;
        }
    }

    for (let i = row.length - 1; i >= 0; i--) {
        if (!isNaN(parseInt(row[i]))) {
            lastDigit = parseInt(row[i])
            break;
        }
    }
    console.log(firstDigit, lastDigit)
    if (firstDigit || lastDigit)
        sum += firstDigit * 10 + lastDigit
})

console.log(sum)

