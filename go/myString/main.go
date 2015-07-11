package main

import (
	"fmt"
	"strings"
)

func main() {

	//check if any character is there or not
	fmt.Println(strings.Contains("test", "e"))

	//count a char
	fmt.Println(strings.Count("test", "t"))

	fmt.Println(
		// true
		strings.Contains("test", "es"),
		// 2
		strings.Count("test", "t"),
		// true
		strings.HasPrefix("test", "te"),
		// true
		strings.HasSuffix("test", "st"),
		// 1
		strings.Index("test", "e"),
		// "a-b"
		strings.Join([]string{"a", "b"}, "-"),
		// == "aaaaa"
		strings.Repeat("a", 5),
		// "bbaa"
		strings.Replace("aaaa", "a", "b", 2),
		// []string{"a","b","c","d","e"}
		strings.Split("a-b-c-d-e", "-"),
		// "test"
		strings.ToLower("TEST"),
		// "TEST"
		strings.ToUpper("test"),
	)

	arr := []byte("test")
	fmt.Println(arr) //will give bytes or sring in array

	str := string([]byte{'t', 'e', 's', 't'})
	fmt.Println(str)
}
