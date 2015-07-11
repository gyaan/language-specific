package main


import (
	"fmt"
	// "github.com/gyaan/myPractice/chapter4/scop"
)
func main() {


    //var x string = "Hello World"
     x:="hello world"
     //var x string
     //x = "what's up gyani"
     //x=5 not possible because var is string
     fmt.Println(x)
     x= "nothing dude simply learning golang"	
     fmt.Println(x)

    //create constant 
     const Y string = "a constant value"
     fmt.Println(Y)
     // var b string = scop.f();
     // fmt.Println(b)

//define multiple variable together 
     var (
     	a = 4
     	b = 10 
     	c = 15
     )
}    