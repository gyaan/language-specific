<?php
/**
 * Created by JetBrains PhpStorm.
 * User: gyani
 * Date: 28/3/15
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */

class MyArrayIterator implements  Iterator {

    private $Arr;


    /**
     * (PHP 5 &gt;= 5.0.0)<br/>
     * Return the current element
     * @link http://php.net/manual/en/iterator.current.php
     * @return mixed Can return any type.
     */


    public function __construct($array){
        $this->Arr=$array;
    }


    public function current()
    {
        return current($this->Arr);
    }

    /**
     * (PHP 5 &gt;= 5.0.0)<br/>
     * Move forward to next element
     * @link http://php.net/manual/en/iterator.next.php
     * @return void Any returned value is ignored.
     */
    public function next()
    {
        next($this->Arr);
    }

    /**
     * (PHP 5 &gt;= 5.0.0)<br/>
     * Return the key of the current element
     * @link http://php.net/manual/en/iterator.key.php
     * @return mixed scalar on success, or null on failure.
     */
    public function key()
    {
        return key($this->Arr);
    }

    /**
     * (PHP 5 &gt;= 5.0.0)<br/>
     * Checks if current position is valid
     * @link http://php.net/manual/en/iterator.valid.php
     * @return boolean The return value will be casted to boolean and then evaluated.
     * Returns true on success or false on failure.
     */
    public function valid()
    {
        return $this->key() !== null;
    }

    /**
     * (PHP 5 &gt;= 5.0.0)<br/>
     * Rewind the Iterator to the first element
     * @link http://php.net/manual/en/iterator.rewind.php
     * @return void Any returned value is ignored.
     */
    public function rewind()
    {
        return reset($this->Arr);
    }
}

//lets play with iterator

$myArray= array();

for($i=0;$i<=23;$i++)
    $myArray[]=$i+2;


//display values using iterator
$ArrayIterator = new MyArrayIterator($myArray);
while($ArrayIterator->valid()){
    echo $ArrayIterator->key().":".$ArrayIterator->current()."\n";
     $ArrayIterator->next();
}
