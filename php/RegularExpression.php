<?php
/**
 * Created by JetBrains PhpStorm.
 * User: gyani
 * Date: 28/3/15
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */

//identifiers
/*

\d : any number
\D : anything but number

\s : space
\S : anything but space

\w : word(letters)
\W : anything but word(letters)

.  :  any character except new line

\b : space between the words
\. : to use period

modifiers
[] : rang
{} : rang no of occurrence
+  : 1 or more
?  : 0 or more
*  : 0 or more
$  : match end of a string
^  : match start of a string
|  : matches either a | b
[] : can specify rang

{X}: this amount of proceding code

white space character
\n  = newline
\s = space
\t = tab
\e = escape
\t carriage return
\ f = form feed

escape required
. + * ? [] $ ^ () {} \/



//there are some char i have to scap

*/

$s = 'prices xcm 91.43-91.44/vz50-50.01/s 7.23-7.24';

preg_match_all("/\w{1,3}\s?\d{1,2}\.?\d{1,2}-\d{1,2}\.\d{1,2}/","prices xcm 91.43-91.44/vz50-50.01/s 7.23-7.24",$aa, PREG_SET_ORDER);
print_r($aa);

$str="gyaan_1334 @gmail.com";
$rex='[a-z1-9A-Z]+@{1}[a-z1-9A-Z]/.[a-z1-9A-Z]';
preg_match_all('/[a-z1-9A-Z]*@{1}[a-z1-9A-Z]*\.[a-z1-9A-Z]*/',"gyaan1334@gmail.com",$a, PREG_SET_ORDER);
print_r($a);

?>