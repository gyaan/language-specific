package main
import "fmt"

//unsigned int values 
//uint8 uint16 uint32 uint64

//signed int values
//int8 int16 int32 int64  ::use int 

//float number 
//float32 float64 ::use flaot32


//have complex number also
//complex64 and complex128

//data type bolean true and false


func main() {
	
	fmt.Println("gyani");
	fmt.Println("1+1=",1+1)
	fmt.Println("1.0+1.0",1.0+1.0)
	fmt.Println(len("Hello World"))
	fmt.Println("Hello World"[1])
	fmt.Println("Hello "+ "World")

	//boolean 

	fmt.Println(true && true)
	fmt.Println(true && false)
	fmt.Println(true || true)
	fmt.Println(true || false)
	fmt.Println(!true)
	
}