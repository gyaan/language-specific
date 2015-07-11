package myInt

type Shape interface {
	area() float64
}

func totalArea(shapes ...Shape) float64 {
	var area float64

	for _, value := range shapes {
		area += value.area()
	}
	return area
}
