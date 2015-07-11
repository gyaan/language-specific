package scop
import "fmt"

//scope outside the function 
//scope of a variable is always inside of {}
var x string = "gyaneshwar pardhi"

func f() {

    fmt.Println(x)	
}