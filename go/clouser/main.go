package main 

import (
	"fmt"
)

func main() {
   
   arr:=[]float64{ 3.0,4.0,8.0,19.0,20.0}

   // fmt.Println(arr)
   // fmt.Println(len(arr))
   average:=myAverage(arr)
   fmt.Println(average)

    //multiple return values
    x, y:=multipleReturnValues()
    fmt.Println(x,y)

    //take any number of parameters 
    t:=add(1,2,3,4)
    fmt.Println(t)

    //example of clouser in this way we can have other variable also availble 
    //inside that function
    add:=func (x,y int) int {
    	return x+y
    }

    fmt.Println(add(1,1))
   
     //call recursive function
    fmt.Println(factorial(4))

    //implmentation of differ 
    //f1 wil fallowed f2 execuation 
    defer f1()
    f2()
    
     //handle runtime error lets say create a panic run
     //time error and recover that 
     defer func(){
     	str:=recover()
     	fmt.Println(str)
     }()
     panic("panic")
    
}

//always pass the exact type of parameter in declaration and defination even no of ele
func myAverage(xs []float64) float64{
   total :=0.0
   for _, v:=range xs{
   	total +=v
   }
    // panic("not implemented") //panic is for run time error
   return total/float64(len(xs))

}


//function which return mulitple values 
func multipleReturnValues() (int, int) {
     return 20,21	
}

//variadic functins :: pass any number of parameters 
func add(args ...int) int {
	total :=0
	for _, v:=range args{
	total+=v	
	}
	return total	
}

//recursion 

func factorial(x uint) uint {

	if x==0{
		return 1
	}
	return x*factorial(x-1)
}

func f1() {
	fmt.Println("f1")
}

func f2() {
    fmt.Println("f2")	
}