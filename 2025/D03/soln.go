package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	content, err := os.ReadFile("input.txt")
	banks := strings.Split(string(content), "\n")
	if err != nil {
		fmt.Println("Error reading file:", err)
		return
	}

	var res int;

	for _, bank := range banks {
		bankArr := strings.Split(bank, "")
		if len(bankArr) <=0 {
			break
		}
		var numArr []int
		for _, c := range bankArr {
			intC, _ := strconv.Atoi(c)
			numArr = append(numArr, intC)
		}


		sI, sV := getMax(numArr[:len(numArr)-1])
		numArr = numArr[sI+1:]
		_, eV := getMax(numArr)
		bankMax := strconv.Itoa(sV) + strconv.Itoa(eV)

		fmt.Println(bankMax)
		bM, _ := strconv.Atoi(bankMax)
		res += bM

	}
	fmt.Println(res)

}

func getMax(arr []int) (int, int) {
	curMax := 0
	maxIdx := 0

	for i, val := range arr {
		if val > curMax {
			curMax = val
			maxIdx = i
		}
	}

    return maxIdx, curMax
}
