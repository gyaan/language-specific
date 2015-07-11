package main

import "fmt"

type Person struct {
	name string
}

func (p *Person) talk() {
	fmt.Println("Hi my name is", p.name)
}

type android struct {
	person Person
	model  string
}

func main() {

	per := new(android)
	per.name = "gyani"
	per.talk()

}
