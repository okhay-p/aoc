package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	content, _ := os.ReadFile("sample_input.txt")
	rows := strings.Split(string(content), "\n")
	var mapArr [][]string
	for _,row := range rows{
		if len(row) > 0{
			mapArr = append(mapArr, strings.Split(row, ""))
		}
	}

	var res int

	for i := 0; i < len(mapArr); i++ {
		for j := 0; j < len(mapArr[i]); j++ {
			if mapArr[i][j] == "@" && getNumInNeighbours(mapArr, i, j) < 4 {
				fmt.Printf("i: %d, j: %d\n", i, j)
				res += 1
			}
		}

	}
	fmt.Println(res)

}

func getNumInNeighbours(m [][]string, i int, j int) int {
    count := 0
    a := []int {-1, 0, 1}
    for dx := range a {
        if i + dx >= len(m) || i + dx < 0 {
            continue
        }
        for dy := range a {
	        if j + dy >= len(m[0]) || j + dy < 0 {
	            continue
	        }
			if m[i+dx][j+dy] == "@" {
				count += 1
			}
        }
    }
    return count
}
