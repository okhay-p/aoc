/* 
seeds: 79 14 55 13

seed-to-soil map:
50 98 2
52 50 48 
*/

// srcNum, srcStart, srcRange, destStart, destRange


function mapper(srcNum, srcStart, destStart, range) {
    srcNum = parseInt(srcNum)
    srcStart = parseInt(srcStart)
    destStart = parseInt(destStart)
    range = parseInt(range)

    console.log(srcNum, srcStart, destStart, range)

    if (srcNum < srcStart || srcNum > srcStart + range) 
        return srcNum
    let offset = destStart - srcStart

    return srcNum + offset
}

console.log(mapper(79, 50, 52, 58))