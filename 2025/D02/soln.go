package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	content, err := os.ReadFile("input.txt")
	ranges := strings.Split(string(content), ",")
	if err != nil {
		fmt.Println("Error reading file:", err)
		return
	}
	var res int

	for _, r := range ranges {
		r = strings.TrimSpace(r)
		arr := strings.Split(r, "-")
		start, err := strconv.Atoi(arr[0])
		end, err := strconv.Atoi(arr[1])
		if err != nil {
			fmt.Println("Error converting to int:", err)
		}

		for i := start; i <= end; i++ {
			strI := strconv.Itoa(i)
			// part 1
			// if len(strI)%2 != 0 {
			// 	continue
			// }
			// e := len(strI) / 2
			// if strI[0:e] == strI[e:] {
			// 	res += i
			// }

			// part 2
			newS := strI + strI
			newS = newS[1 : len(newS)-1]
			s := 0
			for  e := len(strI); e <= len(newS); e++ {
				if newS[s:e] == strI {
					res += i
					break
				}
				s++
			}

		}
	}

	fmt.Println("res")
	fmt.Println(res)

}
