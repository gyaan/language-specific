package main

import (
	"fmt"
	"math"
)

type Shape interface {
	area() float64
}

type circle struct {
	r float64
}

type rectangle struct {
	l, w float64
}

func totalArea(shapes ...Shape) float64 {
	var area float64

	for _, value := range shapes {
		area += value.area()
	}
	return area
}

func (r *rectangle) area() float64 {
	return r.l * r.w
}

func (c *circle) area() float64 {
	return math.Pi * c.r * c.r
}

func main() {

	cr := new(circle)
	cr.r = 4.0

	rec := new(rectangle)
	rec.l = 5.0
	rec.w = 6.0

	area := totalArea(cr, rec)

	fmt.Println(area)

}
