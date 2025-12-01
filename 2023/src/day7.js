const fs = require('fs')
const data = fs.readFileSync('./day7.txt', 'utf8').split('\n')


/* 

7. Five of a kind, where all five cards have the same label: AAAAA
6. Four of a kind, where four cards have the same label and one card has a different label: AA8AA
5. Full house, where three cards have the same label, and the remaining two cards share a different label: 23332
4. Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
3. Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
2. One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
1. High card, where all cards' labels are distinct: 23456

*/

function getStrongnessOfHand(hand) {
    let handArr = hand.split('')
    let handObj = {}
    for (let card of handArr) {
        if (handObj[card]) {
            handObj[card]++
        } else {
            handObj[card] = 1
        }
    }
    let handArr2 = []
    for (let key in handObj) {
        handArr2.push(handObj[key])
    }
    handArr2.sort((a, b) => b - a)
    let handStr = handArr2.join('')
    if (handStr == '11111') return 1
    if (handStr == '2111') return 2
    if (handStr == '221') return 3
    if (handStr == '311') return 4
    if (handStr == '32') return 5
    if (handStr == '41') return 6
    if (handStr == '5') return 7
}

function getCardValue(card) {
    if (card == 'A') return 14
    if (card == 'K') return 13
    if (card == 'Q') return 12
    if (card == 'J') return 11
    if (card == 'T') return 10
    return parseInt(card)
}

function compareCard(a, b) {
    if (a.strongness > b.strongness) return 1
    if (a.strongness < b.strongness) return -1
    if (a.strongness == b.strongness) {
        for(let i = 0; i < a.hand.length; i++) {
            if(getCardValue(a.hand[i]) > getCardValue(b.hand[i])) return 1
            if(getCardValue(a.hand[i]) < getCardValue(b.hand[i])) return -1
        }

    }
    return 0
}

let cardData = []
for (let row of data) {
    let cardObj = {}
    row = row.trim()
    let splitRow = row.split(' ')
    cardObj.hand = splitRow[0]
    cardObj.bid = splitRow[1]
    cardObj.strongness = getStrongnessOfHand(cardObj.hand)
    cardData.push(cardObj)
}

cardData.sort(compareCard)
// console.log(cardData)

let ans = 0

for (let i=0; i < cardData.length; i++) {
    ans+=parseInt(cardData[i].bid)* (i+1)
}
console.log(ans)