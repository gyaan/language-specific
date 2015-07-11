package main

import "fmt"

func main() {

	//one way to write a for loop
	i := 1
	for i < 11 {
		fmt.Println(i)
		i++
	}

	//second way to write a fro loop

	for i := 1; i <= 10; i++ {
		var numberType string

		if i%2 == 0 {
			numberType = "even"
		} else {
			numberType = "odd"
		}

		fmt.Println(i, numberType)
	}

	//switch statment
	i = 1

	switch i {
	case 0:
		fmt.Println("one")
	case 1:
		fmt.Println("two")
	default:
		fmt.Println("default value")
	}

}
