const fs = require('fs')
const data = fs.readFileSync('./day4.txt', 'utf8').split('\n')


let cardArr = []
for (let line of data) {
    // console.log(line)
    let lineArr = line.split(':')
    let card = {}
    card.winningNums = lineArr[1].split('|')[0].trim().split(/\s+/g)
    card.myNums = lineArr[1].split('|')[1].trim().split(/\s+/g)
    card.countOfMatch = 0
    card.qty = 1
    cardArr.push(card)
}

for (let i = 0; i < cardArr.length; i++) {
    for (let item of cardArr[i].myNums) {
        if (cardArr[i].winningNums.includes(item)) {
            cardArr[i].countOfMatch++;
        }
    }
    let multiplier = cardArr[i].qty
    for (let j = i+1 ; j < cardArr[i].countOfMatch+i+1; j++) {
        cardArr[j].qty+=multiplier
    }
}

let ans = cardArr.reduce((acc, card) => {
    return acc + card.qty
}, 0)


console.log(ans)