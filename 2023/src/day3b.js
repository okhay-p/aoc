const fs = require('fs')
let data = fs.readFileSync('./day3.txt', 'utf8').split('\n')

let ans = 0;

data = data.map(row => row.trim())

/*  (x,y)
(0,0) (1,0) (2,0) (3,0) (4,0) (5,0) (6,0) (7,0) (8,0) (9,0)
(0,1) (1,1) (2,1) (3,1) (4,1) (5,1) (6,1) (7,1) (8,1) (9,1)
(0,2) (1,2) (2,2) (3,2) (4,2) (5,2) (6,2) (7,2) (8,2) (9,2)
(0,3) (1,3) (2,3) (3,3) (4,3) (5,3) (6,3) (7,3) (8,3) (9,3)
(0,4) (1,4) (2,4) (3,4) (4,4) (5,4) (6,4) (7,4) (8,4) (9,4)
(0,5) (1,5) (2,5) (3,5) (4,5) (5,5) (6,5) (7,5) (8,5) (9,5)
(0,6) (1,6) (2,6) (3,6) (4,6) (5,6) (6,6) (7,6) (8,6) (9,6)
(0,7) (1,7) (2,7) (3,7) (4,7) (5,7) (6,7) (7,7) (8,7) (9,7)
(0,8) (1,8) (2,8) (3,8) (4,8) (5,8) (6,8) (7,8) (8,8) (9,8)
(0,9) (1,9) (2,9) (3,9) (4,9) (5,9) (6,9) (7,9) (8,9) (9,9) 
*/

function numIncludes(str) {
    let indexArr = []
    for (let i in str) {
        if (!isNaN(parseInt(str[i])))
            indexArr.push(i)
    }
    if (indexArr.length == 0) return false;
    return indexArr;
}

let dataArr = []

// y = row number - top to bottom - 0 to 9
for (let y = 0; y < data.length; y++) {
    let row = []
    // x = column number - left to right - 0 to 9
    for (let x = 0; x < data[y].length; x++) {
        row.push(data[y][x])
    }
    dataArr.push(row)
}


// y = row number - top to bottom - 0 to 9
for (let y = 0; y < dataArr.length; y++) {
    // x = column number - left to right - 0 to 9
    for (let x = 0; x < dataArr[y].length; x++) {
        if (dataArr[y][x] == '*') {
            let numArray = [];
            let numX;
            if (numX = numIncludes(dataArr[y - 1].slice(x - 1, x + 2))) {


                if (numX.length == 2 && numX[0] == 0 && numX[1] == 2) {
                    numArray.push([y - 1, parseInt(numX[0]) + x - 1]);
                    numArray.push([y - 1, parseInt(numX[1]) + x - 1]);
                } else {
                    numArray.push([y - 1, parseInt(numX[0]) + x - 1]);
                }
            }
            if (numX = numIncludes(dataArr[y].slice(x - 1, x + 2))) {
                if (numX.length == 2 && numX[0] == 0 && numX[1] == 2) {
                    numArray.push([y, parseInt(numX[0]) + x - 1]);
                    numArray.push([y, parseInt(numX[1]) + x - 1]);
                } else {
                    numArray.push([y, parseInt(numX[0]) + x - 1]);
                }
            }
            if (numX = numIncludes(dataArr[y + 1].slice(x - 1, x + 2))){
                if (numX.length == 2 && numX[0] == 0 && numX[1] == 2) {
                    numArray.push([y + 1, parseInt(numX[0]) + x - 1]);
                    numArray.push([y + 1, parseInt(numX[1]) + x - 1]);
                } else {
                    numArray.push([y + 1, parseInt(numX[0]) + x - 1]);
                }
            }

            if (numArray.length == 2) {
                let num1Row = numArray[0][0];
                let num1Col = numArray[0][1];
                let num1 = dataArr[num1Row][num1Col];
                let i = 1;
                while (!isNaN(parseInt(dataArr[num1Row][num1Col + i])) || i > 10) {
                    num1 += dataArr[num1Row][num1Col + i];
                    i++;
                }
                i = 1;
                while (!isNaN(parseInt(dataArr[num1Row][num1Col - i])) || i > 10) {
                    num1 = dataArr[num1Row][num1Col - i] + num1;
                    i++;
                }

                let num2Row = numArray[1][0];
                let num2Col = numArray[1][1];
                let num2 = dataArr[num2Row][num2Col];
                i = 1;
                while (!isNaN(parseInt(dataArr[num2Row][num2Col + i]))) {
                    num2 += dataArr[num2Row][num2Col + i];
                    i++;
                }
                i = 1;
                while (!isNaN(parseInt(dataArr[num2Row][num2Col - i]))) {
                    num2 = dataArr[num2Row][num2Col - i] + num2;
                    i++;
                }
                console.log("At (" + y + "," + x + "):", num1, num2)
                ans += parseInt(num1) * parseInt(num2);
            }
        }


    }
}

console.log(ans)