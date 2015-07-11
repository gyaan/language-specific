package main

import (
	"fmt"
	"math"
)

//define a structure
type Circle struct {
	r float64
}

func main() {
	a := 10
	makeItZero(&a)
	fmt.Println(a)

	xPtr := new(int)
	two(xPtr)
	fmt.Println(*xPtr)

	//intialise struct

	c := Circle{6}
	area := circleArea(c)
	//pass struct to a function and calculate values
	fmt.Println(area)

	//print struct values
	fmt.Println(c.r)

	//implementation of strct methods
	r := Rectangle{0, 0, 10, 10}
	fmt.Println("are of ractange")
	fmt.Println(r.area())
}

func circleArea(c Circle) float64 {
	return (math.Pi * c.r * c.r)

}

func makeItZero(a *int) {
	*a = 0
}

//new key word :: create memory to store that
//of variable

func two(a *int) {
	*a = 2
}

//methods for struct

//create a racktange
type Rectangle struct {
	x1, y1, x2, y2 float64
}

func (r *Rectangle) area() float64 {
	l := distance(r.x1, r.y1, r.x1, r.y2)
	w := distance(r.x1, r.y1, r.x2, r.y2)
	return l * w
}

func distance(x1, y1, x2, y2 float64) float64 {
	a := x2 - x1
	b := y2 - y1
	return math.Sqrt(a*a + b*b)
}
