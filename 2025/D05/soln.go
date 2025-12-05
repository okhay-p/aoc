package main

import (
	"fmt"
	"strings"
	"os"
)

func main() {
	content, _ := os.ReadFile("sample_input.txt")
	cs := strings.Split(string(content), "\n\n")
	ranges := cs[0]
	ids := cs[1]
	fmt.Println(ranges)
	fmt.Println(ids)

}
