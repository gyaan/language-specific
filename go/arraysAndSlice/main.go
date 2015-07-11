package main 
import (
	"fmt"
)

func main() {

//array slice and maps

//declare a array 
var x[5] int 
 x[4]=100
 fmt.Println(x)

//different for loop and type conversion 

 // create a array
 var X[10] float64

//add values to array
 X[1]=45.0
 X[2]=45.0
 X[3]=45.0
 X[4]=45.0
 X[5]=45.0



//for loop
var total float64 = 0
for _, value := range X {
total += value
}
fmt.Println(total / float64(len(x)))

//other way to create array
SSS:=[5]float64{95.0,93.0,77.0,82.0,83.0}

fmt.Println(SSS)

//slice :: slice a part of arrary

//declare slice 
var sl [] float64

fmt.Println(sl)
//create a slice
//sl:=make([]float64,5) //array of float64 with lenght 5

//sl:=make([]float64,5,10) //10 is the capacity of the slice

//another way to create slice is 
arr:=[]float64{1,2,3,4,5}
xx:=arr[0:2] //arr[min:max]

fmt.Println(xx)

//slice functions 
 
 //append
 slice1:=[]int{1,2,3}
 slice2:=append(slice1,4,5)
 fmt.Println(slice1,slice2)

 slice11:=[]int{1,2,3}
 slice21:=make([]int,2)
 copy(slice11,slice21)
 fmt.Println(slice11,slice21)

// about map 

//declare map 
 // var m map[string]int
  //initailise the map other wise it will through run time error
  m:=make(map[string]int)

  m["key"]=10
  fmt.Println(m["key"])
  
  //delete a value from map 
  delete(m,"key")
  
  //will disply balnk array 
  fmt.Println(m)

 name, ok := m["Un"]  //will return two values first is result second is is value is there or not true or false
fmt.Println(name, ok)

//display the element 
if name, ok := m["Un"]; ok {
fmt.Println(name, ok)
}


//create map 
/*elements := map[string]string{
"H": "Hydrogen",
"He": "Helium",
"Li": "Lithium",
"Be": "Beryllium",
"B": "Boron",
"C": "Carbon",
"N": "Nitrogen",
"O": "Oxygen",
"F": "Fluorine",
"Ne": "Neon",
}
*/

}


