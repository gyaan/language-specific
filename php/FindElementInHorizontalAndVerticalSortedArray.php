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
	
	public function __construct($matrixArray,$numberOfRows,$numberOfColumn,$searchElementInMatrix){

		$this->matrix = $matrixArray;
		$this->rows = $numberOfRows;
		$this->column=$numberOfColumn;
		$this->searchElement=$searchElementInMatrix;
		
	}
	
   public function findGivenElement(){
   	
   	   $i=0; $j=$this->column-1;
   	   
   	   while($i<=$this->rows-1 && $j>=0){  //travers from right top corner to left bottom
   	   	
   	   	    if($this->matrix[$i][$j]==$this->searchElement)
   	   	    	return true;
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
$column = 10;
$rows = 30;
 for($i=0;$i<$rows;$i++)
 	for($j=0;$j<$column;$j++)
 		$myMatrix[$i][$j]=(int)$i+$j;

//$searchKey=300;  not found
$searchKey=21; //found
$myClassObject = new FindElementInHorizontalAndVerticalSortedArray($myMatrix,$rows,$column,$searchKey);
$find=$myClassObject->findGivenElement();

if($find)
	echo "found this element";
else 
	echo "not found element";


