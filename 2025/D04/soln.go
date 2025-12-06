package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	content, _ := os.ReadFile("input.txt")
	rows := strings.Split(string(content), "\n")
	var mapArr [][]string
	for _, row := range rows {
		row = strings.TrimSpace(row)
		if len(row) > 0 {
			mapArr = append(mapArr, strings.Split(row, ""))
		}
	}

	var res int

	exit := false
	for !exit {
		arr, cur := removePaper(mapArr)
		mapArr = arr
		res += cur
		if cur == 0 {
			exit = true
		}
	}

	fmt.Println(res)

}

func removePaper(m [][]string) ([][]string, int) {
	count := 0
	n := make([][]string, len(m))

	for i, row := range m {
		n[i] = make([]string, len(row))
		copy(n[i], row)
	}

	// printMap(n)

	for i := range m {
		for j := 0; j < len(m[i]); j++ {
			if m[i][j] == "@" && getNumInNeighbours(m, i, j) < 5 {
				n[i][j] = "x"
				count += 1
			}
		}
	}
	// fmt.Println()
	return n, count
}

func getNumInNeighbours(m [][]string, i int, j int) int {
	count := 0
	a := []int{-1, 0, 1}
	for _, dx := range a {
		ni := i + dx
		if ni >= len(m) || ni < 0 {
			continue
		}
		for _, dy := range a {
			nj := j + dy
			if nj >= len(m[0]) || nj < 0 {
				continue
			}
			if m[ni][nj] == "@" {
				count += 1
			}
		}
	}
	return count
}

func printMap(m [][]string) {
	for _, row := range m {
		fmt.Println(strings.Join(row, ""))
	}

}
