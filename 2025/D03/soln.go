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


		// part 1
		// sI, sV := getMax(numArr[:len(numArr)-1])
		// numArr = numArr[sI+1:]
		// _, eV := getMax(numArr)
		// bankMax := strconv.Itoa(sV) + strconv.Itoa(eV)

		// fmt.Println(bankMax)
		// bM, _ := strconv.Atoi(bankMax)
		// res += bM

		// part 2
		ls := 0
		// fmt.Println("bank:",bank)
		bankMax := ""
		for nd := 11; nd >= 0; nd--{
			// fmt.Println(numArr)
			// fmt.Println("remaining length",len(numArr))
			// fmt.Println("nd",nd)
			if len(numArr) == nd+1{
				nd = 0
				strArr := []string {}
				for _, n := range numArr {
					ns := strconv.Itoa(n)
					strArr = append(strArr, ns)
				}
				rn := strings.Join(strArr, "")
				bankMax += rn
				continue
			}

			curArr := numArr[:len(numArr)-nd]
			// fmt.Println("curArr",curArr)
			cI, cV := getMax(curArr)
			ls = cI
			numArr = numArr[ls+1:]
			// fmt.Println("digit:", 12-nd)
			// fmt.Println("cV",cV)
			// fmt.Println("ls",ls)
			bankMax+=strconv.Itoa(cV)
			// fmt.Println()
		}
		// fmt.Println("bankMax",bankMax)
		bm, err := strconv.Atoi(bankMax)
		if err != nil{
			fmt.Println(err)
		}
		res += bm

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
