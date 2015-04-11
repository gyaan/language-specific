<?php
/**
 * @author gyani
 *
 */
Class FindElementInHorizontalAndVerticalSortedArray{
	
	private $matrix = array();
	private $rows;
	private $column;
	private $searchElement;
	
	public function __construct($matrixArray,$nuberOfRows,$numberOfColumn,$searchElementInMatrix){

		$this->matrix = $matrixArray;
		$this->rows = $nuberOfRows;
		$this->column=$numberOfColumn;
		$this->searchElement=$searchElementInMatrix;
		
	}
	
   public function findGivenElement(){
   	
   	   $i=0; $j=$this->column;
   	   
   	   while($i>$this->rows && $j>0){  //travers from right top corner to left bottom 
   	   	
   	   	    if($this->matrix[$i][$j]==$this->searchElement)
   	   	    	return ture;
   	   	    else if($this->matrix[$i][$j]>$this->searchElement)
   	   	    	$j--;
   	   	    else 
   	   	    	$i++;
   	   	
   	   }

   	   return false;
   }
	
}

//lets play with above mention class 

//create a matrix 


$myMatrix=array();
$column = 30;
$rows = 30;
 for($i=0;$i<$rows;$i++)
 	for($j=0;$j<$column;$j++)
 		$myMatrix[$i][$j]=(int)$i+$j;

$myClassObject = new FindElementInHorizontalAndVerticalSortedArray($myMatrix,$rows,$column,5);
$find=$myClassObject.findGivenElement();

if($find)
	echo "found this element";
else 
	echo "not found element";


