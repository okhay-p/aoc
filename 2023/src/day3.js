const fs = require('fs')
const data = fs.readFileSync('./day3.txt', 'utf8').split('\n')

let ans = 0;

const specialChar = ['@', '#', '$', '%', '^', '&', '*', '/', '~', '!', '?', '+', '=', '-']

for (let i = 0; i < data.length; i++) {
    let curRow = data[i].trim()
    let prevRow, nextRow;
    if (i != 0) {
        prevRow = data[i - 1].trim()
    }
    if (i != data.length - 1) {
        nextRow = data[i + 1].trim()
    }

    for (let j = 0; j < curRow.length; j++) {
        let firstIndex, lastIndex;
        if (!isNaN(parseInt(curRow.charAt(j)))) {
            firstIndex = j
            lastIndex = j
        }
        let k = j;
        while (k < curRow.length && !isNaN(parseInt(curRow.charAt(k)))) {
            lastIndex = k
            k++
        }
        j = k
        if (!isNaN(firstIndex) && !isNaN(lastIndex)) {
            if (firstIndex > 0) {
                if (specialChar.includes(curRow.charAt(firstIndex - 1))) {
                    ans += parseInt(curRow.slice(firstIndex, lastIndex + 1))
                    continue;
                }
            }
            if (lastIndex < curRow.length - 1) {
                if (specialChar.includes(curRow.charAt(lastIndex + 1))) {
                    ans += parseInt(curRow.slice(firstIndex, lastIndex + 1))
                    continue;
                }
            }
            if (prevRow) {
                let prevRowData;
                if (firstIndex == 0) {
                    prevRowData = prevRow.slice(firstIndex, lastIndex + 2).split('')
                } else if (lastIndex == curRow.length - 1) {
                    prevRowData = prevRow.slice(firstIndex-1).split('')
                } else {
                    prevRowData = prevRow.slice(firstIndex-1, lastIndex + 2).split('')
                }
                for (let prevI = 0; prevI < prevRowData.length; prevI++) {
                    if (specialChar.includes(prevRowData[prevI])) {
                        ans += parseInt(curRow.slice(firstIndex, lastIndex + 1))
                        break;
                    }
                }
            }

            if (nextRow) {
                let nextRowData;
                if (firstIndex == 0) {
                    nextRowData = nextRow.slice(firstIndex, lastIndex + 2).split('')
                } else if (lastIndex == curRow.length - 1) {
                    nextRowData = nextRow.slice(firstIndex-1).split('')
                } else {
                    nextRowData = nextRow.slice(firstIndex-1, lastIndex + 2).split('')
                }
                for (let nextI = 0; nextI < nextRowData.length; nextI++) {
                    if (specialChar.includes(nextRowData[nextI])) {
                        ans += parseInt(curRow.slice(firstIndex, lastIndex + 1))
                        break;
                    }
                }
            }
        }
    }
}

console.log(ans)
    