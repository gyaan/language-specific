package main

import (
	"fmt"
	m "math"

	"github.com/gyaan/myPractice/myPackage/math"
)

func main() {
	fmt.Println("hi gyani")
	xs := []float64{1, 2, 3, 4}
	avg := math.Average(xs)
	fmt.Println(avg)
	fmt.Println(m.MaxInt32)
}
