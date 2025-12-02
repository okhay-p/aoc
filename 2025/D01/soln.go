package main

import (
	"fmt"
	"os"
	"math"
	"strings"
	"strconv"
)

func main() {
	content, err := os.ReadFile("input.txt")
	if err != nil {
		fmt.Println("Error reading file:", err)
		return
	}
	lines := strings.SplitSeq(string(content), "\n")

	dial := 50
	prev := dial
	var count int

	for line := range lines {
		line = strings.TrimSpace(line)
		val, err := strconv.Atoi(line[1:])
		if err != nil{
			fmt.Println("Error parsing int:", err)
		}
		fmt.Println(line)
		prev = dial
		fmt.Println("prev:", prev)
		if line[0] == 'L' {
			dial -= val
		} else {
			dial += val
		}
		count += int(math.Abs(float64(dial/100)))
		if dial <= 0 && prev != 0 {
			count++
		}
	    dial %= 100
	    if dial < 0 {
			dial += 100
		}
		fmt.Println("d:", dial)
		fmt.Println("count:", count)
	}
	fmt.Println(count)
}
