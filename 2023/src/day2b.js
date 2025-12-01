let ans = 0;

const fs = require('fs')
const data = fs.readFileSync('./day2.txt', 'utf8').split('\n')

data.forEach(row => {
    let rowData = {
        red: 0,
        green: 0,
        blue: 0
    }
    let gameId = row.split(':')[0]
    rowData.id = parseInt(gameId.split(' ')[1])

    let gameSets = row.split(':')[1].trim().split('; ')
    for (let elem of gameSets) {
        let colorCount = elem.split(', ')
        for (let color of colorCount) {
            let colorName = color.split(' ')[1]
            let colorValue = parseInt(color.split(' ')[0])
            if (colorValue > rowData[colorName])
                rowData[colorName] = colorValue
        }
    }

    ans += rowData.red * rowData.green * rowData.blue

})

console.log(ans)